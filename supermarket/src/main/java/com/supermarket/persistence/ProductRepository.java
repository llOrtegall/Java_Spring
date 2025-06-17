package com.supermarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.supermarket.persistence.crud.ProductoCrudRepository;
import com.supermarket.persistence.entity.Producto;

@Repository
public class ProductRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategory(int categoryId) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    }

    public Optional<List<Producto>> getLowStockProducts(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProduct(int productId) {
        return productoCrudRepository.findById(productId);
    }

    public Producto saveProduct(Producto product) {
        return productoCrudRepository.save(product);
    }

    public void deleteProduct(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
