package com.blog.repository;

import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
