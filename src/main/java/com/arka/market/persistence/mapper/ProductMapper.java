package com.arka.market.persistence.mapper;

import com.arka.market.domain.dto.ProductDTO;
import com.arka.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "category.idCategory", target = "categoryId"),
            @Mapping(source = "status", target = "active")
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductsDTO(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductDTO productDTO);
}
