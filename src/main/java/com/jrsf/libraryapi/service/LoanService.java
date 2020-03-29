package com.jrsf.libraryapi.service;

import com.jrsf.libraryapi.api.dto.LoanFilterDTO;
import com.jrsf.libraryapi.api.resource.BookController;
import com.jrsf.libraryapi.model.entity.Book;
import com.jrsf.libraryapi.model.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    Loan save(Loan loan);

    Optional<Loan> getById(Integer id);

    Loan update(Loan loan);

    Page<Loan> find(LoanFilterDTO filterDTO, Pageable pageable);

    Page<Loan> getLoanByBook(Book book, Pageable pageable);

    List<Loan> getAllLateLoans();
}
