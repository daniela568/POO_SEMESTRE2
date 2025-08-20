/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;
import java.io.*;
import java.util.*;
// importe las clases necesarias para manejar archivos y colecciones en Java.

public class Inventario {
    // Definí esta clase para gestionar un inventario de productos con persistencia en archivo.

    private Map<String, Producto> productos = new HashMap<>();
    // Declaré un mapa para almacenar los productos, usando el código como clave para acceder rápidamente.

    private final String archivo = "inventario.txt";
    // Especifico el nombre del archivo donde guardo el inventario. Lo marqué como constante porque no cambia.

    public Inventario() {
        // Cuando se crea una instancia de Inventario, automáticamente intento cargar los datos desde el archivo.
        cargarDesdeArchivo();
    }

    public void agregarProducto(Producto p) {
        // Este método me permite agregar un nuevo producto al inventario.
        productos.put(p.getCodigo(), p);
        // Lo guardo en el mapa usando su código como clave.
        guardarEnArchivo();
        // Después de agregarlo, actualizo el archivo para que persista el cambio.
        System.out.println(" Producto agregado: " + p.getNombre());
        // Informo al usuario que el producto fue agregado correctamente.
    }

    public void actualizarCantidad(String codigo, int nuevaCantidad) {
        // Este metodo me permite modificar la cantidad de un producto existente.
        Producto p = productos.get(codigo);
        // Busco el producto por su código.
        if (p != null) {
            // Si lo encuentro, actualizo su cantidad.
            p.setCantidad(nuevaCantidad);
            guardarEnArchivo();
            // Guardo los cambios en el archivo.
            System.out.println("?Cantidad actualizada para: " + p.getNombre());
        } else {
            // Si no lo encuentro, informo al usuario.
            System.out.println(" Producto no encontrado.");
        }
    }

    public void eliminarProducto(String codigo) {
        // Este metodo me permite eliminar un producto del inventario.
        if (productos.remove(codigo) != null) {
            // Si el producto existía y fue eliminado, actualizo el archivo.
            guardarEnArchivo();
            System.out.println("️ Producto eliminado.");
        } else {
            // Si no existía, informo que no se encontró.
            System.out.println("️ Producto no encontrado.");
        }
    }

    public void mostrarInventario() {
        // Este método muestra todos los productos del inventario.
        if (productos.isEmpty()) {
            // Si no hay productos, informo que el inventario está vacío.
            System.out.println("Inventario vacío.");
        } else {
            // Si hay productos, los muestro uno por uno.
            productos.values().forEach(p -> System.out.println(p));
        }
    }

    private void guardarEnArchivo() {
        // Este metodo guarda el inventario actual en el archivo de texto.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Uso BufferedWriter para escribir línea por línea.
            for (Producto p : productos.values()) {
                // Recorro todos los productos y escribo su representación en texto.
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            // Si ocurre un error al guardar, lo informo.
            System.out.println(" Error al guardar inventario: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        // Este método carga los productos desde el archivo al iniciar el sistema.
        File f = new File(archivo);
        if (!f.exists()) {
            // Si el archivo no existe, lo creo vacío y aviso al usuario.
            System.out.println(" Archivo de inventario no encontrado. Se creará uno nuevo.");
            guardarEnArchivo();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            // Uso BufferedReader para leer el archivo línea por línea.
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Por cada línea, reconstruyo el producto usando el método fromString.
                Producto p = Producto.fromString(linea);
                productos.put(p.getCodigo(), p);
            }
            System.out.println(" Inventario cargado correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" Error al leer archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Error inesperado: " + e.getMessage());
        }
    }
}