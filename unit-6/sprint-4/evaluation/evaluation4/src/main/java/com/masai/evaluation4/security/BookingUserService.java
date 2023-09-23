package com.masai.evaluation4.security;

import com.masai.evaluation4.repositories.UserRepositories;

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
public class BookingUserService implements UserDetailsService {


    @Autowired UserRepositories rRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<com.masai.evaluation4.entities.User> resOptional = rRepo.findByEmail(username);
        if(resOptional.isPresent()){

            com.masai.evaluation4.entities.User user = resOptional.get();



            List<GrantedAuthority> authorities= new ArrayList<>();

            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(user.getRole());
            authorities.add(sga);

            return new User(user.getName(), user.getPassword(), authorities);
        }else{
            throw new BadCredentialsException("User Details not found with this username: "+username);
        }


    }
}
