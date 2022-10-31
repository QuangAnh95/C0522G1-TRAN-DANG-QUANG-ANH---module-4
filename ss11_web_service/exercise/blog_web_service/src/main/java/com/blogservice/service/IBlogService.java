package com.blogservice.service;

import com.blogservice.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(int id);

    List<Blog> showListByCategory(int id);

    List<Blog> searchByTitle(String title);
}
