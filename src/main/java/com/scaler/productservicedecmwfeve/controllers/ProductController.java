package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Product>> getAllProducts() {

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProduct(), HttpStatus.OK
        );
        return response;
    }

    @GetMapping("/{id}")
//    public  Product getSingleProduct(@PathVariable("id") Long couldBeAnything){
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistException {
//        try{
        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK);
//        } catch (ArithmeticException exception){
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        }
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    //how are we updating the product details in put and patch mapping while in post we explicitly did that

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<Void> handleProductNotExistException(){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    //IN this case we have two exception handlers one in the controller class(i.e. the above one) another in the controlleradvices(global level),
    // then the class level exception handler will be called.
}
