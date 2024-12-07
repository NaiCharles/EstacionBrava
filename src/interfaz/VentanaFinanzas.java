package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VentanaFinanzas extends JFrame {

    private ArrayList<String> finanzas;

    public VentanaFinanzas(ArrayList<String> finanzas) {
        this.finanzas = finanzas;

        setTitle("Revisar Fianzas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JTextField monto = new JTextField(10);
        JTextField motivo = new JTextField(10);
        panel.add(new JLabel("Monto:"));
        panel.add(monto);
        panel.add(new JLabel("Motivo:"));
        panel.add(motivo);

        JButton agregarBtn = new JButton("Agregar");
        JButton retirarBtn = new JButton("Retirar");

        panel.add(agregarBtn);
        panel.add(retirarBtn);

        add(panel);

        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String motivoTexto = motivo.getText();
                String montoTexto = monto.getText();
                if (!motivoTexto.isEmpty() && !montoTexto.isEmpty()) {
                    finanzas.add("Ingreso: $" + montoTexto + " - Motivo: " + motivoTexto + " - Fecha: " + java.time.LocalDate.now());
                    cargarFinanzas();
                    JOptionPane.showMessageDialog(null, "Dinero agregado.");
                    motivo.setText("");
                    monto.setText("");
                }
            }
        });

        retirarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String motivoTexto = motivo.getText();
                String montoTexto = monto.getText();
                if (!motivoTexto.isEmpty() && !montoTexto.isEmpty()) {
                    finanzas.add("Retiro: $" + montoTexto + " - Motivo: " + motivoTexto + " - Fecha: " + java.time.LocalDate.now());
                    cargarFinanzas();
                    JOptionPane.showMessageDialog(null, "Dinero retirado.");
                    motivo.setText("");
                    monto.setText("");
                }
            }
        });
    }

    public void cargarFinanzas() {
        File finanzasFile = new File("finanzas.txt");
        if (!finanzasFile.exists()) {
            try {
                finanzasFile.createNewFile(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(finanzasFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                finanzas.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
