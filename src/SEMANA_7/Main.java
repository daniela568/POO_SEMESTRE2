/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_7;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        // Crear persona con constructor por defecto
        Persona persona1 = new Persona();

        // Crear persona con constructor parametrizado
        Persona persona2 = new Persona("Ana", 25);

        // Crear persona con constructor sobrecargado
        Persona persona3 = new Persona("Luis");

        // Mostrar la información de cada persona
        persona1.mostrarInformacion();
        System.out.println("------");
        persona2.mostrarInformacion();
        System.out.println("------");
        persona3.mostrarInformacion();
    }
}

