package com.arka.market.persistence.mapper;

import com.arka.market.domain.dto.CategoryDTO;
import com.arka.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDTO categoryDTO);

    default Category fromId(int id) {
        if ( id == 0 ) {
            return null;
        }
        Category category = new Category();
        category.setIdCategory(id);
        return category;
    }
}
