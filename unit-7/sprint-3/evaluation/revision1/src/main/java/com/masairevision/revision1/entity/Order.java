package com.masairevision.revision1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @NotEmpty(message = "id should not be empty")
    private Integer productId;

    private LocalDate orderDate;

    private ProductStatus productStatus;

    private boolean status;

    private boolean isPaymentMade;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

}
