package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Produce;
import spring.repository.IproduceRepository;

import java.util.List;

@Service
public class ProduceService implements IProduceService{
    @Autowired
    private IproduceRepository repository;
    @Override
    public List<Produce> findAll() {
        return repository.findAll();
    }
}
