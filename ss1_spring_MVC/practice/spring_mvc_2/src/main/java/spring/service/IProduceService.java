package spring.service;

import spring.model.Produce;

import java.util.List;

public interface IProduceService {
    List<Produce> findAll();
}
