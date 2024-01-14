package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();
    }

}
