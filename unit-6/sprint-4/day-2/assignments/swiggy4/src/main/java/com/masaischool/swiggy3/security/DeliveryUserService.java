package com.masaischool.swiggy3.security;

import com.masaischool.swiggy3.entity.Customer;
import com.masaischool.swiggy3.entity.Restaurant;
import com.masaischool.swiggy3.repository.CustomerRepository;
import com.masaischool.swiggy3.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryUserService implements UserDetailsService {

//    @Autowired CustomerRepository cRepo;

    @Autowired
    RestaurantRepository rRepo;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<Restaurant> resOptional = rRepo.findByName(username);
        if(resOptional.isPresent()){

            Restaurant restaurant = resOptional.get();



            List<GrantedAuthority> authorities= new ArrayList<>();

            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(restaurant.getRole());
            authorities.add(sga);

            return new User(restaurant.getName(), restaurant.getPassword(), authorities);
        }else{
            throw new BadCredentialsException("User Details not found with this username: "+username);
        }


    }
}
