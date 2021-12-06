package com.restaurant.repository;

import com.restaurant.model.MenuEntity;
import com.restaurant.model.MenuTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
