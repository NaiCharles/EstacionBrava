package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class VentanaReportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<String> finanzas;
    private JButton btnGenerarReporte;

    public VentanaReportes(ArrayList<String> finanzas) {
        this.finanzas = finanzas;
        setTitle("Generar Reporte");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        btnGenerarReporte = new JButton("Generar Reporte");
        panel.add(btnGenerarReporte);
        add(panel, BorderLayout.CENTER);

        btnGenerarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
    }

    private void generarReporte() {
        if (finanzas != null && !finanzas.isEmpty()) {
            StringBuilder reporte = new StringBuilder();

            reporte.append("Reporte de Finanzas:\n");
            for (String line : finanzas) {
                reporte.append(line).append("\n");
            }

            JOptionPane.showMessageDialog(this, "Reporte generado:\n" + reporte.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos disponibles para generar el reporte.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaReportes(new ArrayList<>()).setVisible(true);
            }
        });
    }
}
