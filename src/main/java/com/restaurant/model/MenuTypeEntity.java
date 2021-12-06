package com.restaurant.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class MenuTypeEntity {
    @Id
    private long menuTypeId;

    private String nameMenuType;

    @OneToMany(mappedBy = "menuType", fetch = FetchType.EAGER)
    private Set<MenuEntity> menuEntitySet = new HashSet<>();
}
