package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.scaler.productservicedecmwfeve.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistException;

    List<Product> getAllProduct();

    Product addNewProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
