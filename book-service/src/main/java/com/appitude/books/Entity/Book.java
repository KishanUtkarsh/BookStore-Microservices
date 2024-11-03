package com.appitude.books.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bookId;

    @NotBlank(message = "Title is mandatory")
    @Column(unique = true)
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Stock is mandatory")
    @Min(value = 0, message = "Stock must be a non-negative number")
    private Integer stock;

    @NotBlank(message = "ISBN is mandatory")
    @Column(unique = true)
    private String isbn;

    @NotBlank(message = "Publisher is mandatory")
    private String publisher;

    @NotNull(message = "Publication date is mandatory")
    private LocalDate publicationDate;


}
