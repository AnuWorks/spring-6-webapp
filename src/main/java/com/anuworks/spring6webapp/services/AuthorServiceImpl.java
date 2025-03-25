package com.anuworks.spring6webapp.services;

import com.anuworks.spring6webapp.domain.Author;
import com.anuworks.spring6webapp.repo.AuthorRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepo.findAll();
    }
}
