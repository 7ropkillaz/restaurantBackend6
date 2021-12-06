package com.restaurant.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class RestaurantMenuPKEntity implements Serializable {


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "restId_menuListId_fk")
    private RestaurantEntity restId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "menuId_menuListId_fk")
    private MenuEntity menuId;
}
