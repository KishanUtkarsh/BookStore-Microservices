package com.appitude.books.Controller;


import com.appitude.books.DTO.BookResponse;
import com.appitude.books.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/books")
@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/bookById")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBookById(@RequestParam UUID bookId) {
        return bookService.getBookById(String.valueOf(bookId));
    }

    @GetMapping("/bookByTitle")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }

}
