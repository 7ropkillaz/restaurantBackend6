package com.restaurant.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class RestaurantEntity {

    @Id
    private long restId;

    private String address;

    private String restName;

    @OneToMany(mappedBy = "restaurantId", fetch = FetchType.EAGER)
    private Set<RestaurantMenuEntity> restaurantMenuEntitySet;

}
