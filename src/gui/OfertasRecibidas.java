package gui;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestion.Sistema;
import kernel.Oferta;
import kernel.OfertaNoValida;
import kernel.Publicacion;
import kernel.TruequeDirecto;

public class OfertasRecibidas extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable tabla;

    public OfertasRecibidas(
            Principal ventana) {

        setLayout(null);

        JScrollPane scroll =
                new JScrollPane();

        scroll.setBounds(
                30,
                30,
                900,
                350);

        add(scroll);

        tabla = new JTable();

        scroll.setViewportView(
                tabla);

        cargarTabla();

        //---------------------------------
        // BOTON ACEPTAR
        //---------------------------------

        JButton btnAceptar =
                new JButton(
                        "Aceptar");

        btnAceptar.setBounds(
                150,
                420,
                150,
                35);

        add(btnAceptar);

        //---------------------------------
        // BOTON RECHAZAR
        //---------------------------------

        JButton btnRechazar =
                new JButton(
                        "Rechazar");

        btnRechazar.setBounds(
                380,
                420,
                150,
                35);

        add(btnRechazar);

        //---------------------------------
        // BOTON VOLVER
        //---------------------------------

        JButton btnVolver =
                new JButton(
                        "Volver");

        btnVolver.setBounds(
                610,
                420,
                150,
                35);

        add(btnVolver);

        //---------------------------------
        // ACEPTAR OFERTA
        //---------------------------------

        btnAceptar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                int fila =
                        tabla.getSelectedRow();

                if(fila == -1) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione una oferta");

                    return;
                }

                try {

                    OfertaSeleccionada datos =
                            obtenerOferta(fila);

                    datos.trueque
                    .aceptarOferta(
                            datos.oferta);

                    Sistema.gestionUsuarios
                    .guardarTodo();

                    JOptionPane.showMessageDialog(
                            null,
                            "Oferta aceptada");

                    cargarTabla();

                } catch(OfertaNoValida ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMensaje());
                }
            }
        });

        //---------------------------------
        // RECHAZAR OFERTA
        //---------------------------------

        btnRechazar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                int fila =
                        tabla.getSelectedRow();

                if(fila == -1) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione una oferta");

                    return;
                }

                try {

                    OfertaSeleccionada datos =
                            obtenerOferta(fila);

                    datos.trueque
                    .rechazarOferta(
                            datos.oferta);

                    Sistema.gestionUsuarios
                    .guardarTodo();

                    JOptionPane.showMessageDialog(
                            null,
                            "Oferta rechazada");

                    cargarTabla();

                } catch(OfertaNoValida ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMensaje());
                }
            }
        });

        //---------------------------------
        // VOLVER
        //---------------------------------

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

    //---------------------------------
    // CARGAR TABLA
    //---------------------------------

    private void cargarTabla() {

        DefaultTableModel modelo =
                new DefaultTableModel();

        modelo.addColumn(
                "Publicación");

        modelo.addColumn(
                "Usuario");

        modelo.addColumn(
                "Objeto Ofrecido");

        modelo.addColumn(
                "Estado");

        for(Publicacion p :

                Sistema.usuarioActual
                .getPublicaciones()) {

            if(p instanceof TruequeDirecto) {

                TruequeDirecto t =
                        (TruequeDirecto) p;

                for(Oferta o :
                        t.getOfertas()) {

                    modelo.addRow(
                            new Object[] {

                                    p.getObjeto()
                                    .getDescripcion(),

                                    o.getUsuario()
                                    .getNombre(),

                                    o.getObjetoOfrecido()
                                    .getDescripcion(),

                                    o.getEstado()
                            });
                }
            }
        }

        tabla.setModel(modelo);
    }

    //---------------------------------
    // BUSCAR OFERTA
    //---------------------------------

    private OfertaSeleccionada
    obtenerOferta(int fila) {

        int contador = -1;

        for(Publicacion p :

                Sistema.usuarioActual
                .getPublicaciones()) {

            if(p instanceof TruequeDirecto) {

                TruequeDirecto t =
                        (TruequeDirecto) p;

                for(Oferta o :
                        t.getOfertas()) {

                    contador++;

                    if(contador == fila) {

                        return new OfertaSeleccionada(
                                t,
                                o);
                    }
                }
            }
        }

        return null;
    }

    //---------------------------------
    // CLASE AUXILIAR
    //---------------------------------

    private class OfertaSeleccionada {

        TruequeDirecto trueque;
        Oferta oferta;

        public OfertaSeleccionada(
                TruequeDirecto trueque,
                Oferta oferta) {

            this.trueque = trueque;
            this.oferta = oferta;
        }
    }
}
