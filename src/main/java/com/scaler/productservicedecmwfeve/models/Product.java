package com.scaler.productservicedecmwfeve.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private Long id;
//    now we will put all the common attributes in the parent class i.e. BaseModel
    //id has to be long not int which stores 10^9 while the latter stores 10^18
    private String title;
    private Double price;
    @ManyToOne
    private Category category;
    private String description;
    private String imageUrl;
}


//Product:Category :: m:1
