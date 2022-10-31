package com.blogservice.repository;

import com.blogservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where id= :id",nativeQuery = true)

    List<Blog> showListByCategory(@Param("id")int id);
    List<Blog> findByTitleContaining(String title);
}
