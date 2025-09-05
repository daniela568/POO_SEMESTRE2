/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana12;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {   // Creo una clase llamada Usuario. 
    private String id;
    private String nombre;
    private List<String> isbnsPrestados;

    // Aquí inicializo la lista de libros prestados como vacía
    public Usuario(String id, String nombre) {
        if (id == null || nombre == null || id.isEmpty() || nombre.isEmpty()) {
            throw new IllegalArgumentException("Datos inválidos");
        }
        this.id = id;// Asigno el ID
        this.nombre = nombre;   // Asigno el nombre 
        this.isbnsPrestados = new ArrayList<>(); // Inicio mi lista de libros
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { return isbnsPrestados; } // Método para obtener la lista de ISBNs de libros prestados
}
