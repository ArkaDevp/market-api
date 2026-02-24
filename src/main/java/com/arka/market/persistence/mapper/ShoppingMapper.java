package com.arka.market.persistence.mapper;

import com.arka.market.domain.dto.ShoppingDTO;
import com.arka.market.persistence.entity.Shopping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShoppingProductMapper.class})
public interface ShoppingMapper {

    @Mappings({
            @Mapping(source = "idShopping", target = "shoppingId"),
            @Mapping(source = "client.id", target = "clientId"),
            @Mapping(source = "dateTime", target = "date"),
            @Mapping(source = "shoppingProducts", target = "items")
    })
    ShoppingDTO toShoppingDTO(Shopping shopping);

    List<ShoppingDTO> toShoppingsDTO(List<Shopping> shoppings);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Shopping toShopping(ShoppingDTO shoppingDTO);
}
