package com.blogservice.service.impl;
import com.blogservice.model.Blog;
import com.blogservice.repository.IBlogRepository;
import com.blogservice.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public  class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> showListByCategory(int id) {
        return blogRepository.showListByCategory(id);
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return blogRepository.findByTitleContaining(title);
    }
}
