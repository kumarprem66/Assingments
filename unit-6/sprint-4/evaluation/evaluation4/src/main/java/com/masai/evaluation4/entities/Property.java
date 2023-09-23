package com.masai.evaluation4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "host cannot be null")
    private Integer hostId;

    @NotNull(message = "location is needed")
    private String location;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Host> host;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Room> room;
}
