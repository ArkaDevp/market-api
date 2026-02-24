package com.arka.market.domain.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer productId;
    private String name;
    private int categoryId;
    private String barCode;
    private double price;
    private int stock;
    private boolean active;
}
