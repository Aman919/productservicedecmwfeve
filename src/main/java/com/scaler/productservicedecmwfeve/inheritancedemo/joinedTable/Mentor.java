package com.scaler.productservicedecmwfeve.inheritancedemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User{
    private double averageRating;
}

//In joined table, attributes of parent is not present in the child but the child
//classes will contain the user.id of parent.
//Here, user_id is the foreign key of User table.