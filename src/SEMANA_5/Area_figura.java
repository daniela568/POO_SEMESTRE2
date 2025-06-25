/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5;

/**
 * Programa para calcular el área de un rectángulo
 * Utiliza diferentes tipos de datos: int, float, String, boolean
 * Aplica la fórmula: área = base * altura
 * @author User
 */

import java.util.Scanner;

public class Area_figura {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre_usuario; // Variable String para almacenar el nombre del usuario
        boolean programa_activo = true; // Variable boolean para indicar que el programa está funcionando
        
        // Saludo inicial 
        System.out.println("=== CALCULADORA DE AREA DE RECTANGULO ===");
        System.out.print("Ingrese su nombre: ");
        nombre_usuario = scanner.nextLine();
        System.out.println("Hola " + nombre_usuario + "!\n");
        
        // Llamar a la función para calcular el área
        calcular_area_rectangulo(scanner);
        
        scanner.close();
    }
    
    /**
     * Función para calcular el área de un rectángulo
     * Utiliza la fórmula: base * altura
     * @param scanner - Scanner para entrada de datos del usuario
     */
    public static void calcular_area_rectangulo(Scanner scanner) {
        float base_rectangulo; // Variable float para almacenar la base
        float altura_rectangulo; // Variable float para almacenar la altura
        int numero_calculo = 1; // Variable int para identificar el cálculo
        
        System.out.println("--- Calculo de Area de Rectangulo ---");
        
        // Solicitar datos al usuario
        System.out.print("Ingrese la base del rectangulo: ");
        base_rectangulo = scanner.nextFloat();
        
        System.out.print("Ingrese la altura del rectangulo: ");
        altura_rectangulo = scanner.nextFloat();
        
        // Cálculo del área utilizando la fórmula base * altura
        float area_rectangulo = base_rectangulo * altura_rectangulo;
        
        // Mostrar resultados
        System.out.printf("\nResultados del calculo #%d:\n", numero_calculo);
        System.out.printf("Base: %.2f unidades\n", base_rectangulo);
        System.out.printf("Altura: %.2f unidades\n", altura_rectangulo);
        System.out.printf("Area del rectangulo: %.2f \n\n", area_rectangulo);
    }
}
