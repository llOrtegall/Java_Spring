package ortega.inyeccion.example.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import ortega.inyeccion.example.models.Products;

@Component
public class Repo_Products_Imp implements ProductRepository{
  List<Products> data;

  public Repo_Products_Imp() {
    this.data = Arrays.asList(new Products(001L, "Monitor", "Description 1", 10.00),
        new Products(002L, "Keyboard", "Description 2", 20.00),
        new Products(003L, "Mouse", "Description 3", 30.00),
        new Products(004L, "CPU", "Description 4", 40.00),
        new Products(005L, "Laptop", "Description 5", 50.00),
        new Products(006L, "Tablet", "Description 6", 60.00),
        new Products(007L, "Smartphone", "Description 7", 70.00));
  }

  public List<Products> findAll() {
    return data;
  }

  public Products findById(Long id) {
    return data.stream()
        .filter(p -> p.getIdProduct()
        .equals(id))
        .findFirst()
        .orElse(null);
  }
}
