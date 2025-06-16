package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDAO implements  ProductDAO{

    private DatabaseConfig databaseConfig;

    @Autowired
    public MySqlProductDAO(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        BasicDataSource bds = new BasicDataSource();

        bds.setUsername(databaseConfig.getUsername());
        bds.setPassword(databaseConfig.getPassword());
        bds.setUrl(databaseConfig.getURL());

        String query = """
                select
                p.productId,
                p.productName,
                CategoryName,
                p.UnitPrice
                from
                	products p
                join
                	categories c on p.CategoryID = c.CategoryID
                	""";

        try (Connection connection = bds.getConnection();
             PreparedStatement statement = connection.prepareStatement("");
             ResultSet resultSet = statement.executeQuery(query))
        {
            while (resultSet.next()) {
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                String categoryName = resultSet.getString(3);
                double unitPrice = resultSet.getDouble(4);

                Product p = new Product(productId, productName, categoryName, unitPrice);
                products.add(p);
            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }

        return products;
    }
}
