package com.scaler.productservicedecmwfeve.inheritancedemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="jt_intructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User{
    private String favouriteStudent;
}

//In joined table, only the attributes of child is present and a foreign key to the parent table.