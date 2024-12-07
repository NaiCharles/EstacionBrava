package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VentanaInventario extends JFrame {

    private ArrayList<String> inventario;

    public VentanaInventario(ArrayList<String> inventario) {
        this.inventario = inventario;

        setTitle("Gestion de Inventario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JTextField nombreProducto = new JTextField(15);
        JTextField cantidadProducto = new JTextField(5);
        panel.add(new JLabel("Producto:"));
        panel.add(nombreProducto);
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadProducto);

        JButton agregarBtn = new JButton("Agregar Producto");
        JButton quitarBtn = new JButton("Quitar Producto");

        panel.add(agregarBtn);
        panel.add(quitarBtn);

        add(panel);

        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreProducto.getText();
                String cantidad = cantidadProducto.getText();
                if (!nombre.isEmpty() && !cantidad.isEmpty()) {
                    inventario.add("Producto: " + nombre + " - Cantidad: " + cantidad);
                    guardarInventario();
                    JOptionPane.showMessageDialog(null, "Producto agregado.");
                    nombreProducto.setText("");
                    cantidadProducto.setText("");
                }
            }
        });

        quitarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreProducto.getText();
                if (!nombre.isEmpty()) {
                    boolean encontrado = false;
                    for (int i = 0; i < inventario.size(); i++) {
                        if (inventario.get(i).contains(nombre)) {
                            inventario.remove(i);
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) {
                        guardarInventario();
                        JOptionPane.showMessageDialog(null, "Producto quitado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    nombreProducto.setText("");
                }
            }
        });
    }

    private void guardarInventario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.txt"))) {
            for (String item : inventario) {
                bw.write(item);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
