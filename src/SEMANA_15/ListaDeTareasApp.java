/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_15;

/**
 *
 * @author User
 */

//Importo las librerias necessarias
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// creo mi clase principal para la aplicación de lista de tareas
public class ListaDeTareasApp {
    // declaro el modelo de lista que almacenará las tareas
    private DefaultListModel<String> modeloLista;
    // creo la lista visual que mostrará las tareas
    private JList<String> listaTareas;
    // campo de texto donde el usuario escribe la nueva tarea
    private JTextField campoTarea;
    
    // constructor donde configuro toda la interfaz gráfica
    public ListaDeTareasApp() {
        // creo la ventana principal con título.
        JFrame ventana = new JFrame("Gestor de Tareas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300); // Establezco el tamaño de la ventana
        ventana.setLayout(new BorderLayout());

        // inicializo el modelo y la lista, y le asigno un renderizador personalizado
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        listaTareas.setCellRenderer(new TareaRenderer());

        // configuro el campo de texto y los botones
        campoTarea = new JTextField();
        JButton botonAgregar = new JButton("Añadir Tarea"); // creo el botón para añadir una nueva tarea
        JButton botonCompletar = new JButton("Marcar como Completada"); // Creo el botón para marcar una tarea como completada
        JButton botonEliminar = new JButton("Eliminar Tarea"); // creo el botón para eliminar una tarea seleccionada

        // organizo el panel superior con el campo de texto y el botón de añadir
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(campoTarea, BorderLayout.CENTER); // agrego el campo de texto al centro del panel superior
        panelSuperior.add(botonAgregar, BorderLayout.EAST);

        // organizo el panel inferior con los botones de completar y eliminar
        JPanel panelInferior = new JPanel();
        panelInferior.add(botonCompletar);  // arego el botón de completar al panel inferior
        panelInferior.add(botonEliminar); // agrego el botón de eliminar al panel inferior

        // agrego los paneles y la lista a la ventana
        ventana.add(panelSuperior, BorderLayout.NORTH);
        ventana.add(new JScrollPane(listaTareas), BorderLayout.CENTER);  // agrego la lista de tareas
        ventana.add(panelInferior, BorderLayout.SOUTH);

        // programo el botón de añadir para que agregue una tarea
        botonAgregar.addActionListener(e -> agregarTarea());

        // también permito añadir tareas presionando Enter en el campo de texto
        campoTarea.addActionListener(e -> agregarTarea());

        // programo el botón para marcar tareas como completadas
        botonCompletar.addActionListener(e -> marcarCompletada());

        // programo el botón para eliminar tareas
        botonEliminar.addActionListener(e -> eliminarTarea());

        // permito marcar tareas como completadas haciendo doble clic sobre ellas
        listaTareas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) { // verifico si el clic fue doble
                if (e.getClickCount() == 2) {
                    marcarCompletada();  // Llamo al método para marcar la tarea 
                }
            }
        });

        // finalmente hago visible la ventana
        ventana.setVisible(true);
    }

    // metodo para añadir una tarea al modelo
    private void agregarTarea() {
        String texto = campoTarea.getText().trim();
        if (!texto.isEmpty()) { // agrego la tarea al modelo de lista
            modeloLista.addElement(texto);
            campoTarea.setText(""); // limpio el campo de texto
        }
    }

    // Método para marcar una tarea como completada.
    private void marcarCompletada() {
        int index = listaTareas.getSelectedIndex(); // obtengo el índice de la tarea
        if (index != -1) { // vrifico que haya una tarea seleccionada
            String tarea = modeloLista.getElementAt(index);
            if (!tarea.startsWith("[✔] ")) { // vrifico que no esté ya marcada como completada
                modeloLista.set(index, "[✔] " + tarea); // Actualizo el texto de la tarea 
            }
        }
    }

    // Método para eliminar una tarea seleccionada.
    private void eliminarTarea() {
        int index = listaTareas.getSelectedIndex(); // obtengo el índice 
        if (index != -1) { // vrifico que haya una tarea seleccionad
            modeloLista.remove(index); // elimino la tarea
        }
    }

    // Clase interna para personalizar cómo se ven las tareas en la lista.
    private static class TareaRenderer extends DefaultListCellRenderer {
        // metodo que define el estilo visual de cada tarea
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Llamo al método original
            String texto = value.toString(); 
            if (texto.startsWith("[✔] ")) {  // s la tarea está marcada como completadacambio su estilo
                label.setForeground(Color.GRAY);   // cmbio el color del texto a gris
                label.setFont(label.getFont().deriveFont(Font.ITALIC));  // cambio la fuente a cursiva
            } else { // s no está completada uso color negro y fuente normal
                label.setForeground(Color.BLACK);
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
            }
            return label;
        }
    }

    // Método principal.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListaDeTareasApp::new);
    }
}