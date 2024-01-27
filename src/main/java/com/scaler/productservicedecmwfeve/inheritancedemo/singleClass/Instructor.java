package com.scaler.productservicedecmwfeve.inheritancedemo.singleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value="2")
public class Instructor extends User {
    private String favouriteStudent;
}
