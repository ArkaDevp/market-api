package com.arka.market.persistence.crud;

import com.arka.market.persistence.entity.Category;
import com.arka.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCRUDRepository extends CrudRepository<Product, Integer> {

    List<Product> findByCategory_IdCategoryOrderByNameAsc(Integer idCategory);

    Optional<List<Product>> findBystockLessThanAndStatus(Integer stock, boolean status);
}
