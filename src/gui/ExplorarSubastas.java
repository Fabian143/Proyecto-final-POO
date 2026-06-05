package ggui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import gestion.Sistema;
import kernel.Publicacion;
import kernel.SubastaTiempoLimitado;

public class ExplorarSubastas extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tablaSubastas;

    public ExplorarSubastas(Principal ventana) {
        setLayout(null);

        // TÍTULO
        JLabel lblTitulo = new JLabel("Subastas Disponibles");
        lblTitulo.setBounds(400, 20, 200, 30);
        add(lblTitulo);

        // TABLA
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 60, 880, 400);
        add(scrollPane);

        tablaSubastas = new JTable();
        scrollPane.setViewportView(tablaSubastas);
        cargarTabla();

        // BOTÓN VER DETALLE
        JButton btnVer = new JButton("Ver Subasta");
        btnVer.setBounds(350, 500, 150, 35);
        add(btnVer);

        // BOTÓN VOLVER
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(550, 500, 150, 35);
        add(btnVolver);

        // EVENTO VER
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tablaSubastas.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una subasta");
                    return;
                }

                SubastaTiempoLimitado subasta = obtenerSubasta(fila);
                if (subasta != null) {
                    ventana.setContentPane(new VerSubasta(ventana, subasta));
                    ventana.revalidate();
                    ventana.repaint();
                }
            }
        });

        // EVENTO VOLVER
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new Menu(ventana, Sistema.usuarioActual));
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }

    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Objeto");
        modelo.addColumn("Categoría");
        modelo.addColumn("Propietario");
        modelo.addColumn("Estado");

        for (Publicacion p : Sistema.gestionPublicaciones.obtenerPublicacionesDisponibles()) {
            // Solo mostrar subastas que no sean del usuario actual
            if (p instanceof SubastaTiempoLimitado && p.getPropietario() != Sistema.usuarioActual) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getObjeto().getDescripcion(),
                    p.getObjeto().getCategoria(),
                    p.getPropietario().getNombre(),
                    p.getEstado()
                });
            }
        }

        tablaSubastas.setModel(modelo);
    }

    private SubastaTiempoLimitado obtenerSubasta(int fila) {
        int contador = -1;
        for (Publicacion p : Sistema.gestionPublicaciones.obtenerPublicacionesDisponibles()) {
            if (p instanceof SubastaTiempoLimitado && p.getPropietario() != Sistema.usuarioActual) {
                contador++;
                if (contador == fila) {
                    return (SubastaTiempoLimitado) p;
                }
            }
        }
        return null;
    }
}