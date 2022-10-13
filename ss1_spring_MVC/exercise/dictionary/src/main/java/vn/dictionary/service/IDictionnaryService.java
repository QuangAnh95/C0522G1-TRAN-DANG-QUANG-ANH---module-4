package vn.dictionary.service;

import vn.dictionary.model.Dictionary;

import java.util.List;

public interface IDictionnaryService {
    List<Dictionary> findAll();
}
