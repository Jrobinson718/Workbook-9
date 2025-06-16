package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.data.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommandLineUI implements CommandLineRunner {

    private ProductDAO productDAO;
    private Console console;

    @Autowired
    public CommandLineUI(ProductDAO productDAO, Console console) {
        this.productDAO = productDAO;
        this.console = console;
    }

    @Override
    public void run(String... args) throws Exception{

        while (true){
            System.out.println();
            System.out.println();

            String[] menuOptions = {
                    "List Products",
                    "Add product",
                    "Exit"
            };

            int userChoice = console.promptForOption(menuOptions);

            switch (userChoice){
                case 1:
                    listProducts();
                    break;
                case 2:
                    // addProducts();
                    break;
                case 3:
                    System.exit(0);
            }

            console.promptForString("Please press <ENTER> to continue...", true);
        }
    }

    public void listProducts() {
        List<Product> products = productDAO.getAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

