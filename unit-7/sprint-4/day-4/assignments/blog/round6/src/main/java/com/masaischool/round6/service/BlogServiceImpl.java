package com.masaischool.round6.service;

import com.masaischool.round6.entity.Blog;
import com.masaischool.round6.exception.BlogException;
import com.masaischool.round6.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{


    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Integer id) {

        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isEmpty()) throw new BlogException("blog with this id is not available");
        return blog.get();
    }

    @Override
    public Blog createBlog(Blog blog) {


        Optional<Blog> blog1 = blogRepository.findById(blog.getBlogId());

        if(blog1.isPresent()) throw new BlogException("blog already exist");

        blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog updateBlog(Integer id,Blog blog) {
        Optional<Blog> blog1 = blogRepository.findById(id);
        if(blog1.isEmpty()) throw new BlogException("blog not exist");
        Blog blogu = blog1.get();
        blogu.setTitle(blog.getTitle());
        blogu.setContent(blog.getContent());
        blogu.setPublicationDate(blog.getPublicationDate());
        blogRepository.save(blogu);
        return blogu;

    }

    @Override
    public String deleteBlog(Integer id) {
        Optional<Blog> blog1 = blogRepository.findById(id);
        if(blog1.isEmpty()) throw new BlogException("blog not exist");
        blogRepository.delete(blog1.get());
        return "blog with this "+id +" deleted";
    }

    @Override
    public List<Blog> getAllBlog() {
       List<Blog> list = blogRepository.findAll();
        if(list.isEmpty()) throw new BlogException("blog not exist");
        return list;
    }
}
