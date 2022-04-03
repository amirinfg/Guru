package com.fg.guru.bootstarp;

import com.fg.guru.domain.Author;
import com.fg.guru.domain.Book;
import com.fg.guru.repositories.AuthorRepository;
import com.fg.guru.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner
{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Eric" , "Evans");
        Book book = new Book("Domain Driven Design" , "123123");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author author1 = new Author("Rod" , "Johnson");
        Book book1 = new Book("J2EE Development without EJB" , "456456");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number Of Books: " + bookRepository.count());
        List<Author> authors = (List<Author>) authorRepository.findAll();


    }
}
