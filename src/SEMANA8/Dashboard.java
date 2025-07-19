/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA8;

/**
 *
 * @author User
 */
public class Dashboard {

    public static void main(String[] args) {
        // Creo una instancia de la vista para mostrar mensajes y recibir opciones del usuario
        ConsolaVista vista = new ConsolaVista();
        // También inicializo el servicio que se encargará de registrar y mostrar las tareas.
        TareaServicio servicio = new TareaServicio();
        // Muestro un mensaje de bienvenida al usuario antes de comenzar el menú.
        vista.mostrarBienvenida();

        boolean continuar = true;
        // Aquí empiezo un bucle que se repite hasta que el usuario decida salir.
        while (continuar) {
            // Muestro el menú de opciones 
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            continuar = vista.procesarOpcion(opcion, servicio);
        }
 // Al salir del ciclo, muestro un mensaje de despedida.
        vista.mostrarDespedida();
    }
}