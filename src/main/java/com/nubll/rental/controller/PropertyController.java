package com.nubll.rental.controller;


import com.nubll.rental.models.Property;
import com.nubll.rental.models.User;
import com.nubll.rental.service.PropertyServiceImpl;
import com.nubll.rental.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {


    @Autowired
    private PropertyServiceImpl rentalService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/get-listings")
    public ResponseEntity<List<Property>> getAllProperties(){
        return new ResponseEntity<List<Property>>(rentalService.getAllProperties(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody User user){
        return new ResponseEntity<String>(userService.register(user), HttpStatus.CREATED);
    }


    @PostMapping("/post-listing")
    public ResponseEntity<Property> addProperty(@Validated @RequestBody Property property){
        return new ResponseEntity<Property>(rentalService.saveProperty(property),HttpStatus.CREATED);
    }

    @GetMapping("/filter/city")
    public ResponseEntity<List<Property>> filterByCity(@RequestParam String city){
        return new ResponseEntity<>(rentalService.searchByCity(city),HttpStatus.OK);
    }

    @GetMapping("/filter/state")
    public ResponseEntity<List<Property>> filterByState(@RequestParam String state){
        return new ResponseEntity<>(rentalService.searchByState(state),HttpStatus.OK);
    }


}

