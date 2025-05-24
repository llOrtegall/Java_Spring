package ortega.inyeccion.example.services;

import java.util.List;

import ortega.inyeccion.example.models.Products;
import ortega.inyeccion.example.repository.Repo_Products;

public class Products_Services {

  private Repo_Products repository = new Repo_Products();

  public List<Products> findAll() {
    return repository.findAll().stream().map(p -> {
      Double priceTotal = p.getPrice() * 1.21d;
      Products newProduct = new Products(p.getIdProduct(), p.getName(), p.getDescription(), priceTotal);
      return newProduct;
    }).toList();
  }

  public Products findById(Long id) {
    return repository.findById(id);
  }

}
