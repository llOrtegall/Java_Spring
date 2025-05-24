package ortega.inyeccion.example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ortega.inyeccion.example.models.Products;
import ortega.inyeccion.example.services.Products_Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Products_Controller {

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        Products_Services service = new Products_Services();
        return service.findAll();
    }

    @GetMapping("/product/{id}")
    public Products getProductById(@PathVariable Long id){
        Products_Services service = new Products_Services();
        return service.findById(id);
    }
}
