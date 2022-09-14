package com.nubll.rental.service;

import com.nubll.rental.models.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getAllProperties();
    List<Property> getUserProperties(String username);

    List<Property> searchByState(String state);

    List<Property> searchByCity(String city);

    Property saveProperty(Property property);
}
