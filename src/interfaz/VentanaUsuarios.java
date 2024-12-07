package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VentanaUsuarios extends JFrame {
    @SuppressWarnings("unused")
	private ArrayList<String> usuarios;
    private DefaultListModel<String> modeloLista;

    public VentanaUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        modeloLista = new DefaultListModel<>();
        usuarios.forEach(modeloLista::addElement);
        JList<String> listaUsuarios = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);

        JButton btnAgregar = new JButton("Agregar Usuario");
        JButton btnEliminar = new JButton("Eliminar Usuario");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoUsuario = JOptionPane.showInputDialog(VentanaUsuarios.this, 
                        "Ingrese el nombre del nuevo usuario:", 
                        "Agregar Usuario", JOptionPane.PLAIN_MESSAGE);
                if (nuevoUsuario != null && !nuevoUsuario.trim().isEmpty()) {
                    usuarios.add(nuevoUsuario.trim());
                    modeloLista.addElement(nuevoUsuario.trim());
                } else {
                    JOptionPane.showMessageDialog(VentanaUsuarios.this, 
                            "El nombre del usuario no puede estar vacío.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaUsuarios.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    String usuarioSeleccionado = modeloLista.get(indiceSeleccionado);
                    int confirmacion = JOptionPane.showConfirmDialog(VentanaUsuarios.this, 
                            "¿Está seguro de eliminar al usuario \"" + usuarioSeleccionado + "\"?", 
                            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        usuarios.remove(usuarioSeleccionado);
                        modeloLista.remove(indiceSeleccionado);
                    }
                } else {
                    JOptionPane.showMessageDialog(VentanaUsuarios.this, 
                            "Debe seleccionar un usuario para eliminar.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }

	public VentanaUsuarios() {
	}
}
