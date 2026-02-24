package com.arka.market.domain.repository;

import com.arka.market.domain.dto.ShoppingDTO;

import java.util.List;
import java.util.Optional;

public interface IShoppingDTORepository {
    List<ShoppingDTO> getAll();

    Optional<List<ShoppingDTO>> getByClient(String clientId);

    ShoppingDTO save(ShoppingDTO shoppingDTO);
}
