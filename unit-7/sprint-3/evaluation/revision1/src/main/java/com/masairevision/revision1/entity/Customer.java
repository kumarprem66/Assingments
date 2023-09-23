package com.masairevision.revision1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotEmpty(message = "name should not be empty")
    private String customerName;

    @NotEmpty(message = "city should not be empty")
    private String city;

//    private Role role = Role.CUSTOMER;

    private boolean status;

    @NotEmpty(message = "password should not be empty")
    private String password;

    private Role role;

    @Email(message = "email is not valid")
    @NotEmpty(message = "email is must")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
