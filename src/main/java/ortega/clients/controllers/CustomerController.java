package ortega.clients.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
