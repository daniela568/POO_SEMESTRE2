/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
import java.util.*;

public class Biblioteca {  // Se define la clase Biblioteca, que gestiona libros y usuarios en un sistema de préstamo.
    private Map<String, Libro> catalogoPorIsbn;
    private Map<String, Usuario> usuariosPorId;
    private Set<String> isbnsPrestados;

    // En el constructor inicializo las colecciones vacías
    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>(); // Se inicializa el catálogo de libros como un mapa vacío.
        usuariosPorId = new HashMap<>();  // Se inicializa el registro de usuarios como un mapa vacío.
        isbnsPrestados = new HashSet<>(); // Se inicializa el conjunto de libros prestados como vacío.
    }
// Método para añadir un libro al catálogo
    public void añadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro); // Agrego el libro al catálogo
    }
// Método para quitar un libro del catálogo
    public void quitarLibro(String isbn) {
        catalogoPorIsbn.remove(isbn); // Elimino el libro del catálogo
        isbnsPrestados.remove(isbn);  // También lo quito de los prestados si estaba
    }
 // Método para registrar un nuevo usuario
    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u); // Registro al usuario en el sistema
    }
// Método para dar de baja a un usuario
    public void darBajaUsuario(String id) {
        Usuario u = usuariosPorId.remove(id); // Elimino al usuario
        if (u != null) {
            isbnsPrestados.removeAll(u.getIsbnsPrestados()); // Libero sus libros prestados
        }
    }
// Método para prestar un libro a un usuario
    public boolean prestarLibro(String idUsuario, String isbn) {
        if (!catalogoPorIsbn.containsKey(isbn) || isbnsPrestados.contains(isbn)) return false;
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) return false;
        u.getIsbnsPrestados().add(isbn); // Agrego el libro a la lista del usuario
        isbnsPrestados.add(isbn);        // Marco el libro como prestado
        return true;
    }
// Método para devolver un libro
    public boolean devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null || !u.getIsbnsPrestados().contains(isbn)) return false;
        u.getIsbnsPrestados().remove(isbn); // Quito el libro de la lista del usuario
        isbnsPrestados.remove(isbn);        // Lo libero del set de prestados
        return true;
    }
// Método para buscar libros por título
    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l); // Agrego los libros que coinciden con el título
            }
        }
        return resultado;
    }
 // Método para buscar libros por autor
    public List<Libro> buscarPorAutor(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l); // Agrego los libros que coinciden con el autor
            }
        }
        return resultado;
    }
// Método para buscar libros por categoría
    public List<Libro> buscarPorCategoria(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l); // Agrego los libros que coinciden con la categoría
            }
        }
        return resultado;
    }
// Método para listar los libros prestados a un usuario específico
    public List<Libro> listarPrestados(String idUsuario) {
        Usuario u = usuariosPorId.get(idUsuario);
        List<Libro> resultado = new ArrayList<>();  // Lista para almacenar los libros prestados
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                Libro l = catalogoPorIsbn.get(isbn);
                if (l != null) resultado.add(l); // Recupero los libros prestados por el usuario
            }
        }
        return resultado; // Se devuelve la lista de libros prestados por el usuario
    }
}