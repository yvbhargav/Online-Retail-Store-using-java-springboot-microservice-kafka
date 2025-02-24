package com.example.M2_CART_SERVICE.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineitemDTO {
    private Long productId;
    private String productName;
    private Long price;
    private Long quantity;

    // Getters and Setters
}