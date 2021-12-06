package com.restaurant.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table
public class RestaurantMenuEntity {

    @EmbeddedId
    private RestaurantMenuPKEntity menuListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuId_menuListId_fk", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MenuEntity menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restId_menuListId_fk", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RestaurantEntity restaurantId;


}
