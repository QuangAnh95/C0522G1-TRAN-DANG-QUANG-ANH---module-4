package vn.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.product.model.Produce;
import vn.product.repository.IProductRepository;
import vn.product.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Produce> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Produce produce) {
        productRepository.save(produce);
    }

    @Override
    public void update(Produce produce) {
productRepository.update(produce);
    }

    @Override
    public void delete(int id) {
productRepository.delete(id);
    }

    @Override
    public Produce findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Produce> findByName(String name) {
        return productRepository.findByName(name);
    }
}
