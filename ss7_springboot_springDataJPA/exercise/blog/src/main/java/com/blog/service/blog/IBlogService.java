package com.blog.service.blog;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining (Pageable pageable, String titleSearch );

    void save(Blog blog);

    List<Blog> findAll();
}