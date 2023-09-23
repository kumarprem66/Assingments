package com.masairevision.revision1.security;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.repository.CustomerRepo;
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
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<Customer> opt= customerRepository.findByEmail(username);

        if(opt.isPresent()) {

            Customer customer= opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();

            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(customer.getRole().toString());
            authorities.add(sga);

            return new User(customer.getEmail(), customer.getPassword(), authorities);

        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);
    }


}
