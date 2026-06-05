package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestion.Sistema;
import kernel.Oferta;
import kernel.TruequeDirecto;

public class VerOfertas extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable tablaOfertas;

    public VerOfertas(
            Principal ventana,
            TruequeDirecto trueque) {

        setLayout(null);

        JScrollPane scroll =
                new JScrollPane();

        scroll.setBounds(
                50,
                50,
                850,
                300);

        add(scroll);

        tablaOfertas =
                new JTable();

        scroll.setViewportView(
                tablaOfertas);

        cargarTabla(trueque);

        JButton btnAceptar =
                new JButton("Aceptar");

        btnAceptar.setBounds(
                100,
                400,
                120,
                35);

        add(btnAceptar);

        JButton btnRechazar =
                new JButton("Rechazar");

        btnRechazar.setBounds(
                260,
                400,
                120,
                35);

        add(btnRechazar);

        JButton btnVolver =
                new JButton("Volver");

        btnVolver.setBounds(
                420,
                400,
                120,
                35);

        add(btnVolver);

        //--------------------------------
        // ACEPTAR
        //--------------------------------

        btnAceptar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                try {

                    int fila =
                            tablaOfertas
                            .getSelectedRow();

                    if(fila == -1) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Seleccione una oferta");

                        return;
                    }

                    Oferta oferta =
                            trueque
                            .getOfertas()
                            .get(fila);

                    trueque.aceptarOferta(
                            oferta);

                    Sistema.gestionUsuarios
                            .guardarTodo();

                    cargarTabla(trueque);

                    JOptionPane.showMessageDialog(
                            null,
                            "Oferta aceptada");

                } catch(Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage());
                }
            }
        });

        //--------------------------------
        // RECHAZAR
        //--------------------------------

        btnRechazar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                try {

                    int fila =
                            tablaOfertas
                            .getSelectedRow();

                    if(fila == -1) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Seleccione una oferta");

                        return;
                    }

                    Oferta oferta =
                            trueque
                            .getOfertas()
                            .get(fila);

                    trueque.rechazarOferta(
                            oferta);

                    Sistema.gestionUsuarios
                            .guardarTodo();

                    cargarTabla(trueque);

                    JOptionPane.showMessageDialog(
                            null,
                            "Oferta rechazada");

                } catch(Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage());
                }
            }
        });

        //--------------------------------
        // VOLVER
        //--------------------------------

        btnVolver.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                ventana.setContentPane(
                        new MisPublicaciones(
                                ventana,
                                Sistema.usuarioActual));

                ventana.revalidate();
                ventana.repaint();
            }
        });
    }

    //--------------------------------
    // TABLA
    //--------------------------------

    private void cargarTabla(
            TruequeDirecto trueque) {

        DefaultTableModel modelo =
                new DefaultTableModel();

        modelo.addColumn("Usuario");
        modelo.addColumn("Objeto Ofrecido");
        modelo.addColumn("Estado");

        for(Oferta o :
                trueque.getOfertas()) {

            modelo.addRow(
                    new Object[] {

                            o.getUsuario()
                            .getNombre(),

                            o.getObjetoOfrecido()
                            .getDescripcion(),

                            o.getEstado()
                    });
        }

        tablaOfertas.setModel(
                modelo);
    }
}
