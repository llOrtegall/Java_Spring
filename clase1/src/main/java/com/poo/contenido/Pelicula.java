package com.poo.contenido;

public class Pelicula {
    public String titulo;
    public String descripcion;
    public int duracion;
    public String genero;
    public int anioEstreno;
    public double calificacion;
    public boolean disponible;

    public void reproducir() {
        System.out.println("Reproduciendo la película: " + titulo);
    }

    public String obtenerFichaTecnica(){
        return "Titulo: " + titulo + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Duración: " + duracion + " minutos\n" +
                "Género: " + genero + "\n" +
                "Año de estreno: " + anioEstreno + "\n" +
                "Calificación: " + calificacion + "\n" +
                "Disponible: " + disponible;
    }

    public void calificar(double calificacion) {
        if(calificacion >= 0 && calificacion <= 5) {
            this.calificacion = calificacion;
        }else {
            System.out.println("Calificación inválida. Debe estar entre 0 y 5.");
        }
    }

    public boolean esPopular() {
        return calificacion >= 4;
    }
}
