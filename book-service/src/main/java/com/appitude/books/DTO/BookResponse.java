package com.appitude.books.DTO;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
public record BookResponse(UUID bookId, String title,
                           String author, BigDecimal price, Integer stock,
                           String isbn, String publisher,
                           LocalDate publicationDate) {

}
