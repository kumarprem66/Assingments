package com.masairevision.revision1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotEmpty(message = "name should not be empty")
    private String productName;

    private boolean status;

    @NotEmpty(message = "category should not be empty")
    private Category category;

    @NotEmpty(message = "price should not be empty")
    private double price;

    private String desc;


}
