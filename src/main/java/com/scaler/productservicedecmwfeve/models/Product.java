package com.scaler.productservicedecmwfeve.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    //id has to be long not int which stores 10^9 while latter stores 10^18
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
}
