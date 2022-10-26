package com.blog.service.category;

import com.blog.model.Category;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ICategoryService {
    Page<Category> findByNameCategoryContaining(Pageable pageable, String name);

    void delete(int id);

    void save(Category category);


    Category findById(int id);

    List<Category> findAll();
}
