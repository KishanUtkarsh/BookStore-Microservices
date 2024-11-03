package com.appitude.books.Service;

import com.appitude.books.DTO.BookRequest;
import com.appitude.books.DTO.BookResponse;
import com.appitude.books.Entity.Book;
import com.appitude.books.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Override
    public List<BookResponse> addBook(List<BookRequest> bookRequests) {

        List<Book> savedBooks = bookRepository.saveAll(bookRequests.stream().map(bookRequest -> {
            Book book = new Book();
            book.setTitle(bookRequest.title());
            book.setAuthor(bookRequest.author());
            book.setPrice(bookRequest.price());
            book.setStock(bookRequest.stock());
            book.setIsbn(bookRequest.isbn());
            book.setPublisher(bookRequest.publisher());
            book.setPublicationDate(bookRequest.publicationDate());
            return book;
        }).toList());

        return savedBooks.stream().map(book -> {

            return BookResponse.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .isbn(book.getIsbn())
                    .publisher(book.getPublisher())
                    .publicationDate(book.getPublicationDate())  // Include publicationDate
                    .build();
        }).toList();
    }

    @Override
    public BookResponse getBookById(String bookId) {

        Book book = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        if(book == null) {
            return null;
        }else{
            return BookResponse.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .isbn(book.getIsbn())
                    .publisher(book.getPublisher())
                    .publicationDate(book.getPublicationDate())
                    .build();
        }
    }

    @Override
    public BookResponse getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title).orElse(null);
        if(book != null) {
            return BookResponse.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .isbn(book.getIsbn())
                    .publisher(book.getPublisher())
                    .publicationDate(book.getPublicationDate())
                    .build();
        }
        return null;
    }

    @Override
    public List<BookResponse> getBooks() {

        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            return BookResponse.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .isbn(book.getIsbn())
                    .publisher(book.getPublisher())
                    .publicationDate(book.getPublicationDate())
                    .build();
        }).toList();


    }

    @Override
    public BookResponse updateBook(String bookId, BookRequest bookRequest) {

        Book book = bookRepository.findById(UUID.fromString(bookId)).orElse(null);
        if(book != null) {
            book.setTitle(bookRequest.title());
            book.setAuthor(bookRequest.author());
            book.setPrice(bookRequest.price());
            book.setStock(bookRequest.stock());
            book.setIsbn(bookRequest.isbn());
            book.setPublisher(bookRequest.publisher());
            book.setPublicationDate(bookRequest.publicationDate());
            bookRepository.save(book);
            return BookResponse.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                    .isbn(book.getIsbn())
                    .publisher(book.getPublisher())
                    .publicationDate(book.getPublicationDate())
                    .build();
        }
        return null;
    }
}
