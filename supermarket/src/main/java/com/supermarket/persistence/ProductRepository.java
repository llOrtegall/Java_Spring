package com.supermarket.persistence;

import java.util.List;

import com.supermarket.persistence.crud.ProductoCrudRepository;
import com.supermarket.persistence.entity.Producto;

public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
