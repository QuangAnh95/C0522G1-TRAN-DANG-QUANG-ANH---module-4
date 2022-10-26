package com.library.service.impl;

import com.library.repository.IBackBookRepository;
import com.library.service.IBackBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackBookService implements IBackBookService {
    @Autowired
    private IBackBookRepository backBookRepository;
}
