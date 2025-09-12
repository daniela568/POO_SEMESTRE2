/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_13;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestorDatosGUI extends JFrame { // Extiendo JFrame para crear mi ventana principal
    private JTextField campoTexto; // Este campo permite al usuario ingresar datos
    private JButton botonAgregar, botonLimpiar; // Botones para agregar y limpiar datos
    private DefaultListModel<String> modeloLista;
    private JList<String> listaDatos; // Lista visual donde se muestran los datos agregados
 
    public GestorDatosGUI() {
        setTitle("Gestor de Datos Interactivos"); // Le doy un título claro a la ventana
        setSize(400, 300);  // Defino el tamaño de la interfaz
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        setLayout(new BorderLayout());

        // Panel superior: etiqueta + campo de texto
        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Ingrese el dato:"));
        campoTexto = new JTextField(20);
        panelSuperior.add(campoTexto); // Lo agrego al panel
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central: lista de datos
        modeloLista = new DefaultListModel<>();
        listaDatos = new JList<>(modeloLista);
        add(new JScrollPane(listaDatos), BorderLayout.CENTER);

        // Panel inferior: botones
        JPanel panelInferior = new JPanel(new FlowLayout());
        botonAgregar = new JButton("Agregar");  // Botón para añadir datos
        botonLimpiar = new JButton("Limpiar"); // Botón para limpiar campo y lista
        panelInferior.add(botonAgregar); // Agrego botón al panel
        panelInferior.add(botonLimpiar); // Agrego segundo botón
        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        botonAgregar.addActionListener(new ActionListener() { // Manejo el clic en "Agregar"
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText().trim();
                if (!texto.isEmpty()) {  // Verifico que no esté vacío
                    modeloLista.addElement(texto); // Si es válido, lo agrego a la lista
                    campoTexto.setText(""); // Limpio el campo de texto
                } else { // Muestro advertencia si el campo está vacío
                    JOptionPane.showMessageDialog(
                        GestorDatosGUI.this,
                        "No se puede agregar texto vacío.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        botonLimpiar.addActionListener(new ActionListener() { // Manejo el clic en "Limpiar"
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText(""); // Limpio el campo de texto
                modeloLista.clear();  // Borro todos los elementos de la lista
            }
        });
 
        setVisible(true); // Finalmente, muestro la ventana al usuario
    
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorDatosGUI());
    }
}