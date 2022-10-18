package vn.product.repository;

import vn.product.model.Produce;

import java.util.List;

public interface IProductRepository {
    List<Produce> findAll();
    void save (Produce produce);
    void update(Produce produce);
    void delete (int id);
    Produce findById(int id);
    List<Produce> findByName(String name);
}
