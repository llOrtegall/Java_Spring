package ortega.api_rest.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Employee;
import models.dtos.ClaseDTO;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api")
public class RestControllerExample {

  @GetMapping("/detalles_info2")
  public Map<String, Object> info() {
    Map<String, Object> info = new HashMap<>();

    info.put("Titulo", "Servidor en linea ...");
    info.put("Descripcion", "Servidor corriendo en el puerto 3000 ...");
    info.put("Version", "1.0.0");

    return info;
  }

  // Ejemplo explícito de producir JSON
  @GetMapping(value = "/detalles_info_explicit", produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, Object> infoExplicit() {
    Map<String, Object> info = new HashMap<>();
    info.put("Mensaje", "Este endpoint produce explícitamente JSON");
    info.put("ContentType", "application/json");
    return info;
  }

  @GetMapping("/empleados")
  public Map<String, Employee> empleados() {
    Employee emp1 = new Employee(1, "Juan", "Pérez", "juan.perez@example.com", "555-1234");
    Employee emp2 = new Employee(2, "Ana", "Gómez", "ana.gomez@example.com", "555-5678");
    Employee emp3 = new Employee(3, "Carlos", "López", "carlos.lopez@example.com", "555-9999");

    Map<String, Employee> info = new HashMap<>();

    info.put("Empleado 1", emp1);
    info.put("Empleado 2", emp2);
    info.put("Empleado 3", emp3);

    return info;
  }

  @GetMapping("/empleados2")
  public List<ClaseDTO > empleados2() {
    
    ClaseDTO dto1 = new ClaseDTO("Ivan", "Ortega Garzon");
    ClaseDTO dto2 = new ClaseDTO("Juan", "Pérez");
    ClaseDTO dto3 = new ClaseDTO("Ana", "Gómez");

    return Arrays.asList(dto1, dto2, dto3);
  }
}
