/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_3.POOo;

/**
 *
 * @author User
 */
public class Temperatura {
    private String dia;
    private double valor;
 /**
     * Constructor para inicializar una temperatura con su día correspondiente.
     */
    public Temperatura(String dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }
// Método para obtener el valor de la temperatura.
    public double getValor() {
        return valor;
    }
// Método para obtener el nombre del día.
    public String getDia() {
        return dia;
    }
}
