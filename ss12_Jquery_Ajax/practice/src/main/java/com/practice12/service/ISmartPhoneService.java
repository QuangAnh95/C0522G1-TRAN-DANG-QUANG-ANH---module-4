package com.practice12.service;

import com.practice12.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {

    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
