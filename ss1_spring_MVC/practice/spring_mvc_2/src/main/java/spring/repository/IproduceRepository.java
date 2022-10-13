package spring.repository;

import spring.model.Produce;

import java.util.List;

public interface IproduceRepository {
    List<Produce> findAll();

}
