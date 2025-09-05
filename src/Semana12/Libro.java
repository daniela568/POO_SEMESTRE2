/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
public class Libro { // Se define la clase Libro, que representa un libro dentro del sistema.
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    // En el constructor valido que ningún dato esté vacío o nulo
    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || titulo == null || autor == null || categoria == null ||
            isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
            throw new IllegalArgumentException("Datos inválidos");
        }
        this.isbn = isbn;   // Se asigna el ISBN al atributo correspondiente
        this.titulo = titulo; // Se asigna el título al atributo correspondiente
        this.autor = autor; // Se asigna el autor al atributo correspondiente
        this.categoria = categoria; // Se asigna la categoría al atributo correspondiente
    }

    // Estos métodos me permiten acceder a los datos del libro
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
}