package com.fg.guru.repositories;

import com.fg.guru.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author , Long> {

}
