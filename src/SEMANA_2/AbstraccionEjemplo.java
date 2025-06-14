/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_2;

/**
 *
 * @author User
 */

// Declaro una clase abstracta porque quiero que todas las clases hijas implementen el método moverse.
abstract class Vehiculo {  
    // Método abstracto que obliga a las clases hijas a definir cómo se moverán.
    abstract void moverse();  
}

// Extiendo Vehiculo para definir cómo se mueve un coche.
class Coche extends Vehiculo {  
    // Sobrescribo moverse para implementar el comportamiento específico de un coche.
    @Override  
    void moverse() {  
        System.out.println("El coche se mueve sobre ruedas.");  
    }
}
public class AbstraccionEjemplo {
    public static void main(String[] args) {  
        // Creo un objeto de tipo Vehiculo instanciado como Coche.
        Vehiculo miCoche = new Coche();  
        // Llamo al método moverse que ejecutará la lógica definida en Coche.
        miCoche.moverse();  
    }
}
