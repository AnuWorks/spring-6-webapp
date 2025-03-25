package com.anuworks.spring6webapp.bootstrap;

import com.anuworks.spring6webapp.domain.Author;
import com.anuworks.spring6webapp.domain.Book;
import com.anuworks.spring6webapp.domain.Publisher;
import com.anuworks.spring6webapp.repo.AuthorRepo;
import com.anuworks.spring6webapp.repo.BookRepo;
import com.anuworks.spring6webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
This class is to load data on-load
we extend CommandLineRunner, everytime spring boot start up, run this class
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author anudeep = new Author();
        anudeep.setFirstName("Anudeep");
        anudeep.setLastName("Madrampalli");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456789");

        Author anudeepSaved = authorRepo.save(anudeep);
        Book dddSaved = bookRepo.save(ddd);

        Author priyanka = new Author();
        priyanka.setFirstName("Priyanka");
        priyanka.setLastName("Karnool");

        Book noEJB = new Book();
        noEJB.setTitle("No-EJB");
        noEJB.setIsbn("987654321");

        Author priyankaSaved = authorRepo.save(priyanka);
        Book noEJBSaved = bookRepo.save(noEJB);

        anudeepSaved.getBooks().add(dddSaved);
        priyankaSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(anudeepSaved);
        noEJBSaved.getAuthors().add(priyankaSaved);

        Publisher jagathi = new Publisher();
        jagathi.setPublisherName("Jagathi publications");
        jagathi.setAddress("No 21");
        jagathi.setStreet("CAR street");
        jagathi.setCity("Punganur");
        jagathi.setState("Andhra Pradesh");
        jagathi.setZip(517247);
        Publisher jagathiSaved = publisherRepo.save(jagathi);

        dddSaved.setPublisher(jagathiSaved);
        noEJBSaved.setPublisher(jagathiSaved);

        authorRepo.save(anudeepSaved);
        authorRepo.save(priyankaSaved);
        bookRepo.save(ddd);
        bookRepo.save(noEJBSaved);

        System.out.println("In Bootstrap Data");
        System.out.printf("Author count: %d\n", authorRepo.count());
        System.out.printf("Book count: %d\n", bookRepo.count());
        System.out.println("No of publications: " + publisherRepo.count());


    }
}
