package com.scaler.productservicedecmwfeve.inheritancedemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_mentor")
public class Mentor extends User {
    private double averageRating;
}

//Inheritance strategy should be only present in the parent class
