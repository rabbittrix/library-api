package com.jrsf.libraryapi.model.repository;

import com.jrsf.libraryapi.model.entity.Book;
import com.jrsf.libraryapi.model.repositiry.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository repository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um livro na DB")
    public void returnTrueWhenIsbnExists(){

        String isbn = "123";
        Book book = Book.builder().title("Meu Livro").author("Jess Jane").isbn(isbn).build();
        entityManager.persist(book);
        boolean exists = repository.existsByIsbn(isbn);
        assertThat(exists).isTrue();

    }

    @Test
    @DisplayName("Deve retornar false quando não existir um livro na DB")
    public void returnFalseWhenIsbnDoesntExists(){

        String isbn = "123";
        boolean exists = repository.existsByIsbn(isbn);
        assertThat(exists).isFalse();

    }
}
