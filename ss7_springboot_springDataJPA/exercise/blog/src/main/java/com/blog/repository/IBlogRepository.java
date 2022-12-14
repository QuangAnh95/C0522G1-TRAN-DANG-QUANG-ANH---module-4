package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllByTitleContaining (Pageable pageable, String titleSearch);

    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);
}
