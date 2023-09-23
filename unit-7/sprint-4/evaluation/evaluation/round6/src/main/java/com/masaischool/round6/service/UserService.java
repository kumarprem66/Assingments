package com.masaischool.round6.service;

import com.masaischool.round6.entity.User;
import com.masaischool.round6.exception.BlogException;
import com.masaischool.round6.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepos userRepos;

    public User registerUser(User user){

        Optional<User> userOptional = userRepos.findById(user.getUserId());
        if(userOptional.isPresent()) throw new BlogException("user already exist");
        userRepos.save(user);
        return user;
    }

    public User getUserByEmail(String email){

        if(userRepos.findByEmail(email).isEmpty()) throw new BlogException("no user with this email");
        return userRepos.findByEmail(email).get();
    }
}
