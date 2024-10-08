package ortega.clients.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // esto es una anotación
public class CustomerController {

  @GetMapping("/test")
  public String test(){
    return "Hello World";
  }
}
