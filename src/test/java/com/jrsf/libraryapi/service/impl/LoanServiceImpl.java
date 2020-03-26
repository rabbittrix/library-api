package com.jrsf.libraryapi.service.impl;

import com.jrsf.libraryapi.model.entity.Loan;
import com.jrsf.libraryapi.model.repository.LoanRepository;
import com.jrsf.libraryapi.service.LoanService;

public class LoanServiceImpl implements LoanService {
    private LoanRepository repository;
    public LoanServiceImpl(LoanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Loan save(Loan loan) {
        return repository.save(loan);
    }
}
