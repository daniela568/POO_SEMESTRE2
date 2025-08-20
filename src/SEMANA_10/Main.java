/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;

/**
 *
 * @author User
 */
import java.util.Scanner;
// Importe la clase Scanner para poder leer entradas del usuario desde la consola.

public class Main {
    // Defini esta clase como punto de entrada principal para ejecutar el sistema de inventario.

    public static void main(String[] args) {
        // Este es el metodo principal que se ejecuta al iniciar el programa.

        Inventario inventario = new Inventario();
        // Instancio mi clase Inventario, lo que automáticamente carga los datos desde el archivo.

        Scanner sc = new Scanner(System.in);
        // Creo un objeto Scanner para leer las opciones y datos que el usuario ingrese.

        String opcion;
        // Declaro una variable para guardar la opción seleccionada por el usuario.

        do {
            // Utilizo un bucle do-while para mostrar el menú hasta que el usuario decida salir.

            System.out.println("\n MENU DE INVENTARIO");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar cantidad");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine();
            // Muestro el menu y leo la opción ingresada por el usuario.

            switch (opcion) {
                // Uso un switch para ejecutar la acción correspondiente según la opción elegida.

                case "1":
                    // Si elige agregar producto, solicito los datos necesarios.
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cant = Integer.parseInt(sc.nextLine());
                    // Creo un nuevo producto con los datos ingresados.
                    inventario.agregarProducto(new Producto(cod, nom, cant));
                    // Lo agrego al inventario.
                    break;

                case "2":
                    // Si elige actualizar cantidad, pido el código y la nueva cantidad.
                    System.out.print("Codigo del producto: ");
                    String codAct = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCant = Integer.parseInt(sc.nextLine());
                    inventario.actualizarCantidad(codAct, nuevaCant);
                    // Actualizo la cantidad en el inventario.
                    break;

                case "3":
                    // Si elige eliminar producto, pido el código.
                    System.out.print("Código del producto a eliminar: ");
                    String codDel = sc.nextLine();
                    inventario.eliminarProducto(codDel);
                    // Elimino el producto del inventario.
                    break;

                case "4":
                    // Si elige mostrar inventario, llamo al método correspondiente.
                    inventario.mostrarInventario();
                    break;

                case "0":
                    // Si elige salir, muestro un mensaje de despedida.
                    System.out.println("?Saliendo del sistema...");
                    break;

                default:
                    // Si ingresa una opción inválida, lo informo.
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("0"));
        // El bucle continúa hasta que el usuario ingrese "0" para salir.
    }
}