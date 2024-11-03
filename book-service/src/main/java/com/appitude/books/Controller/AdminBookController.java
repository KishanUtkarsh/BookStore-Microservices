package com.appitude.books.Controller;


import com.appitude.books.DTO.BookRequest;
import com.appitude.books.DTO.BookResponse;
import com.appitude.books.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/books")
@RequiredArgsConstructor
public class AdminBookController {

    private final BookService bookService;

    @PostMapping("/addBooks")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookResponse> addBook(@RequestBody List<BookRequest> bookRequests) {
        return bookService.addBook(bookRequests);
    }

    @PutMapping("/updateBook")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateBook(@RequestParam String bookId,@RequestBody BookRequest bookRequest) {
        return bookService.updateBook(bookId, bookRequest);
    }

}
