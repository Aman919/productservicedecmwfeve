package com.scaler.productservicedecmwfeve.inheritancedemo.singleClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="1")
public class Mentor extends User {
    private double averageRating;
}

//In single class approach, the @Entity annotation will not make a table in db, It will only ensure the attributes of
// child are present in the parent table.
