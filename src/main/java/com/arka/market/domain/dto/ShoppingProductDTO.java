package com.arka.market.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ShoppingProductDTO {
    private int productId;
    private int quantity;
    private double total;
    private boolean status;
}
