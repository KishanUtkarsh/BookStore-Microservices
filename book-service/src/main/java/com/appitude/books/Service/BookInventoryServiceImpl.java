package com.appitude.books.Service;

import com.appitude.books.DTO.BookInventoryResponse;
import com.appitude.books.Entity.Book;
import com.appitude.books.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookInventoryServiceImpl implements BookInventoryService{

    private final BookRepository bookRepository;

    @Override
    public BookInventoryResponse getBookByBookId(String bookId) {
        Book book = bookRepository.findByBookId(UUID.fromString(bookId));
        if(book != null){
            return BookInventoryResponse.builder()
                    .bookId(book.getBookId())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .build();
        }
        return null;
    }

    @Override
    public String updateStockCount(String bookId, Integer soldQuantity) {
        Book book = bookRepository.findByBookId(UUID.fromString(bookId));
        if(book != null){
            book.setStock(book.getStock() - soldQuantity);
            bookRepository.save(book);
            return "Stock updated successfully";
        }
        return "Book not found";
    }
}
