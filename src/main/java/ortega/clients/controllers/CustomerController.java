package ortega.clients.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ortega.clients.entities.Customer;

@RestController // esto es una anotación
public class CustomerController {

  @GetMapping("/test")
  public String test(){
    return "Hello World";
  }

  @GetMapping("/test2")
  public List<String> test2(){
    List<String> list = new ArrayList<>();
    list.add("Ivan");
    list.add("Ortega");
    list.add("Gonzalez");
    list.add("Developer");

    return list;
  }

  @GetMapping("/test3")
  public Map<String, String> test3(){
    Map<String, String> map = new HashMap<>();
    map.put("name", "Ivan");
    map.put("lastname", "Ortega");
    map.put("nickname", "IvanOrtega");
    map.put("email", "Ivan_97@hotmail.com");

    return map;
  }

  @GetMapping("/test4")  
  public Customer test4(){
    Customer c = new Customer();
    c.setFirstName("Ivan");
    c.setLastName("Ortega");
    c.setEmail("test@gmail.com");
    c.setAddress("Calle falsa 123");

    return c;
  }

  @GetMapping("/test5")
  public List<Customer> test5(){
    List<Customer> list = new ArrayList<>();
    list.add(new Customer("Ivan", "Ortega", "test1@gmail.com", "Calle falsa 123"));
    list.add(new Customer("Juan", "Perez", "test2@gmail.com", "Calle falsa 456"));
    list.add(new Customer("Pedro", "Lopez", "test4@gmail.com", "Calle falsa 789"));
    list.add(new Customer("Maria", "Gonzalez", "test5@gmail.com", "Calle falsa 101112"));

    return list;
  }
}
