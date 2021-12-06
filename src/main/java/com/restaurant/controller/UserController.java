package com.restaurant.controller;

import com.restaurant.model.*;
import com.restaurant.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MenuTypeRepository menuTypeRepository;


    @GetMapping("/get-all-rest")
    public ResponseEntity<List<RestaurantEntity>> getAllRestaurant(){
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-restaurant/{restaurantId}")
    public ResponseEntity<RestaurantEntity> getRestaurantById(@PathVariable("restaurantId") Long restaurantId){
        return new ResponseEntity<>(restaurantRepository.getById(restaurantId), HttpStatus.OK);
    }

    @GetMapping("/get-menulist/{restaurantId}")
    public ResponseEntity<List<RestaurantMenuEntity>> getMenuListByRestaurantById(@PathVariable("restaurantId") Long restaurantId){
        return new ResponseEntity<>(restaurantMenuRepository.findRestaurantMenuEntitiesByRestaurantId(restaurantId), HttpStatus.OK);
    }

    @GetMapping("/get-menu/{menuId}")
    public ResponseEntity<MenuEntity> getMenuById(@PathVariable("menuId") Long menuId){
        return new ResponseEntity<>(menuRepository.getById(menuId), HttpStatus.OK);
    }

    @GetMapping("/get-dish/{menuId}")
    public ResponseEntity<DishEntity> getDishById(@PathVariable("menuId") Long menuId){
        return new ResponseEntity<>(dishRepository.getDishEntityByMenuId(menuId), HttpStatus.OK);
    }

    @GetMapping("/get-menutype/{menutypeId}")
    public ResponseEntity<MenuTypeEntity> getMenuTypeById(@PathVariable("menutypeId") Long menuTypeId){
        return new ResponseEntity<>(menuTypeRepository.getById(menuTypeId), HttpStatus.OK);
    }




}
