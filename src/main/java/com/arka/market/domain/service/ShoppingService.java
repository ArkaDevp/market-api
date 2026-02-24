package com.arka.market.domain.service;

import com.arka.market.domain.dto.ShoppingDTO;
import com.arka.market.persistence.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {
    private final ShoppingRepository shoppingRepository;

    @Autowired
    public ShoppingService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    public List<ShoppingDTO> getAll() {
        return shoppingRepository.getAll();
    }

    public ShoppingDTO save(ShoppingDTO shoppingDTO) {
        return shoppingRepository.save(shoppingDTO);
    }

    public Optional<List<ShoppingDTO>> getByClient(String clientId){
        return shoppingRepository.getByClient(clientId);
    }


}
