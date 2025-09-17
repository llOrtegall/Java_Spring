package com.poo;

import com.poo.contenido.Pelicula;

public class Main {
    public static void main(String[] args) {
        
        Pelicula peli = new Pelicula(); // Instanciación de la clase Pelicula
        peli.titulo = "Avatar";
        peli.descripcion = "Película de ciencia ficción";
        peli.duracion = 162;
        peli.genero = "Ciencia ficción";
        peli.anioEstreno = 2009;
        peli.calificacion = 5.0;
        peli.disponible = true;

        peli.reproducir();
        System.out.println(peli.obtenerFichaTecnica());
        peli.calificar(4.5);
        System.out.println("Popular: " + peli.esPopular()); 

    }
}