package com.library.repository;

import com.library.model.BackBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBackBookRepository extends JpaRepository<BackBook,Integer> {
    BackBook findByCode(String code);
}
