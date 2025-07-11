package com.Pluarlsight.NorthwindTradersAPI.controllers;

import com.Pluarlsight.NorthwindTradersAPI.model.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Food"));
        categories.add(new Category(2, "Clothes"));

        return categories;
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public List<Category> getCategories(@PathVariable int categoryId) {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Food"));
        categories.add(new Category(2, "Clothes"));

        return categories.stream().filter(c -> c.getCategoryId() == categoryId).toList();
    }

}
