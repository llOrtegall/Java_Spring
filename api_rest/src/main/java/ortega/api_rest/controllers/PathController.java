package ortega.api_rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Employee;

@RestController
@RequestMapping("/api/variables")
public class PathController {

  @GetMapping("/pag/{mensaje}")
  public ParametrosDTO pag1(@PathVariable String mensaje){
    ParametrosDTO dto1 = new ParametrosDTO();
    dto1.setInformacion(mensaje);
    return dto1;
  }

  @PostMapping("/solicitud")
  public Employee newEmployee(@RequestBody Employee employee){
    return employee;
  }

}
