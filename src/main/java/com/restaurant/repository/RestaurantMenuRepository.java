package com.restaurant.repository;

import com.restaurant.model.RestaurantMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenuEntity, Long> {
List<RestaurantMenuEntity> findRestaurantMenuEntitiesByRestaurantId(long restaurantId);



}
