package com.scaler.productservicedecmwfeve.inheritancedemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="tbc_instructor")
public class Instructor extends User {
    private String favouriteStudent;
}
