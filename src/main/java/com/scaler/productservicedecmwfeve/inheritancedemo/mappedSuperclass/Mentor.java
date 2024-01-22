package com.scaler.productservicedecmwfeve.inheritancedemo.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_Mentor")
public class Mentor extends User {
    private double averageRating;
}
