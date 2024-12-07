package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu menuUsuarios, menuInventario, menuFinanzas, menuReportes, menuSalir;
    private JMenuItem agregarUsuarioItem, quitarUsuarioItem, verUsuariosItem;
    private JMenuItem agregarProductoItem, quitarProductoItem, verInventarioItem;
    private JMenuItem agregarDineroItem, quitarDineroItem, verReportesItem;
    private JMenuItem salirItem;
    private JTextArea textArea;

    private ArrayList<String> usuarios;
    private ArrayList<String> inventario;
    private ArrayList<Integer> cantidades;
    private ArrayList<String> finanzas;
    private ArrayList<String> reportesFinancieros;
    private int saldoFinanciero;

    public VentanaPrincipal() {
        usuarios = new ArrayList<>();
        inventario = new ArrayList<>();
        cantidades = new ArrayList<>();
        finanzas = new ArrayList<>();
        reportesFinancieros = new ArrayList<>();
        saldoFinanciero = 0;

        setTitle("Ventana Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        menuBar = new JMenuBar();

        menuUsuarios = new JMenu("Usuarios");
        agregarUsuarioItem = new JMenuItem("Agregar Usuario");
        quitarUsuarioItem = new JMenuItem("Quitar Usuario");
        verUsuariosItem = new JMenuItem("Ver Usuarios");

        menuUsuarios.add(agregarUsuarioItem);
        menuUsuarios.add(quitarUsuarioItem);
        menuUsuarios.add(verUsuariosItem);

        menuInventario = new JMenu("Inventario");
        agregarProductoItem = new JMenuItem("Agregar Producto");
        quitarProductoItem = new JMenuItem("Quitar Producto");
        verInventarioItem = new JMenuItem("Ver Inventario");

        menuInventario.add(agregarProductoItem);
        menuInventario.add(quitarProductoItem);
        menuInventario.add(verInventarioItem);

        menuFinanzas = new JMenu("Finanzas");
        agregarDineroItem = new JMenuItem("Agregar Dinero");
        quitarDineroItem = new JMenuItem("Quitar Dinero");

        menuFinanzas.add(agregarDineroItem);
        menuFinanzas.add(quitarDineroItem);

        menuReportes = new JMenu("Reportes");
        verReportesItem = new JMenuItem("Ver Reportes Financieros");

        menuReportes.add(verReportesItem);

        menuSalir = new JMenu("Salir");
        salirItem = new JMenuItem("Salir");

        menuBar.add(menuUsuarios);
        menuBar.add(menuInventario);
        menuBar.add(menuFinanzas);
        menuBar.add(menuReportes);
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        agregarUsuarioItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });

        quitarUsuarioItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitarUsuario();
            }
        });

        verUsuariosItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarUsuarios();
            }
        });

        agregarProductoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        quitarProductoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitarProducto();
            }
        });

        verInventarioItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInventario();
            }
        });

        agregarDineroItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarDinero();
            }
        });

        quitarDineroItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitarDinero();
            }
        });

        verReportesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarReportesFinancieros();
            }
        });

        salirItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private boolean iniciarSesion() {
        String usuario = JOptionPane.showInputDialog(this, "Ingrese el usuario:");
        String contrasena = JOptionPane.showInputDialog(this, "Ingrese la contraseña:");
        return "admin".equals(usuario) && "admin123".equals(contrasena);
    }

    private void agregarUsuario() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo usuario:");
        String contrasena = JOptionPane.showInputDialog(this, "Ingrese la contraseña del nuevo usuario:");
        if (nombre != null && !nombre.isEmpty() && contrasena != null && !contrasena.isEmpty()) {
            usuarios.add(nombre + " - " + contrasena); 
            JOptionPane.showMessageDialog(this, "Usuario '" + nombre + "' agregado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresó un nombre o contraseña válida.");
        }
    }

    private void quitarUsuario() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario a eliminar:");
        if (nombre != null && !nombre.isEmpty()) {
            boolean eliminado = false;
            for (String usuario : usuarios) {
                if (usuario.contains(nombre)) {
                    usuarios.remove(usuario);
                    eliminado = true;
                    JOptionPane.showMessageDialog(this, "Usuario '" + nombre + "' eliminado con éxito.");
                    break;
                }
            }
            if (!eliminado) {
                JOptionPane.showMessageDialog(this, "El usuario '" + nombre + "' no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresó un nombre válido.");
        }
    }

    private void mostrarUsuarios() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("** Usuarios Registrados **\n");
        if (usuarios.isEmpty()) {
            reporte.append("No hay usuarios registrados.\n");
        } else {
            for (String usuario : usuarios) {
                reporte.append("- " + usuario + "\n");
            }
        }
        textArea.setText(reporte.toString());
    }

    private void agregarProducto() {
        String producto = JOptionPane.showInputDialog(this, "Ingrese el nombre del nuevo producto:");
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad del producto:");
        if (producto != null && !producto.isEmpty() && cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                inventario.add(producto);
                cantidades.add(cantidad);
                JOptionPane.showMessageDialog(this, "Producto '" + producto + "' con cantidad " + cantidad + " agregado al inventario.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Cantidad no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresaron datos válidos.");
        }
    }

    private void quitarProducto() {
        String producto = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto a eliminar:");
        if (producto != null && !producto.isEmpty()) {
            int index = inventario.indexOf(producto);
            if (index != -1) {
                inventario.remove(index);
                cantidades.remove(index);
                JOptionPane.showMessageDialog(this, "Producto '" + producto + "' eliminado del inventario.");
            } else {
                JOptionPane.showMessageDialog(this, "El producto '" + producto + "' no existe en el inventario.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresó un nombre válido.");
        }
    }

    private void mostrarInventario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("** Inventario **\n");
        if (inventario.isEmpty()) {
            reporte.append("No hay productos en el inventario.\n");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                reporte.append("- " + inventario.get(i) + " - Cantidad: " + cantidades.get(i) + "\n");
            }
        }
        textArea.setText(reporte.toString());
    }

    private void agregarDinero() {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a agregar:");
        String motivo = JOptionPane.showInputDialog(this, "Ingrese el motivo de la transacción:");
        if (cantidadStr != null && !cantidadStr.isEmpty() && motivo != null && !motivo.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
                saldoFinanciero += cantidad;
                finanzas.add("Fecha: " + fecha + " - Motivo: " + motivo + " - Monto: $" + cantidad + " - Tipo: Agregar");
                reportesFinancieros.add("Fecha: " + fecha + " - Motivo: " + motivo + " - Monto: $" + cantidad + " - Tipo: Agregar");
                JOptionPane.showMessageDialog(this, "Dinero agregado con éxito.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Cantidad no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Datos no válidos.");
        }
    }

    private void quitarDinero() {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a quitar:");
        String motivo = JOptionPane.showInputDialog(this, "Ingrese el motivo de la transacción:");
        if (cantidadStr != null && !cantidadStr.isEmpty() && motivo != null && !motivo.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad <= saldoFinanciero) {
                    String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
                    saldoFinanciero -= cantidad;
                    finanzas.add("Fecha: " + fecha + " - Motivo: " + motivo + " - Monto: $" + cantidad + " - Tipo: Quitar");
                    reportesFinancieros.add("Fecha: " + fecha + " - Motivo: " + motivo + " - Monto: $" + cantidad + " - Tipo: Quitar");
                    JOptionPane.showMessageDialog(this, "Dinero quitado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Cantidad no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Datos no válidos.");
        }
    }

    private void mostrarReportesFinancieros() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("** Reporte Financiero **\n");
        reporte.append("Saldo Financiero: $" + saldoFinanciero + "\n");
        if (reportesFinancieros.isEmpty()) {
            reporte.append("No hay transacciones registradas.\n");
        } else {
            for (String transaccion : reportesFinancieros) {
                reporte.append(transaccion + "\n");
            }
        }
        textArea.setText(reporte.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                if (ventana.iniciarSesion()) {
                    ventana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                }
            }
        });
    }
} 