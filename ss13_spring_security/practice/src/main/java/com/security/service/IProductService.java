package com.security.service;

import com.security.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAllByNameContaining(Pageable pageable, String nameSearch);

    Product findById(long id);

    void    remove(long id);
}
