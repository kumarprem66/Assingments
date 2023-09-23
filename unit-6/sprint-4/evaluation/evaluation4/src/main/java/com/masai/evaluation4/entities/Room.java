package com.masai.evaluation4.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "propertyId cannot be null")
    private Integer propertyId;

    @NotNull(message = "price is needed")
    private String price;

    @NotNull(message = "status cannot be null")
    private Status status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Booking booking;


}
