/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_14;

/**
 *
 * @author User
 */
// GestorEventos.java


import javax.swing.*;  // Importo todo lo necesario para crear ventanas, botones, tablas
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*; // Importo eventos, como clics de botones
import java.text.SimpleDateFormat; // Importo formato de fecha 
import java.util.Date;   // Importo la clase Date para trabajar con fechas y horas

// Creo una clase que hereda de JFrame
public class GestorEventos extends JFrame {

    // Aquí guardo los campos que el usuario va a llenar: fecha, hora y descripción
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextField campoDescripcion;
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;

    // Este es el constructor donde armo toda la interfaz
    public GestorEventos() {
        super("Agenda de Eventos"); // Le pongo un título a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si el usuario cierra, el programa termina
        setSize(600, 400); // Le doy tamaño a la ventana
        setLocationRelativeTo(null); // La centro en la pantalla
        setLayout(new BorderLayout()); // Uso un diseño que me permite organizar por zonas

        // Creo un panel para que el usuario ingrese los datos del evento
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Nuevo Evento"));

        // Campo para la fecha
        panelEntrada.add(new JLabel("Fecha (dd/MM/yyyy):"));
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
        panelEntrada.add(spinnerFecha);

        // Campo para la hora
        panelEntrada.add(new JLabel("Hora (HH:mm):"));
        spinnerHora = new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));
        panelEntrada.add(spinnerHora);

        // Campo para la descripción del evento
        panelEntrada.add(new JLabel("Descripción:"));
        campoDescripcion = new JTextField();
        panelEntrada.add(campoDescripcion);

        // Coloco este panel en la parte superior de la ventana
        add(panelEntrada, BorderLayout.NORTH);

        // Creo la tabla donde se van a mostrar los eventos
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0);
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEventos);
        add(scrollTabla, BorderLayout.CENTER); // La pongo en el centro

        // Panel con los botones de acción
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAgregar = new JButton("Agregar"); // Botón para agregar eventos
        JButton btnEliminar = new JButton("Eliminar seleccionado"); // Botón para eliminar el evento seleccionado
        JButton btnSalir = new JButton("Salir"); // Botón para cerrar la aplicación

        // Agrego los botones al panel
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH); // Lo pongo abajo

        // Cuando el usuario hace clic en "Agregar"
        btnAgregar.addActionListener(e -> {
            String descripcion = campoDescripcion.getText().trim(); // Tomo lo que escribió
            if (descripcion.isEmpty()) {
                // Si no escribió nada, muestro un mensaje
                JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tomo la fecha y la hora que seleccionó
            Date fecha = (Date) spinnerFecha.getValue();
            Date hora = (Date) spinnerHora.getValue();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

            // Agrego el evento a la tabla
            modeloTabla.addRow(new Object[]{
                formatoFecha.format(fecha),
                formatoHora.format(hora),
                descripcion
            });

            // Limpio el campo de descripción para el siguiente evento
            campoDescripcion.setText("");
            campoDescripcion.requestFocus();
        });

        // Cuando el usuario hace clic en "Eliminar"
        btnEliminar.addActionListener(e -> {
            int fila = tablaEventos.getSelectedRow(); // Veo si hay una fila seleccionada
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un evento primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Pido confirmación antes de borrar
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Eliminar el evento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                modeloTabla.removeRow(fila); // Borro la fila
            }
        });

        // Cuando el usuario hace clic en "Salir"
        btnSalir.addActionListener(e -> dispose()); // Cierro la ventana
    }

    // Este es el punto de entrada del programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorEventos().setVisible(true)); // Muestro la ventana
    }
}