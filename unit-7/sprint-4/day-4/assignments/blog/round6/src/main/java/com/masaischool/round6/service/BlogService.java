package com.masaischool.round6.service;

import com.masaischool.round6.entity.Blog;

import java.util.List;

public interface BlogService {

    Blog getBlog(Integer id);

    Blog createBlog(Blog blog);

    Blog updateBlog(Integer id,Blog blog);

    String deleteBlog(Integer id);

    List<Blog> getAllBlog();

}
