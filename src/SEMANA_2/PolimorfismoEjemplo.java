/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_2;

/**
 *
 * @author User
 */
// Defino la clase base Figura, quiero que todas las figuras tengan el método calcularArea.
class Figura {  
    
    double calcularArea() {  
        return 0; // Devuelvo 0 por defecto ya que no tiene una implementación específica aquí.
    }
}

// Extiendo Figura para que Circulo tenga su propio cálculo de área.
class Circulo extends Figura {  
    double radio;  // Variable para almacenar el radio.

    // Creo el constructor para recibir el radio al momento de instanciar un objeto.
    Circulo(double radio) {  
        this.radio = radio;  
    }

    // Sobrescribo calcularArea para definir la lógica específica del círculo.
    @Override  
    double calcularArea() {  
        return Math.PI * radio * radio; // Fórmula matemática del área de un círculo.
    }
}
public class PolimorfismoEjemplo {
    public static void main(String[] args) {  
        // Uso polimorfismo al crear un objeto de tipo Figura pero instanciándolo como Circulo.
        Figura miCirculo = new Circulo(5);  
        // Llamo a calcularArea, y aunque miCirculo es de tipo Figura, ejecutará la lógica de Circulo.
        System.out.println("Area del circulo: " + miCirculo.calcularArea());  
    }
}

