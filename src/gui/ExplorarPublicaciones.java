package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestion.Sistema;
import kernel.Publicacion;
import kernel.TruequeDirecto;

public class ExplorarPublicaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable tablaPublicaciones;

    public ExplorarPublicaciones(
            Principal ventana) {

        setLayout(null);

        // TABLA

        JScrollPane scrollPane =
                new JScrollPane();

        scrollPane.setBounds(
                30,
                30,
                900,
                350);

        add(scrollPane);

        tablaPublicaciones =
                new JTable();

        scrollPane.setViewportView(
                tablaPublicaciones);

        cargarTabla();

        // BOTON VER

        JButton btnVer =
                new JButton(
                        "Ver Detalles");

        btnVer.setBounds(
                80,
                420,
                150,
                35);

        add(btnVer);

        // BOTON OFERTA

        JButton btnOferta =
                new JButton(
                        "Hacer Oferta");

        btnOferta.setBounds(
                300,
                420,
                150,
                35);

        add(btnOferta);

        // BOTON VOLVER

        JButton btnVolver =
                new JButton(
                        "Volver");

        btnVolver.setBounds(
                520,
                420,
                150,
                35);

        add(btnVolver);

        //----------------------------------
        // VER DETALLES
        //----------------------------------

        btnVer.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                int fila =
                        tablaPublicaciones
                        .getSelectedRow();

                if(fila == -1) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione una publicación");

                    return;
                }

                Publicacion p =
                        obtenerPublicacionFila(
                                fila);

                JOptionPane.showMessageDialog(
                        null,

                        "ID: " +
                        p.getId()

                        +

                        "\nDescripción: " +
                        p.getObjeto()
                        .getDescripcion()

                        +

                        "\nCondiciones: " +
                        p.getObjeto()
                        .getCondiciones()

                        +

                        "\nCategoría: " +
                        p.getObjeto()
                        .getCategoria()

                        +

                        "\nPropietario: " +
                        p.getPropietario()
                        .getNombre()

                        +

                        "\nEstado: " +
                        p.getEstado());
            }
        });

        //----------------------------------
        // HACER OFERTA
        //----------------------------------

        btnOferta.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                int fila =
                        tablaPublicaciones
                        .getSelectedRow();

                if(fila == -1) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione una publicación");

                    return;
                }

                Publicacion publicacion =
                        obtenerPublicacionFila(
                                fila);

                if(publicacion instanceof TruequeDirecto) {

                    ventana.setContentPane(

                            new CrearOferta(
                                    ventana,
                                    (TruequeDirecto) publicacion));

                    ventana.revalidate();
                    ventana.repaint();
                }
            }
            });

        //----------------------------------
        // VOLVER
        //----------------------------------

        btnVolver.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                ventana.setContentPane(
                        new Menu(
                                ventana,
                                Sistema.usuarioActual));

                ventana.revalidate();
                ventana.repaint();
            }
        });
    }

    //----------------------------------
    // CARGAR TABLA
    //----------------------------------

    private void cargarTabla() {

        DefaultTableModel modelo =
                new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Objeto");
        modelo.addColumn("Categoría");
        modelo.addColumn("Propietario");
        modelo.addColumn("Estado");

        for(Publicacion p :

                Sistema
                .gestionPublicaciones
                .obtenerPublicacionesDisponibles()) {

            if(p.getPropietario()
                    == Sistema.usuarioActual) {

                continue;
            }

            modelo.addRow(
                    new Object[] {

                            p.getId(),

                            p.getObjeto()
                            .getDescripcion(),

                            p.getObjeto()
                            .getCategoria(),

                            p.getPropietario()
                            .getNombre(),

                            p.getEstado()
                    });
        }

        tablaPublicaciones
                .setModel(modelo);
    }

    //----------------------------------
    // OBTENER PUBLICACION
    //----------------------------------

    private Publicacion
    obtenerPublicacionFila(
            int fila) {

        int contador = -1;

        for(Publicacion p :

                Sistema
                .gestionPublicaciones
                .obtenerPublicacionesDisponibles()) {

            if(p.getPropietario()
                    == Sistema.usuarioActual) {

                continue;
            }

            contador++;

            if(contador == fila) {

                return p;
            }
        }

        return null;
    }
}