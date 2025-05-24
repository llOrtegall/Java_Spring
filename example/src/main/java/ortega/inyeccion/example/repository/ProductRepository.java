package ortega.inyeccion.example.repository;

import java.util.List;

import ortega.inyeccion.example.models.Products;

public interface ProductRepository {
    List<Products> findAll();
    Products findById(Long id);
} 