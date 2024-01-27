package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class selfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public selfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistException {

        Optional<Product> productOptional = productRepository.findById(1l);

        if (productOptional.isEmpty()) {
            throw new ProductNotExistException("Product with id " + id + " doesn't exist.");
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {

//        Category category= product.getCategory();
//        if(category.getId()==null){
//            //the above if condition checks that if category is not saved yet, then it will first save the category and then return the product
//            Category savedCategory =categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
        //IN the above, we are using category id, while in below one, we are using name

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if (categoryOptional.isEmpty()) {
            product.setCategory(categoryRepository.save(product.getCategory()));
        } else {
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) throw new RuntimeException();

        Product savedProduct = productOptional.get();//this is the product OBject which is currently saved.

        if (product.getTitle() != null){
            //the above condition means the product which we receive in the request its title is not null, means we have to update it in the db.
        savedProduct.setTitle(product.getTitle());
        }

        if (product.getDescription() != null){
            savedProduct.setDescription(product.getDescription());
        }

        if (product.getPrice() != null){
            savedProduct.setPrice(product.getPrice());
        }

        if (product.getImageUrl() != null){
            savedProduct.setImageUrl(product.getImageUrl());
        }


        return productRepository.save(savedProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return true;
    }
}
