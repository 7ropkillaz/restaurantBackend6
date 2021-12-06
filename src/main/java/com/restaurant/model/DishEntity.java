package com.restaurant.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class DishEntity {
    @Id
    private long dishId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "dishId_menuId_fk")
    private MenuEntity menuId;

    private String dishName;
    private String dishIngredients;
    private double dishWeight;
    private double dishPrice;
}
