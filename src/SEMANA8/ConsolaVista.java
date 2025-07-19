/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA8;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class ConsolaVista {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarBienvenida() {
        System.out.println(" Bienvenido al sistema de tareas - Proyecto POO Java");
    }

    public void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Registrar nueva tarea");
        System.out.println("2. Mostrar todas las tareas");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int leerOpcion() {
        return scanner.nextInt();
    }

    public boolean procesarOpcion(int opcion, TareaServicio servicio) {
        scanner.nextLine();  // Limpia el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese nombre de la tarea: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese descripcion: ");
                String descripcion = scanner.nextLine();
                servicio.agregarTarea(nombre, descripcion);
                System.out.println(" Tarea registrada.");
                break;
            case 2:
                System.out.println(" Lista de tareas:");
                servicio.obtenerTareas().forEach(System.out::println);
                break;
            case 0:
                return false;
            default:
                System.out.println("️ Opción no válida.");
        }
        return true;
    }

    public void mostrarDespedida() {
        System.out.println("\n Gracias por usar el proyecto. ¡Hasta pronto!");
    }
}