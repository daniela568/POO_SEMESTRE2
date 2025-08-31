/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_11;
import java.util.*;
/**
 *
 * @author User
 */

 
public class BuggyActividadCorregido {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Corrección 1: Validar índice antes de acceder
        if (nombres.size() > 3) {
            System.out.println("Elemento en posición 3: " + nombres.get(3));
        } else {
            System.out.println("No hay elemento en la posición 3. Tamaño actual: " + nombres.size());
        }

        // Corrección 2: Comparar cadenas con equals()
        String buscado = new String("Ana"); 
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Ana", "0993333333"); // sobrescribe sin control (válido en HashMap)

        // Corrección 3: Validar existencia de clave antes de acceder
        if (telefonos.containsKey("Bea")) {
            System.out.println("Bea: " + telefonos.get("Bea"));
        } else {
            System.out.println("Bea no está registrada en el mapa de teléfonos.");
        }

        // SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico

        // Corrección 4: Implementar equals() y hashCode() en Alumno
        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

// Clase Alumno con métodos equals() y hashCode() implementados
class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alumno)) return false;
        Alumno otro = (Alumno) obj;
        return this.id == otro.id && Objects.equals(this.nombre, otro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}

