package com.restaurant.repository;

import com.restaurant.model.DishEntity;
import com.restaurant.model.MenuTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTypeRepository extends JpaRepository<MenuTypeEntity, Long> {

}
