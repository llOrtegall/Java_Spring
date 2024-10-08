package ortega.clients.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ortega.clients.entities.Customer;

@RestController
public class CustomerController {

  @GetMapping("/customer/1") // Obtener cliente por id
  public Customer getCustomer(){

    Customer customer = new Customer();
    customer.setId(1);
    customer.setFirstName("Juan");
    customer.setLastName("Perez");
    customer.setEmail("test@gmail.com");
    customer.setDocument(1118335235);

    return customer;
  }

  /*
  @GetMapping("/customers") // Listar clientes
  public List<Customer> getAllCustomers(){
    return null;
  }

  @GetMapping("/customers") // Agregar cliente
  public void addCustomer(Customer customer){
    
  }

  @GetMapping("/customers") // Eliminar cliente
  public void removeCliente(){
    
  }

  @GetMapping("/customers") // Actualizar cliente
  public void updateCliente(){
    
  }

  @GetMapping("/test")
  public List<Customer> searchCliente(){
    List<Customer> list = new ArrayList<>();

    return list;
  }

   */

  @GetMapping("/test5")
  public List<Customer> test5(){
    List<Customer> list = new ArrayList<>();

    return list;
  }
}
