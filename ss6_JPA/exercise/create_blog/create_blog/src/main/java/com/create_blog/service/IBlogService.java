package com.create_blog.service;

import com.create_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
}
