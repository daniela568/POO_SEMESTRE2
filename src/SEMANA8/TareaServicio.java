/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA8;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author User
 */
/**
 * Gestiona la lista de tareas registradas. Aplica el principio SRP de SOLID.
 */
public class TareaServicio {
    // Aquí creo una lista para guardar todas las tareas que se agreguen.
    private final List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(String nombre, String descripcion) {
        // Este método me permite agregar una nueva tarea a la lista.
    // Recibo el nombre y la descripción, y creo un nuevo objeto de tipo Tarea.
        tareas.add(new Tarea(nombre, descripcion));
    }

    public List<Tarea> obtenerTareas() {
        // Con este método puedo consultar la lista completa de tareas que han sido registradas.
    // Lo uso cuando quiero mostrar todas las tareas al usuario.
        return tareas;
    }
}

