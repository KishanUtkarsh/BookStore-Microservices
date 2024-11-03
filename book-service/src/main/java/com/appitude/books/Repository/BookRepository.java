package com.appitude.books.Repository;

import com.appitude.books.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("SELECT b FROM books b WHERE b.title = ?1")
    public Optional<Book> findByTitle(String title);
    public Book findByBookId(UUID bookId);

}
