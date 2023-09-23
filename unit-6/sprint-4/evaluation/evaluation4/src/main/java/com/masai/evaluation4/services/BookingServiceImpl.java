package com.masai.evaluation4.services;


import com.masai.evaluation4.entities.*;
import com.masai.evaluation4.exception.AirnbException;
import com.masai.evaluation4.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.Repositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepositories bookingRepositories;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private HostRepository hostRepositories;

    @Autowired
    private PropertyRepositories propertyRepositories;

    @Autowired
    private RoomRepositories roomRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {

        if(user == null) throw new AirnbException("Airnb is null");
       Optional<User> user1 = userRepositories.findById(user.getUserId());
        if(user1.isPresent()) throw new AirnbException("Already present");
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepositories.save(user);
        log.info("user added ");
    }

    @Override
    public void doBooking(Integer userId, Booking booking) {

        Optional<User> user1 = userRepositories.findById(userId);
        if(user1.isPresent()){
            List<Booking> bookings = user1.get().getBooking();
            bookings.add(booking);
        }


        bookingRepositories.save(booking);
        log.info("booking completed ");

    }

    @Override
    public void addRoomToBooking(Integer userId, Integer bookingId, Room room) {

        Optional<User> user1 = userRepositories.findById(userId);
        if(user1.isPresent()){
            List<Booking> bookings = user1.get().getBooking();
            int temp = 0;
           for (int i=0;i<bookings.size();i++){
               if(bookings.get(i).getBookingId()==bookingId){
                   bookings.get(i).getRooms().add(room.getRoomId());
                   bookings.get(i).getRoom().add(room);
                   temp =1;
                   break;
               }
           }
           if(temp==0){
               throw new AirnbException("booking id is not available");
           }
           roomRepositories.save(room);
        }



        log.info("room added ");

    }

    @Override
    public void updateBookingDetails(Integer userId, Integer bookingId, Date date, Integer duration, Integer num_of_guest) {

        Optional<User> user1 = userRepositories.findById(userId);
        Booking booking = null;
        if(user1.isPresent()){
            List<Booking> bookings = user1.get().getBooking();
            int temp = 0;
            for (int i=0;i<bookings.size();i++){
                if(bookings.get(i).getBookingId()==bookingId){
                    booking = bookings.get(i);
                    bookings.get(i).setDate(date);
                    bookings.get(i).setDuration(duration);
                    bookings.get(i).setNum_of_guest(num_of_guest);

                    temp =1;
                    break;
                }
            }
            if(temp==0){
                throw new AirnbException("booking id is not available");
            }
            if(booking != null){
                bookingRepositories.save(booking);
            }

        }



        log.info("booking updated ");


    }

    @Override
    public List<Booking> userBookingHistory(Integer userId) {
        Optional<User> user1 = userRepositories.findById(userId);

        if(user1.isPresent()){
            List<Booking> bookings = user1.get().getBooking();
            return bookings;
        }else{
            throw new AirnbException("user id does not exist");
        }

    }

    @Override
    public List<Property> recommendProperty(Integer userId) {

        Optional<User> user1 = userRepositories.findById(userId);

        if(user1.isPresent()){
            List<Booking> bookings = user1.get().getBooking();

            for (int i=0;i<bookings.size();i++){


            }



        }


        return null;
    }

    @Override
    public void addHost(Host host) {

        if(host == null) throw new AirnbException("Airnb is null");
        Optional<Host> host1 = hostRepositories.findById(host.getHostId());
        if(host1.isPresent()) throw new AirnbException("Already present");

        hostRepositories.save(host);
        log.info("host added ");
    }

    @Override
    public void addPropertyToHost(Property property) {

        Optional<Property> optionalProperty = propertyRepositories.findById(property.getPropertyId());
        if(optionalProperty.isPresent()){
           Integer hoid = optionalProperty.get().getHostId();
           Optional<Host> host = hostRepositories.findById(hoid);
           if(host.isPresent()){
               host.get().getProperty().add(optionalProperty.get());
           }else{
               throw new AirnbException("host not availbale ");
           }


        }else {
            throw new AirnbException("not availbale ");
        }
        propertyRepositories.save(optionalProperty.get());
    }

    @Override
    public void addRooms(Room room, Integer propertyId) {

        Optional<Property> property = propertyRepositories.findById(propertyId);
        if(property.isPresent()){
            List<Room> roomList = property.get().getRoom();
            roomList.add(room);

        }else {
            throw new AirnbException("not availbale ");
        }
        propertyRepositories.save(property.get());

    }

    @Override
    public void addNewUsers(User user) {

        if(user == null) throw new AirnbException("Airnb is null");
        Optional<User> user1 = userRepositories.findById(user.getUserId());
        if(user1.isPresent()) throw new AirnbException("Already present");
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepositories.save(user);
        log.info("user added ");
    }

    @Override
    public String deleteBooking(Integer bookingId) {

        Optional<Booking> booking = bookingRepositories.findById(bookingId);
        String name = "";
        if(booking.isPresent()){

            bookingRepositories.deleteById(bookingId);
        }else{
            throw new AirnbException("not availbale ");
        }

       return "deleted";
    }

    @Override
    public List<User> getUsers() {
        Pageable pageable = PageRequest.of(0,5,Sort.by("name").ascending());
        List<User> userList = userRepositories.findAll(pageable).getContent();
        if(userList.isEmpty()){
            return null;
        }
        return userList;
    }

    @Override
    public List<Property> getProperty() {
        Pageable pageable = PageRequest.of(0,5, Sort.by("name").ascending());
        List<Property> propertyListList = propertyRepositories.findAll(pageable).getContent();
        if(propertyListList.isEmpty()){
            return null;
        }
        return propertyListList;
    }

    @Override
    public List<Room> getRooms() {
        Pageable pageable = PageRequest.of(0,5, Sort.by("name").ascending());
        List<Room> roomList = roomRepositories.findAll(pageable).getContent();
        if(roomList.isEmpty()){
            return null;
        }
        return roomList;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepositories.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new AirnbException("no user found with this email");
        }

    }
}
