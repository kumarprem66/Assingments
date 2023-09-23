package com.masaischool.swiggy3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @NotNull(message="value can not be null")
    private String customerId;
    @NotNull(message="value can not be null")
    private String restaurantId;
    @NotNull(message="value can not be null")
    private String deliveryPartnerId;
    @NotNull(message="value can not be null")
    private List<String> items;
    @NotNull(message="value can not be null")
    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant ;
    @ManyToOne(cascade = CascadeType.ALL)
    private DeliveryPartner deliveryPartner ;
}
