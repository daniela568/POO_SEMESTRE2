/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
public class Main {   // Clase principal que contiene el método main para ejecutar el programa
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(); // Creo una nueva biblioteca

        // Registro dos usuarios
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // Agrego dos libros al catálogo
        biblioteca.añadirLibro(new Libro("ISBN-001", "Codigo Limpio", "Robert C. Martin", "Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002", "Java Efectivo", "Joshua Bloch", "Java"));

        // Presto un libro a cada usuario
        biblioteca.prestarLibro("U1", "ISBN-001");
        biblioteca.prestarLibro("U2", "ISBN-002");

        // Muestro los libros prestados por Ana
        System.out.println("Libros prestados por Ana:");
        for (Libro libro : biblioteca.listarPrestados("U1")) {
            System.out.println("- " + libro.getTitulo());
        }

        // Ana devuelve su libro
        biblioteca.devolverLibro("U1", "ISBN-001");

        // Busco libros por autor
        System.out.println("\nLibros del autor 'Bloch':");
        for (Libro libro : biblioteca.buscarPorAutor("Bloch")) {
            System.out.println("- " + libro.getTitulo());
        }

        // Busco libros por categoría
        System.out.println("\nLibros en la categoría 'Software':");
        for (Libro libro : biblioteca.buscarPorCategoria("Software")) {
            System.out.println("- " + libro.getTitulo());
        }
    }
}