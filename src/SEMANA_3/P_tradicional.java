/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SEMANA_3;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class P_tradicional {

    public static void main(String[] args) {
  
     
        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        // Creo un arreglo para guardar 7 temperaturas (una por cada día)
        double[] temperaturas = new double[diasSemana.length];
        
      
        Scanner scanner = new Scanner(System.in);

        // Empiezo a recorrer cada día de la semana para pedir las temperaturas
        for (int i = 0; i < diasSemana.length; i++) {
            
            // Le pregunto al usuario la temperatura de este día
            System.out.print("Ingrese la temperatura del " + diasSemana[i] + ": ");
            
            // Guardo la temperatura que me dijo el usuario en mi caja
            temperaturas[i] = scanner.nextDouble();
        }

        // Llamo a mi función especial para calcular el promedio de todas las temperaturas
        double promedio = calcularPromedio(temperaturas);
        
        // Muestro el resultado final al usuario
        System.out.println("La temperatura promedio de la semana es: " + promedio);

        // Cierro scanner
        scanner.close();
    }

    // Aquí creo mi función especial para calcular promedios
    public static double calcularPromedio(double[] temperaturas) {
        
        // Empiezo con una suma de cero
        double suma = 0;
        
        // Recorro cada temperatura que tengo guardada
        for (double temp : temperaturas) {
            
            // Voy sumando cada temperatura a mi total
            suma += temp;
        }
        
        // Divido la suma total entre la cantidad de temperaturas para sacar el promedio
        return suma / temperaturas.length;
    }
}