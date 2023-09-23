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
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostId;

    @NotNull(message = "name cannot be null")
    private String name;

    @Email(message = "email format is wrong")
    private String email;

    @ManyToMany(mappedBy = "host",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Property> property;

}
