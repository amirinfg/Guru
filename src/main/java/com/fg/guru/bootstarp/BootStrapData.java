package com.fg.guru.bootstarp;

import com.fg.guru.domain.Author;
import com.fg.guru.domain.Book;
import com.fg.guru.domain.Publisher;
import com.fg.guru.repositories.AuthorRepository;
import com.fg.guru.repositories.BookRepository;
import com.fg.guru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner
{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);



        Author author = new Author("Eric" , "Evans");
        Book book = new Book("Domain Driven Design" , "123123");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);



        Author author1 = new Author("Rod" , "Johnson");
        Book book1 = new Book("J2EE Development without EJB" , "456456");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);



        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books: " + bookRepository.count());
        List<Author> authors = (List<Author>) authorRepository.findAll();


    }
}
