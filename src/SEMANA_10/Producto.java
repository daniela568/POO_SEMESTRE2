/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;

/**
 *
 * @author User
 */
public class Producto {
    // definí esta clase para representar un producto dentro del sistema.

    private String codigo;
    // Declare esta variable para guardar el código único que identifica cada producto.

    private String nombre;
    // Aquí almaceno el nombre del producto

    private int cantidad;
    // Esta variable me permite llevar el control de cuántas unidades hay disponibles.

    public Producto(String codigo, String nombre, int cantidad) {
        // Construí este constructor para inicializar un producto con sus datos básicos.
        this.codigo = codigo;
        // Asigno el código recibido al atributo interno.
        this.nombre = nombre;
        // Asigno el nombre recibido al atributo correspondiente.
        this.cantidad = cantidad;
        // Asigno la cantidad inicial al atributo 'cantidad'.
    }

    public String getCodigo() { return codigo; }
    // Implementé este método para poder consultar el código del producto.

    public String getNombre() { return nombre; }
    // Este método permite obtener el nombre del producto cuando se necesite.

    public int getCantidad() { return cantidad; }
    // Con este método devuelvo la cantidad actual del producto.

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    

    @Override
    public String toString() {
        // Redefiní el método toString para mostrar el producto como una línea de texto.
        return codigo + "," + nombre + "," + cantidad;
        // Devuelvo los datos del producto separados por comas, útil para guardar en archivos.
    }

    public static Producto fromString(String linea) {
        // Creé este método estático para reconstruir un producto a partir de una línea de texto.
        String[] partes = linea.split(",");
        // Divido la línea en partes usando la coma como separador.
        return new Producto(partes[0], partes[1], Integer.parseInt(partes[2]));
        // Uso las partes obtenidas para crear un nuevo objeto Producto.
    }
}