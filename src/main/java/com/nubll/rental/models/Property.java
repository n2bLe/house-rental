package com.nubll.rental.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "props")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_id")
    private User owner;

    @NotNull
    private String host;

    @NotNull
    private String type;

    @NotNull
    private String state;
    @NotNull
    private String city;
    @NotNull
    private String address;

    @NotNull
    private Integer price;
    @NotNull
    private String description;

    private String extras;
    private int bedrooms;
    private int bathrooms;
    private int living_rooms;
    private int kitchens;
    private int floors;
    private String area;
    private int garages;
    private boolean garden;
    private int likes;
}
