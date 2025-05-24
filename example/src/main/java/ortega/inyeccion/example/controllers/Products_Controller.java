package ortega.inyeccion.example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ortega.inyeccion.example.models.Products;
import ortega.inyeccion.example.services.Products_Services_Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Products_Controller {

    // private Products_Services_Imp service = new Products_Services_Imp();
    @Autowired
    private Products_Services_Imp service;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.findAll();
    }

    @GetMapping("/product/{id}")
    public Products getProductById(@PathVariable Long id){
        return service.findById(id);
    }
}
