package com.masai.evaluation4.services;

import com.masai.evaluation4.entities.*;

import java.sql.Date;
import java.util.List;

public interface BookingService {

    void registerUser(User user);
    void doBooking(Integer userId, Booking booking);
    void addRoomToBooking(Integer userId, Integer bookingId, Room room);
    void updateBookingDetails(Integer userId, Integer bookingId, Date date,Integer duration,Integer num_of_guest);
    List<Booking> userBookingHistory(Integer userId);
    List<Property> recommendProperty(Integer userId);

    void addHost(Host host);

    void addPropertyToHost(Property property);

    void addRooms(Room room,Integer propertyId);

    void addNewUsers(User user);

    String deleteBooking(Integer bookingId);

    List<User> getUsers();

    List<Property> getProperty();

    List<Room> getRooms();


    User getUserByEmail(String email);


}
