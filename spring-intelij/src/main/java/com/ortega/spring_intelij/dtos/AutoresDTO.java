package com.ortega.spring_intelij.dtos;

import com.ortega.spring_intelij.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutoresDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String nacionalidad;

    public AutoresDTO(Autor p_autor) {
        this.id = p_autor.getId();
        this.nombre = p_autor.getNombre();
        this.apellido = p_autor.getApellido();
        this.nacionalidad = p_autor.getNacionalidad();
    }
}

