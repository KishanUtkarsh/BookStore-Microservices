package com.appitude.books.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRequest(String title, String author,
                          BigDecimal price, Integer stock, String isbn,
                          String publisher, LocalDate publicationDate) {

}
