package com.masai.evaluation4.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @NotNull(message = "userid cannot be null")
    private String userId;

    @NotNull(message = "email cannot be null")
    private List<Integer> rooms;

    @NotNull(message = "password is needed")
    private Date date;

    @NotNull(message = "duration cannot be null")
    private Integer duration;

    @NotNull(message = "guest cannot be null")
    private Integer num_of_guest;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User users;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<Room> room;
}
