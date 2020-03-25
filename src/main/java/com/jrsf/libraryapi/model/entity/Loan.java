package com.jrsf.libraryapi.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {
    private Integer id;
    private String customer;
    private Book book;
    private LocalDate loanDate;
    private Boolean returned;
}
