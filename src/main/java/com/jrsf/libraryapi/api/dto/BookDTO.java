package com.jrsf.libraryapi.api.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer id;

    @NotEmpty
    private  String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String isbn;

}
