/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_16;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class ListaConTeclaC {
    public static void main(String[] args) {
        // Inicio la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new ListaConTeclaC().crearInterfaz());
    }

    public void crearInterfaz() {
        // Creo la ventana principal con título y tamaño definido
        JFrame frame = new JFrame("Interfaz con JList y tecla C");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Defino el modelo de datos para la lista
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        modeloLista.addElement("Elemento 1");
        modeloLista.addElement("Elemento 2");
        modeloLista.addElement("Elemento 3");

        // Creo la JList con el modelo y configuro selección única
        JList<String> lista = new JList<>(modeloLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setFocusable(true); // Me aseguro de que pueda recibir eventos de teclado

        // Agrego un botón decorativo en la parte inferior
        JButton boton = new JButton("Botón de prueba");

        // Organizo los componentes en un panel con BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(lista), BorderLayout.CENTER); // La lista va al centro
        panel.add(boton, BorderLayout.SOUTH); // El botón va abajo

        // Configuro el Key Binding para detectar la tecla 'C'
        InputMap inputMap = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = lista.getActionMap();

        // Asocio la tecla 'C' con la acción "presionarC"
        inputMap.put(KeyStroke.getKeyStroke('C'), "presionarC");

        // Defino qué ocurre cuando se presiona la tecla 'C'
        actionMap.put("presionarC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lista.getSelectedIndex(); // Verifico si hay un elemento seleccionado
                if (index != -1) {
                    String elemento = modeloLista.getElementAt(index); // Obtengo el texto del elemento
                    System.out.println("Tecla C presionada. Elemento seleccionado: " + elemento);

                    // Alterno el estado del elemento: si ya tiene el sufijo [✓], lo quito; si no, lo agrego
                    if (elemento.endsWith(" [✓]")) {
                        modeloLista.set(index, elemento.replace(" [✓]", ""));
                    } else {
                        modeloLista.set(index, elemento + " [✓]");
                    }
                } else {
                    System.out.println("Tecla C presionada pero ningún elemento está seleccionado.");
                }
            }
        });

        // Agrego el panel a la ventana y la muestro
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Centro la ventana en la pantalla
        frame.setVisible(true); // Hago visible la interfaz
    }
}