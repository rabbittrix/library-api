package com.jrsf.libraryapi.service;

import com.jrsf.libraryapi.exception.BusinessException;
import com.jrsf.libraryapi.model.entity.Book;
import com.jrsf.libraryapi.model.repositiry.BookRepository;
import com.jrsf.libraryapi.service.impl.BookServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setUp(){
        this.service = new BookServiceImpl(repository);
    }

    @Test
    @DisplayName("Deve salvar um livro")
    public void saveBookTest(){
        Book book = createValidBook();
        Mockito.when(repository.existsByIsbn(Mockito.anyString())).thenReturn(false);
        Mockito.when(repository.save(book)).thenReturn(Book.builder()
                .id(10)
                .isbn("123")
                .author("Jess Jane")
                .title("Meu Livro")
                .build());

        Book savedBook = service.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getTitle()).isEqualTo("Meu Livro");
        assertThat(savedBook.getAuthor()).isEqualTo("Jess Jane");
    }

    private Book createValidBook() {
        return Book.builder().isbn("123").author("Jess Jane").title("Meu Livro").build();
    }

    @Test
    @DisplayName("Deve lançar erro com ISBN duplicado")
    public void shouldNotSaveABookWithDuplicateISBN(){
        Book book = createValidBook();
        Mockito.when(repository.existsByIsbn(Mockito.anyString())).thenReturn(true);
        Throwable exception = Assertions.catchThrowable(() -> service.save(book));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("ISBN já cadastrado");
        Mockito.verify(repository, Mockito.never()).save(book);
    }
}
