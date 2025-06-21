/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_4; 

import java.util.ArrayList; // Importo ArrayList para crear listas dinámicas que necesito
import java.util.List; // Importo List para manejar mis colecciones de productos

class Producto { // Creo mi clase Producto 
    private String nombre; // Declaro el nombre del producto 
    private double precio; // Declaro el precio como privado 
    private int cantidad; 

    public Producto(String nombre, double precio, int cantidad) { // Creo el constructor para inicializar mis productos
        this.nombre = nombre; // Asigno el nombre que recibo al atributo de mi objeto
        this.precio = precio; // Asigno el precio que recibo al atributo de mi objeto
        this.cantidad = cantidad; // Asigno la cantidad que recibo al atributo de mi objeto
    }

    public String getNombre() { // Creo el método para obtener el nombre del producto
        return nombre; // Retorno el nombre que tengo guardado
    }

    public double getPrecio() { // Creo el método para obtener el precio del producto
        return precio; // Retorno el precio que tengo guardado
    }

    public int getCantidad() { // Creo el método para obtener la cantidad disponible
        return cantidad; // Retorno la cantidad que tengo guardada
    }

    public void setCantidad(int cantidad) { // Creo el método para modificar la cantidad del producto
        this.cantidad = cantidad; // Asigno la nueva cantidad al atributo de mi objeto
    }

    public void mostrarInfo() { // Creo método para mostrar la información del producto
        System.out.println(nombre + " - $" + precio + " - Stock: " + cantidad); // Imprimo toda la información del producto
    }
}

public class Vida_real { // Creo mi clase principal 
    private static List<Producto> productos = new ArrayList<>(); // Declaro mi lista 
    private static double caja = 0; // Declaro mi variable estática para llevar el control del dinero

    public static void main(String[] args) { // Creo el método principal donde inicia mi programa
        
        // Creo mis productos iniciales para tener inventario
        productos.add(new Producto("Camisa", 25.99, 10)); // Agrego una camisa con precio
        productos.add(new Producto("Pantalón", 35.50, 5)); // Agrego un pantalón con precio 

        // Muestro el inventario inicial que tengo
        System.out.println("--- Inventario ---"); // Imprimo el título de mi inventario
        for (Producto p : productos) { // Recorro cada producto que tengo en mi lista
            p.mostrarInfo(); // Llamo al método para mostrar la información de cada producto
        }

        // Realizo algunas ventas para probar mi sistema
        System.out.println("\n--- Ventas ---"); 
        vender("Camisa", 2); 
        vender("Pantalón", 1); 

        // Muestro el estado final después de las ventas
        System.out.println("\n--- Inventario Final ---"); // Imprimo el título del inventario final
        for (Producto p : productos) { // Recorro nuevamente cada producto para ver el stock final
            p.mostrarInfo(); // Muestro la información actualizada de cada producto
        }
        System.out.println("Dinero en caja: $" + caja); // Imprimo el total de dinero que tengo en caja
    }

    private static void vender(String nombre, int cantidad) { // Creo mi método para realizar ventas de productos
        for (Producto p : productos) { // Busco el producto recorriendo toda mi lista
            if (p.getNombre().equals(nombre)) { // Verifico si el nombre del producto coincide con lo que quiero vender
                if (p.getCantidad() >= cantidad) { // Verifico si tengo suficiente stock para la venta
                    p.setCantidad(p.getCantidad() - cantidad); // Resto la cantidad vendida del stock actual
                    double total = p.getPrecio() * cantidad; // Calculo el total multiplicando precio por cantidad
                    caja += total; // Sumo el dinero de la venta a mi caja
                    System.out.println("Vendido: " + cantidad + " " + nombre + " - Total: $" + total); // Confirmo la venta realizada
                } else { // Si no tengo suficiente stock
                    System.out.println("Stock insuficiente"); // Informo que no puedo realizar la venta
                }
                return; // Salgo del método porque ya encontré el producto (exista o no stock)
            }
        }
        System.out.println("Producto no encontrado"); // Si llego aquí es porque no encontré el producto en mi lista
    }
}
//FIN