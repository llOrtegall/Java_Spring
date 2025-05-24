package ortega.api_rest.controllers;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import models.Employee;

@Controller
public class EjemploController {

  @GetMapping("/detalles_info")
  public String info(Model model) {
    model.addAttribute("Titulo", "Servidor en linea ...");
    model.addAttribute("Descripcion", "Servidor corriendo en el puerto 3000 ...");

    return "detalles_info";
  }

  @ModelAttribute("Employee")
  public List<Employee> info2() {
    Employee emp1 = new Employee(1, "Juan", "Pérez", "juan.perez@example.com", "555-1234");
    Employee emp2 = new Employee(2, "Ana", "Gómez", "ana.gomez@example.com", "555-5678");
    Employee emp3 = new Employee(3, "Carlos", "López", "carlos.lopez@example.com", "555-9999");

    return List.of(emp1, emp2, emp3);
  }


}
