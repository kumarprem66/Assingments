package com.masai.evaluation4.controller;

import com.masai.evaluation4.entities.*;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface ControllerInterface {

    ResponseEntity<User> registerUserHandler(User user);
    void doBookingHandler(Integer userId, Booking booking);
    void addRoomToBookingHandler(Integer userId, Integer bookingId, Room room);
    void updateBookingDetailsHandler(Integer userId, Integer bookingId, Date date, Integer duration, Integer num_of_guest);
    ResponseEntity<List<Booking>> userBookingHistoryHandler(Integer userId);
    ResponseEntity<List<Property>> recommendPropertyHandler(Integer userId);

    ResponseEntity<Host> addHostHandler(Host host);

    ResponseEntity<Property> addPropertyToHostHandler(Property property);

    ResponseEntity<Room> addRoomsHandler(Room room,Integer propertyId);

    ResponseEntity<User> addNewUsersHandler(User user);

    ResponseEntity<String> deleteBookingHandler(Integer bookingId);

   ResponseEntity<List<User>> getUsersHandler();

    ResponseEntity<List<Property>> getPropertyHandler();

    ResponseEntity<List<Room>> getRoomsHandler();



}
