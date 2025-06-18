package com.supermarket.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.supermarket.domain.Product;
import com.supermarket.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "productId", source = "idProducto"),
            @Mapping(target = "name", source = "nombre"),
            @Mapping(target = "categoryId", source = "idCategoria"),
            @Mapping(target = "price", source = "precioVenta"),
            @Mapping(target = "stock", source = "cantidadStock"),
            @Mapping(target = "active", source = "estado"),
            @Mapping(target = "category", source = "categoria")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idProducto", ignore = true), // Para INSERT, el ID se genera automáticamente
            @Mapping(target = "codigoBarras", ignore = true)
    })
    Producto toProducto(Product product);

}
