package com.supermarket.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.supermarket.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}