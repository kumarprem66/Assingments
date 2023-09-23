package com.masaischool.swiggy3.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryPartnerId;
    @NotNull
    private String name;
    @Size(min=10 , max=13 , message="length should be proper")
    private String phoneNumber;

    @OneToMany(mappedBy = "deliveryPartner" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Orders> orders ;

    @ManyToMany(mappedBy = "deliveryList")
    @JsonIgnore
    private List<Restaurant> restaurants = new ArrayList<>() ;




}
