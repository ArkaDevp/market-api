package com.arka.market.persistence.mapper;

import com.arka.market.domain.dto.ShoppingProductDTO;
import com.arka.market.persistence.entity.ShoppingProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ShoppingProductMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId")
    })
    ShoppingProductDTO toShoppingProductDTO(ShoppingProduct shoppingProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "shopping", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idShopping", ignore = true),
    })
    ShoppingProduct toShoppingProduct(ShoppingProductDTO shoppingProductDTO);
}
