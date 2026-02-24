package com.arka.market.domain.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private int categoryId;
    private String category;
    private boolean active;
}
