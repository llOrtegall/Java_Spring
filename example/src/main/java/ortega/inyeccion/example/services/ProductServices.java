package ortega.inyeccion.example.services;

import java.util.List;

import ortega.inyeccion.example.models.Products;

public interface ProductServices {
    List<Products> findAll();
    Products findById(Long id);
}
