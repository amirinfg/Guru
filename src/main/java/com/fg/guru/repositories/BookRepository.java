package com.fg.guru.repositories;

import com.fg.guru.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book , Long>{
}
