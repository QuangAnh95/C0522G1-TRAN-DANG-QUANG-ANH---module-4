package com.blog.service.blog;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService {

    void save(Blog blog);


    Page<Blog> findAllByTitleContaining (Pageable pageable, String titleSearch);

    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void remove(int id);
}