package com.masaischool.round6.security;

import com.masaischool.round6.repository.UserRepos;
import com.masaischool.round6.service.UserService;
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
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepos userRepos;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.masaischool.round6.entity.User> opt= userRepos.findByEmail(username);

        if(opt.isPresent()) {

            com.masaischool.round6.entity.User user = opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();

            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(user.getRole());
            authorities.add(sga);

            return new User(user.getEmail(), user.getPassword(), authorities);

        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);
    }
}
