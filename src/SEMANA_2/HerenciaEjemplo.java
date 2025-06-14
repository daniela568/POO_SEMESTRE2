/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_2;

/**
 *
 * @author User
 */

class Animal {
    void hacerSonido() {
        System.out.println("Este animal hace un sonido.");
    }
}

class Perro extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("El perro ladra: ¡Guau guau!");
    }
}
public class HerenciaEjemplo {
    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.hacerSonido();
    }
}
