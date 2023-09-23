package com.masai.evaluation4.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "name cannot be null")
    private String name;

    @Email(message = "email cannot be null")
    private Integer email;

    @NotNull(message = "password is needed")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "role cannot be null")
    private String role;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Booking> booking;

}
