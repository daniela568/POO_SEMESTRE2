package SEMANA8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Tarea {
     // Declaro dos atributos privados que representan los datos principales de la tarea:
    // su nombre y una breve descripción.
    private String nombre;
    private String descripcion;

    public Tarea(String nombre, String descripcion) {
        // Creo un constructor para inicializar la tarea con su nombre y descripción.
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
         // Este método me permite obtener el nombre de la tarea cuando se necesite.
        return nombre;
    }
  // este método devuelve la descripción de la tarea
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + " - " + descripcion;
    }
}