package com.appitude.books.DTO;

import java.util.UUID;

public record BookInventoryRequest(UUID bookId, Integer quantitySold) {
}
