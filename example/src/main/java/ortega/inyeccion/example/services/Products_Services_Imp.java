package ortega.inyeccion.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ortega.inyeccion.example.models.Products;
import ortega.inyeccion.example.repository.Repo_Products_Imp;

@Component
public class Products_Services_Imp implements ProductServices {
  //TODO: implementación anterior => private Repo_Products_Imp repository = new Repo_Products_Imp();

  @Autowired // esto se utiliza para inyectar la dependencia
  private Repo_Products_Imp repository;

  @Override
  public List<Products> findAll() {
    return repository.findAll().stream().map(p -> {
      Double priceTotal = p.getPrice() * 1.21d;

      // Products newProduct = new Products(p.getIdProduct(), p.getName(),
      // p.getDescription(), priceTotal);

      Products newProducts = (Products) p.clone();

      newProducts.setPrice(priceTotal);

      return newProducts;
    }).toList();
  }

  @Override
  public Products findById(Long id) {
    return repository.findById(id);
  }

}
