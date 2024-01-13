package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //since we need to call the attributes and methods of productService in productController class, so for that we need object of productService

    //private ProductService productService= new FakeStoreProductService(), instead I will use dependency injection
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        //here we are using dependency injection
        this.productService = productService;
    }

    //we cannot use @GetMapping("/"), because it means localhost:8080/products/,
    // but we need to direct this request to localhost:8080/products

    //so, what if we don't use @Getmapping here, since its the same

    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
//    public  Product getSingleProduct(@PathVariable("id") Long couldBeAnything){
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setTitle("A new product");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    //how are we updating the product details in put and patch mapping while in post we explicitly did that

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }
}
