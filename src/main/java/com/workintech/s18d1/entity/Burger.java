
package com.workintech.s18d1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="burger", schema = "burgerschema")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name="name")
private String name; 

@Column(name="price")
private Double price;

@Column(name="is_vegan") 
private boolean isVegan;


@Column(name="bread_type")
@Enumerated(EnumType.STRING)
BreadType breadType; 

@Column(name="contents")
private String contents;

public void setIsVegan(boolean isVegan) {
    this.isVegan = isVegan;
}

public void setVegan(boolean vegan) {
    this.isVegan = vegan;
}

public boolean isVegan() {
    return isVegan;
}

public boolean getIsVegan() {
    return isVegan;
}



}




