package com.appitude.books.Service;

import java.util.List;
import com.appitude.books.DTO.BookRequest;
import com.appitude.books.DTO.BookResponse;

public interface BookService {

    public List<BookResponse> addBook(List<BookRequest> bookRequests);
    public BookResponse getBookById(String bookId);
    public BookResponse getBookByTitle(String title);
    public List<BookResponse> getBooks();
    public BookResponse updateBook(String bookId, BookRequest bookRequest);


}
