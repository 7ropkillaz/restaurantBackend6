package com.restaurant.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class MenuEntity {

    @Id
    private long menuId;
    private String menuDescription;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "menuTypeId_menuId_fk")
    private MenuTypeEntity menuType;

    @OneToMany(mappedBy = "menuId", fetch = FetchType.EAGER)
    private Set<RestaurantMenuEntity> menuEntitySet = new HashSet<>();

    @OneToMany(mappedBy = "menuId", fetch = FetchType.EAGER)
    private Set<DishEntity> dishEntitySet = new HashSet<>();
}
