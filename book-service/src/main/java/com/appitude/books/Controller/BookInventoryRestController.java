package com.appitude.books.Controller;

import com.appitude.books.DTO.BookInventoryResponse;
import com.appitude.books.Service.BookInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookInventory")
@RequiredArgsConstructor
public class BookInventoryRestController {

    private final BookInventoryService bookInventoryService;

    @GetMapping("/bookByBookId")
    @ResponseStatus(HttpStatus.OK)
    public BookInventoryResponse getBookByBookId(@RequestParam  String bookId) {
        return bookInventoryService.getBookByBookId(bookId);
    }


    @PutMapping("/updateStockCount")
    @ResponseStatus(HttpStatus.OK)
    public String updateStockCount(@RequestParam String bookId,@RequestParam Integer soldQuantity) {
        return bookInventoryService.updateStockCount(bookId, soldQuantity);
    }

}
