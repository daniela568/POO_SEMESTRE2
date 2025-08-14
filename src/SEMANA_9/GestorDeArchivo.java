/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_9;
import java.io.*;
/**
 *
 * @author User
 */
public class GestorDeArchivo {
    // Este método me permite guardar contenido en un archivo de texto.
    public void guardar(String nombreArchivo, String contenido) throws IOException {
       // Esto asegura que el archivo se cierre automáticamente cuando termine.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
        }
         // Si ocurre algún problema al escribir, lanzo una IOException.
    }
    // Este método me permite leer el contenido de un archivo línea por línea.
    public String leer(String nombreArchivo) throws IOException {
       // Uso un StringBuilder para ir acumulando el texto que leo del archivo.
        StringBuilder contenido = new StringBuilder();
        // Así me aseguro de que el archivo se cierre automáticamente al terminar.
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
           // Leo cada línea del archivo en un bucle.
            String linea;
            while ((linea = reader.readLine()) != null) {
               // Agrego la línea al contenido, seguida de un salto de línea.
                contenido.append(linea).append("\n");
            }
        }
        // Devuelvo todo el contenido leído como un solo String.
        return contenido.toString();
    }

}
