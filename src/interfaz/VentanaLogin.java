package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaLogin extends JFrame {
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "admin123";

    public VentanaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelUsuario = new JLabel("Usuario:");
        JTextField campoUsuario = new JTextField();
        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField();
        JButton btnIngresar = new JButton("Ingresar");

        panel.add(labelUsuario);
        panel.add(campoUsuario);
        panel.add(labelContrasena);
        panel.add(campoContrasena);
        panel.add(new JLabel()); 
        panel.add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());

                if (USUARIO.equals(usuario) && CONTRASENA.equals(contrasena)) {
                    new VentanaPrincipal().setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(VentanaLogin.this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }
}
