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
// Esta clase me permite validar si un archivo tiene contenido o está vacío.
public class ValidadorArchivo {
    // Este método verifica si el archivo tiene al menos una línea de contenido.
     public void verificarNoVacio(String nombreArchivo) throws IOException, ArchivoVacioException {
       // Esto garantiza que el archivo se cierre automáticamente al finalizar.
         try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
             // Si es null, significa que el archivo no tiene contenido.
             if (reader.readLine() == null) {
                // Lanzo mi excepción personalizada indicando que el archivo está vacío.
                 throw new ArchivoVacioException("El archivo está vacío.");
            }
        }
    }
}
