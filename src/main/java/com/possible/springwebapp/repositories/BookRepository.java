package com.possible.springwebapp.repositories;

import com.possible.springwebapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
