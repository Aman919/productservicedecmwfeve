package com.scaler.productservicedecmwfeve.inheritancedemo.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="ms_Instructor")
public class Instructor extends User {
    private String favouriteStudent;
}
