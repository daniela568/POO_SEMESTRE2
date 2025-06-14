/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_3.POOo;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Semana {
    private Temperatura[] temperaturas;
    private String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    public Semana() {
        temperaturas = new Temperatura[diasSemana.length];
    }

    public void ingresarTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < diasSemana.length; i++) {
            System.out.print("Ingrese la temperatura del " + diasSemana[i] + ": ");
            double valor = scanner.nextDouble();
            temperaturas[i] = new Temperatura(diasSemana[i], valor);
        }
        scanner.close();
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Temperatura temp : temperaturas) {
            suma += temp.getValor();
        }
        return suma / temperaturas.length;
    }

    public void mostrarPromedio() {
        System.out.println("La temperatura promedio de la semana es: " + calcularPromedio());
    }
}
