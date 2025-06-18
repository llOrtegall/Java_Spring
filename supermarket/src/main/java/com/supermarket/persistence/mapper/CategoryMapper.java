package com.supermarket.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.supermarket.domain.Category;
import com.supermarket.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "categoryId", source = "idCategoria"),
            @Mapping(target = "category", source = "descripcion"),
            @Mapping(target = "active", source = "estado"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
