package SEMANA_9;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
// Esta clase representa una excepción personalizada que yo puedo lanzar si detecto que un archivo está vacío.
public class ArchivoVacioException extends Exception {
    // Aquí defino el constructor de la excepción. Recibo un mensaje que describe el error.
     public ArchivoVacioException(String mensaje) {
         // Llamo al constructor de la clase Exception para guardar el mensaje de error.
        super(mensaje);
    }
}
