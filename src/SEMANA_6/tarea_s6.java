/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

/**
 *
 * @author User
 * 
 */
public class tarea_s6 {

    // Clase principal que representa a un Empleado
    class Empleado {
        private String nombre; // Encapsulo el nombre como atributo privado

        public Empleado(String nombre) {
            this.nombre = nombre; // Inicializo el nombre desde el constructor
        }

        public String getNombre() {
            return nombre; // Permito acceso al nombre con este método público
        }

        public void trabajar() {
            // Método que puede ser sobrescrito: muestra acción genérica
            System.out.println(nombre + " está realizando tareas generales.");
        }
    }

    // Clase derivada que hereda de Empleado
    class Desarrollador extends Empleado {
        public Desarrollador(String nombre) {
            super(nombre); // Llamo al constructor de la clase base
        }

        // Sobrescribo el método trabajar para mostrar polimorfismo
        @Override
        public void trabajar() {
            System.out.println(getNombre() + " está programando en Java.");
        }
    }

    public static void main(String[] args) {
        tarea_s6 programa = new tarea_s6(); // Instancia externa para acceder a clases internas

        Empleado e = programa.new Empleado("Ana");              // Uso clase base
        Desarrollador d = programa.new Desarrollador("Daniela");   // Uso clase derivada

        e.trabajar(); // Llamada al método de la clase base
        d.trabajar(); // Llamada al método sobrescrito (polimorfismo)

        // Acceso al nombre mediante encapsulación
        System.out.println("Nombre del desarrollador: " + d.getNombre());
    }
}
