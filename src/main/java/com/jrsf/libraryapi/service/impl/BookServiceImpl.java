package com.jrsf.libraryapi.service.impl;

import com.jrsf.libraryapi.exception.BusinessException;
import com.jrsf.libraryapi.model.entity.Book;
import com.jrsf.libraryapi.model.repositiry.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements com.jrsf.libraryapi.service.BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByIsbn(book.getIsbn())){
            throw new BusinessException(("ISBN já cadastrado"));
        }
        return repository.save(book);
    }
}
