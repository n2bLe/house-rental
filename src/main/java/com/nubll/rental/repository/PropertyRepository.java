package com.nubll.rental.repository;

import com.nubll.rental.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

    List<Property> findByType(String type);
    List<Property> findByPrice(Integer price);

    List<Property> findByState(String state);
    List<Property> findByCity(String city);
}
