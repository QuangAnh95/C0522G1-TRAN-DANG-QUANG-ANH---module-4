package vn.dictionary.Repository;

import vn.dictionary.model.Dictionary;

import java.util.List;

public interface IDictionnaryRepository {
    List<Dictionary> findAll();
}
