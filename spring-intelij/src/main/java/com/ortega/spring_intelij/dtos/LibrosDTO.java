package com.ortega.spring_intelij.dtos;

import com.ortega.spring_intelij.model.Libro;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class LibrosDTO {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer paginas;
    private AutoresDTO autorDTO;

    public LibrosDTO(Libro p_libro) {
        this.id = p_libro.getId();
        this.titulo = p_libro.getTitulo();
        this.genero = p_libro.getGenero();
        this.paginas = p_libro.getPaginas();
        autorDTO = new AutoresDTO(p_libro.getAutor());
    }
}
