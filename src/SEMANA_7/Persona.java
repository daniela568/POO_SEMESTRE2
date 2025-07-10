/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_7;

/**
 *
 * @author User
 */
public class Persona {
    private String nombre;
    private int edad;

    // Constructor por defecto: inicializa atributos con valores básicos
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }

    // Constructor parametrizado: permite definir nombre y edad al crear el objeto
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de constructor: permite definir solo el nombre
    public Persona(String nombre) {
        this.nombre = nombre;
        this.edad = 18; // edad por defecto
    }

    // Métodos get para acceder a los atributos (encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método para mostrar información de la persona
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

}
