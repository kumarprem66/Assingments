package com.masaischool.round6.controller;

import com.masaischool.round6.entity.Blog;
import com.masaischool.round6.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;



    @GetMapping("/Blog/{proId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer blogId){


        Blog blog = blogService.getBlog(blogId);

        return new ResponseEntity<>(blog, HttpStatus.ACCEPTED);
    }

    @GetMapping("/Blogs")
    public ResponseEntity<List<Blog>> getAllBlogsHandler(){


        List<Blog> blogList = blogService.getAllBlog();

        return new ResponseEntity<>(blogList, HttpStatus.ACCEPTED);
    }

    @PostMapping("/createBlog")
    public ResponseEntity<Blog> createBlogHandler(@RequestBody @Valid Blog blog){

        Blog blog1 = blogService.createBlog(blog);

//        LocalDate localDate = LocalDate.parse(blog.)

        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @PatchMapping("/updateBlog/{proId}")
    public ResponseEntity<Blog> updateBlogHandler(@RequestBody @Valid Blog blog,@PathVariable Integer blogId){


        Blog blog1 = blogService.updateBlog(blogId,blog);

        return new ResponseEntity<>(blog1, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteBlog")
    public ResponseEntity<String> deleteBlogHandler(@PathVariable Integer blogId){


        String s = blogService.deleteBlog(blogId);

        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }






}
