package com.appitude.books.Service;

import com.appitude.books.DTO.BookInventoryResponse;

public interface BookInventoryService {

    public BookInventoryResponse getBookByBookId(String bookId);
    public String updateStockCount(String bookId, Integer soldQuantity);
}
