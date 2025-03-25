package com.anuworks.spring6webapp.services;

import com.anuworks.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
