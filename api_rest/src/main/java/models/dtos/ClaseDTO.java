package models.dtos;

public class ClaseDTO {
  private String names;
  private String lastNames;

  public ClaseDTO(String names, String lastNames) {
    this.names = names;
    this.lastNames = lastNames;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  



}
