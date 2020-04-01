package com.jrsf.libraryapi.model.repository;

import com.jrsf.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsByIsbn(String isbn);

    Optional<Book> findByIsbn(String isbn);
}
