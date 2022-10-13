package vn.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.dictionary.Repository.IDictionnaryRepository;
import vn.dictionary.model.Dictionary;

import java.util.List;
@Service
public class DictionnaryService implements IDictionnaryService{
    @Autowired
    private IDictionnaryRepository repository;

    @Override
    public List<Dictionary> findAll() {
        return repository.findAll();
    }
}
