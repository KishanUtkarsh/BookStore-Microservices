package com.appitude.books.DTO;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record BookInventoryResponse(UUID bookId, BigDecimal price, Integer stock) {
}
