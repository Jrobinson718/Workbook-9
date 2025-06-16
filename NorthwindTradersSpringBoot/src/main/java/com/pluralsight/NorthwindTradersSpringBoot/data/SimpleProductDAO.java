package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleProductDAO implements ProductDAO{

    private HashMap<Integer, Product> products = new HashMap<Integer, Product>();

    public SimpleProductDAO() {
        this.products.put(1, new Product(1, "Ice Cream", "Food", 12.18));
        this.products.put(2, new Product(2, "Cinnamon Toast Crunch", "Food", 7.50));
        this.products.put(3, new Product(3, "Hat", "Clothing", 14));
        this.products.put(4, new Product(4, "Watch", "Accessories", 40));
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getProductId(), product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<Product>(this.products.values());
    }
}
