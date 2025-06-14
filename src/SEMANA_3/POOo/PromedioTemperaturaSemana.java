/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_3.POOo;

/**
 *
 * @author User
 */

    public class PromedioTemperaturaSemana {
         public static void main(String[] args) {
             // Creo un objeto Semana para gestionar las temperaturas
            Semana semana = new Semana();
             // Solicito las temperaturas al usuario
            semana.ingresarTemperaturas();
             // Muestro el promedio de las temperaturas ingresadas
            semana.mostrarPromedio();
    }
}

//fin
