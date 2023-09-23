package com.masaischool.round6.controller;

import com.masaischool.round6.entity.Blog;
import com.masaischool.round6.entity.User;
import com.masaischool.round6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInUserDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details

       User user =  userService.getUserByEmail(auth.getName());

        return new ResponseEntity<>(user.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUserController(@RequestBody User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_"+user.getRole());
        userService.registerUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }


}
