package com.scaler.productservicedecmwfeve.inheritancedemo.joinedTable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Instructor extends User{
    private String favouriteStudent;
}
