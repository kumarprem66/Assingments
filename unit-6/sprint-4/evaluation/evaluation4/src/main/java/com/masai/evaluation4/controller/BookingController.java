package com.masai.evaluation4.controller;


import com.masai.evaluation4.entities.*;
import com.masai.evaluation4.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class BookingController implements ControllerInterface{


    @Autowired
    private BookingService bookingService;

    @Override
    @PostMapping("/users")

    public ResponseEntity<User> registerUserHandler(@RequestBody @Valid User user) {
        bookingService.registerUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/bookings/userId")
    @ResponseStatus(HttpStatus.OK)
    public void doBookingHandler(@RequestParam Integer userId,@RequestBody @Valid  Booking booking) {

        bookingService.doBooking(userId,booking);
    }

    @Override
    @PostMapping("/bookings/bookingId/userId")
    @ResponseStatus(HttpStatus.OK)
    public void addRoomToBookingHandler(@RequestParam Integer userId, @RequestParam Integer bookingId, @RequestBody @Valid Room room) {

        bookingService.addRoomToBooking(userId,bookingId,room);
    }

    @Override
    @PatchMapping("/bookings/bookingId/userId")
    @ResponseStatus(HttpStatus.OK)
    public void updateBookingDetailsHandler(@RequestParam Integer userId, @RequestParam Integer bookingId,@RequestBody Date date, @RequestBody Integer duration, @RequestBody Integer num_of_guest) {

        bookingService.updateBookingDetails(userId,bookingId,date,duration,num_of_guest);
    }

    @Override
    @GetMapping("/users/userId/bookings")

    public ResponseEntity<List<Booking>> userBookingHistoryHandler(@RequestParam Integer userId) {
        List<Booking> bookings = bookingService.userBookingHistory(userId);
        return new ResponseEntity<>(bookings,HttpStatus.OK);
    }

    @Override
    @PostMapping("/users/userId")
    public ResponseEntity<List<Property>> recommendPropertyHandler(Integer userId) {
        List<Property> propertyList = bookingService.recommendProperty(userId);
        return new ResponseEntity<>(propertyList,HttpStatus.OK);
    }

    @Override
    @PostMapping("/hosts")
    public ResponseEntity<Host> addHostHandler(@RequestBody Host host) {
      bookingService.addHost(host);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PostMapping("property/hostId")
    public ResponseEntity<Property> addPropertyToHostHandler(@RequestBody Property property) {

        bookingService.addPropertyToHost(property);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/rooms/propertyId")
    public ResponseEntity<Room> addRoomsHandler(@RequestBody @Valid Room room, @RequestParam Integer propertyId) {
        bookingService.addRooms(room,propertyId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PostMapping("/users/admin")
    public ResponseEntity<User> addNewUsersHandler(@RequestBody @Valid User user) {
        bookingService.addNewUsers(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/bookings/bookingId/admin")
    public ResponseEntity<String> deleteBookingHandler(Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("users/admin")
    public ResponseEntity<List<User>> getUsersHandler() {
        List<User> userList = bookingService.getUsers();
        return new ResponseEntity<>(userList,HttpStatus.CREATED);
    }

    @Override
    @GetMapping("properties/admin")
    public ResponseEntity<List<Property>> getPropertyHandler() {
        List<Property> propList = bookingService.getProperty();
        return new ResponseEntity<>(propList,HttpStatus.CREATED);
    }

    @Override
    @GetMapping("rooms/admin")
    public ResponseEntity<List<Room>> getRoomsHandler() {
        List<Room> roomList = bookingService.getRooms();
        return new ResponseEntity<>(roomList,HttpStatus.CREATED);
    }

    @GetMapping("/auth/login")
    public ResponseEntity<String> getLoggedInRestaurantDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details


        System.out.println(auth.getDetails().toString());

        User user= bookingService.getUserByEmail(auth.getName());

        return new ResponseEntity<>(user.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }
}
