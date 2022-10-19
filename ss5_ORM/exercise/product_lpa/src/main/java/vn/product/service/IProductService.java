package vn.product.service;

import vn.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();


    void save(Product product);
}
