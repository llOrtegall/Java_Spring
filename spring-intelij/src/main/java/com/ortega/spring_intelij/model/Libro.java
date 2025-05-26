package com.ortega.spring_intelij.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 2, max = 200, message = "El título debe tener entre 2 y 200 caracteres")
    private String titulo;

    @NotBlank(message = "El género no puede estar vacío")
    @Size(min = 2, max = 50, message = "El género debe tener entre 2 y 50 caracteres")
    private String genero;

    @NotNull(message = "El número de páginas no puede ser nulo")
    private Integer paginas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    @NotNull(message = "El autor no puede ser nulo")
    private Autor autor;
}
