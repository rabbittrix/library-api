package com.jrsf.libraryapi.api.exception;

import com.jrsf.libraryapi.exception.BusinessException;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    private List<String> errors;
    public ApiErrors(BindingResult bindResult) {
        this.errors = new ArrayList<>();
        bindResult.getAllErrors().forEach(errors -> this.errors.add(errors.getDefaultMessage()));
    }

    public ApiErrors(BusinessException ex) {
        this.errors = Arrays.asList(ex.getMessage());
    }

    public ApiErrors(ResponseStatusException ex) {
        this.errors = Arrays.asList(ex.getReason());
    }

    public List<String> getErrors() {
        return errors;
    }
}
