package com.nubll.rental.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "renters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    @NotNull
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Property.class)
    private List<Property> propertyList;


}
