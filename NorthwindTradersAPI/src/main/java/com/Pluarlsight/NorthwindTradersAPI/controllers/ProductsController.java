package com.Pluarlsight.NorthwindTradersAPI.controllers;

import com.Pluarlsight.NorthwindTradersAPI.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "T-Shirt", 2, 5.99));
        return products;
    }


    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public List<Product> getProducts(@PathVariable int productId) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "T-Shirt", 2, 5.99));

        return products.stream().filter(p -> p.getProductId() == productId).toList();
    }
}
