package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId((fakeStoreProduct.getId()));
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        //I don't understand category part, please check the below lines
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistException {
//int a = 1/0;
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        //since class datatype is Product and we are getting FakeStoreProductDto, so we have to convert the dto to Product


        if (productDto == null) {
            //here we are calling the constructor of ProductNotExistException
            throw new ProductNotExistException(
                    "Product with id " + id + " doesn't exist.");
        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProduct() {
//        List<FakeStoreProductDto> response = restTemplate.getForObject("https://fakestoreapi.com/products",
//                List<FakeStoreProductDto>.class);
//        this will not work due to generics and type erasure, which means at runtime List<T>, T does not known at the runtime, this T is checked only at the compile time
//        and when it is used at the runtime, and its definition is not known to the compiler at runtime, it throws error, so we need to use Array, as this error does not occurs in array
//
//        so List will not work but Array will work, so I am using below


        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

//    List<Product> products =  Arrays.asList(productDto).stream().map(this::convertFakeStoreProductToProduct).collect(Collectors.toList());
        List<Product> answer = new ArrayList<>();
        for (FakeStoreProductDto dto : response) {
            answer.add(convertFakeStoreProductToProduct(dto));
        }
        return answer;
    }

    //Q.wherever I am passing argument, I am using Product product, but not using FakeStoreProductDto, why is that?

    @Override
    public Product addNewProduct(Product product) {
        Product createdProduct = restTemplate.postForObject("https://fakestoreapi.com/products", product, Product.class);
        return createdProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, product, Product.class);

    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        //since PUT method would not let us take a json, which will be given by FakeStoreApi, so we need to use a lower level method.

//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setTitle(product.getTitle());
//        fakeStoreProductDto.setPrice(product.getPrice());
//        fakeStoreProductDto.setImage(product.getImageUrl());
//        fakeStoreProductDto.setDescription(product.getDescription());
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(response);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }


}
