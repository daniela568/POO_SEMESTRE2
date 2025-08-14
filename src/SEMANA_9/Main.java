/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_9;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        // Creo una instancia de GestorDeArchivo para manejar la escritura y lectura.
        GestorDeArchivo gestor = new GestorDeArchivo();
        // Creo una instancia de ValidadorArchivo para verificar si el archivo está vacío.
        ValidadorArchivo validador = new ValidadorArchivo();
        // Defino el nombre del archivo y el contenido que quiero guardar.
        String nombreArchivo = "ejemplo.txt";
        String contenido = "Hola, este es el contenido del archivo";

        try {
            // Guardar contenido en el archivo
            gestor.guardar(nombreArchivo, contenido);
            System.out.println("Archivo guardado correctamente.");

            // Leer el contenido del archivo
            String leido = gestor.leer(nombreArchivo);
            System.out.println("Contenido leido del archivo:");
            System.out.println(leido);

            // Verificar si el archivo está vacío
            validador.verificarNoVacio(nombreArchivo);
            System.out.println("El archivo NO esta vacio.");

        } catch (ArchivoVacioException ave) {
            // Si el archivo está vacío, capturo la excepción personalizada y muestro el mensaje.
            System.out.println("Error: " + ave.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}

