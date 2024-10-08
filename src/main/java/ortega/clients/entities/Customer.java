package ortega.clients.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer document;
}
