package vn.product.service;

import vn.product.model.Produce;

import java.util.List;

public interface IProductService {
    List<Produce> findAll();
    void save (Produce produce);
    void update(Produce produce);
    void delete (int id);
    Produce findById(int id);
    List<Produce> findByName(String name);
}
