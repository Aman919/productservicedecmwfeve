package com.scaler.productservicedecmwfeve.inheritancedemo.mappedSuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class  User {
    @Id
    private Long id;
    private String name;
    private String email;
}

//In mappedsuperclass, the attributes of the parent is placed with all its child class,
//and the table of the parent is not created
