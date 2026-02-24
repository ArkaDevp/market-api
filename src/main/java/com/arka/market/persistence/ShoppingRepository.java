package com.arka.market.persistence;

import com.arka.market.domain.dto.ShoppingDTO;
import com.arka.market.domain.repository.IShoppingDTORepository;
import com.arka.market.persistence.crud.ShoppingCRUDRepository;
import com.arka.market.persistence.entity.Shopping;
import com.arka.market.persistence.mapper.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingRepository implements IShoppingDTORepository {
    private ShoppingCRUDRepository shoppingCRUDRepository;
    private ShoppingMapper shoppingMapper;

    @Autowired
    public ShoppingRepository(ShoppingCRUDRepository shoppingCRUDRepository, ShoppingMapper shoppingMapper) {
        this.shoppingCRUDRepository = shoppingCRUDRepository;
        this.shoppingMapper = shoppingMapper;
    }

    @Override
    public List<ShoppingDTO> getAll() {
        return shoppingMapper.toShoppingsDTO((List<Shopping>) shoppingCRUDRepository.findAll());
    }

    @Override
    public Optional<List<ShoppingDTO>> getByClient(String clientId) {
        return shoppingCRUDRepository.findByClientId(clientId).map(shoppings -> shoppingMapper.toShoppingsDTO(shoppings));
    }

    @Override
    public ShoppingDTO save(ShoppingDTO shoppingDTO) {
        Shopping shopping = shoppingMapper.toShopping(shoppingDTO);
        shopping.getShoppingProducts().forEach(product -> product.setShopping(shopping));

        return shoppingMapper.toShoppingDTO(shoppingCRUDRepository.save(shopping));
    }
}
