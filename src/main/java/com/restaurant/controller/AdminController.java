package com.restaurant.controller;

import com.restaurant.model.DishEntity;
import com.restaurant.model.MenuEntity;
import com.restaurant.model.MenuTypeEntity;
import com.restaurant.model.RestaurantEntity;
import com.restaurant.repository.DishRepository;
import com.restaurant.repository.MenuRepository;
import com.restaurant.repository.MenuTypeRepository;
import com.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;
    private final MenuTypeRepository menuTypeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public AdminController(RestaurantRepository restaurantRepository, DishRepository dishRepository, MenuTypeRepository menuTypeRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.menuRepository = menuRepository;
    }

    @PostMapping("/create-rest")
    public ResponseEntity createRestaurant(@RequestBody RestaurantEntity restaurant) {
        restaurantRepository.save(restaurant);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update-rest")
    public ResponseEntity updateRestaurant(@RequestBody RestaurantEntity restaurant) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurant.getRestId()).orElseThrow();
        restaurantEntity.setRestName(restaurant.getRestName());
        restaurantEntity.setAddress(restaurant.getAddress());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-rest")
    public ResponseEntity deleteRestaurant(@RequestBody RestaurantEntity restaurant) {
        restaurantRepository.delete(restaurant);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/create-dish")
    public ResponseEntity createDish(@RequestBody DishEntity dish) {
        dishRepository.save(dish);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update-dish")
    public ResponseEntity updateDish(@RequestBody DishEntity dish) {
        DishEntity dishEntity = dishRepository.findById(dish.getDishId()).orElseThrow();
        dishEntity.setDishName(dish.getDishName());
        dishEntity.setDishIngredients(dish.getDishIngredients());
        dishEntity.setDishWeight(dish.getDishWeight());
        dishEntity.setDishPrice(dish.getDishPrice());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-dish")
    public ResponseEntity deleteDish(@RequestBody DishEntity dish) {
        dishRepository.delete(dish);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/create-menutype")
    public ResponseEntity createMenuType(@RequestBody MenuTypeEntity menu) {
        menuTypeRepository.save(menu);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update-menutype")
    public ResponseEntity updateMenuType(@RequestBody MenuTypeEntity menu) {
        MenuTypeEntity menuTypeEntity = menuTypeRepository.findById(menu.getMenuTypeId()).orElseThrow();
        menuTypeEntity.setNameMenuType(menu.getNameMenuType());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-menutype")
    public ResponseEntity deleteMenuType(@RequestBody MenuTypeEntity menu) {
        menuTypeRepository.delete(menu);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/create-menu")
    public ResponseEntity createMenu(@RequestBody MenuEntity menu) {
        menuRepository.save(menu);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update-menu")
    public ResponseEntity updateMenu(@RequestBody MenuEntity menu){
        MenuEntity menuEntity = menuRepository.findById(menu.getMenuId()).orElseThrow();
        menuEntity.setMenuDescription(menu.getMenuDescription());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-menu")
    public ResponseEntity deleteMenu(@RequestBody MenuEntity menu){
        menuRepository.delete(menu);
        return new ResponseEntity(HttpStatus.OK);
    }


}
