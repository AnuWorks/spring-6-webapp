package com.anuworks.spring6webapp.services;


import com.anuworks.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
