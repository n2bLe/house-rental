package com.nubll.rental.service;

import com.nubll.rental.models.Property;
import com.nubll.rental.models.User;
import com.nubll.rental.repository.PropertyRepository;
import com.nubll.rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property saveProperty(Property property) {
        User user = userRepository.findByUsername(property.getHost());
        user.getPropertyList().add(property);
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> getUserProperties(String username) {
        return userRepository.findByUsername(username).getPropertyList();
    }

    @Override
    public List<Property> searchByState(String state) {
        return propertyRepository.findByState(state);
    }

    @Override
    public List<Property> searchByCity(String city) {
        return propertyRepository.findByCity(city);
    }


}
