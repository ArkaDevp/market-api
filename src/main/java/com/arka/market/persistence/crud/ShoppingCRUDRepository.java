package com.arka.market.persistence.crud;

import com.arka.market.persistence.entity.Shopping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCRUDRepository extends CrudRepository<Shopping, Integer> {
    Optional<List<Shopping>> findByClientId(String clientId);
}
