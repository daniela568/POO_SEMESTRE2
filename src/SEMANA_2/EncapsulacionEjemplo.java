/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_2;

/**
 *
 * @author User
 */

// Defino la clase Persona con atributos privados para proteger sus datos.
class Persona {  
    private String nombre;  // Variable privada para que no se pueda acceder directamente.

    // Creo un constructor para inicializar el objeto con un nombre.
    Persona(String nombre) {  
        this.nombre = nombre;  
    }

    // Método getter para obtener el nombre sin acceder directamente a la variable privada.
    public String getNombre() {  
        return nombre;  
    }

    // Método setter para modificar el nombre de manera segura.
    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }
}
public class EncapsulacionEjemplo {
    public static void main(String[] args) {  
        // Creo una instancia de Persona con el nombre "Jairo".
        Persona persona = new Persona("Jairo");  
        // Muestro el nombre usando el getter en lugar de acceder directamente al atributo.
        System.out.println("Nombre: " + persona.getNombre());  

        // Cambio el nombre usando el setter.
        persona.setNombre("Carlos");  
        // Muestro el nuevo nombre actualizado.
        System.out.println("Nuevo nombre: " + persona.getNombre());  
    }
}
//fin