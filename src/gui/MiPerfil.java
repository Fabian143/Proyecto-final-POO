package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kernel.UsuarioNormal;

public class MiPerfil extends JPanel {

    private static final long serialVersionUID = 1L;

    public MiPerfil(
            Principal ventana,
            UsuarioNormal usuario) {

        setLayout(null);

        JLabel titulo =
                new JLabel("MI PERFIL");

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22));

        titulo.setBounds(
                350,
                20,
                200,
                30);

        add(titulo);

        //------------------------------------------------
        // DATOS
        //------------------------------------------------

        JLabel lblId =
                new JLabel(
                        "ID: "
                        + usuario.getId());

        lblId.setBounds(
                100,
                100,
                300,
                25);

        add(lblId);

        JLabel lblNombre =
                new JLabel(
                        "Nombre: "
                        + usuario.getNombre());

        lblNombre.setBounds(
                100,
                140,
                400,
                25);

        add(lblNombre);

        JLabel lblCorreo =
                new JLabel(
                        "Correo: "
                        + usuario.getCorreo());

        lblCorreo.setBounds(
                100,
                180,
                400,
                25);

        add(lblCorreo);

        JLabel lblUbicacion =
                new JLabel(
                        "Ubicación: "
                        + usuario.getUbicacion()
                        .getUbicacionAproximada());

        lblUbicacion.setBounds(
                100,
                220,
                400,
                25);

        add(lblUbicacion);

        //------------------------------------------------
        // ESTADISTICAS
        //------------------------------------------------

        JLabel lblPublicaciones =
                new JLabel(
                        "Publicaciones: "
                        + usuario.getPublicaciones()
                        .size());

        lblPublicaciones.setBounds(
                100,
                290,
                300,
                25);

        add(lblPublicaciones);

        JLabel lblTransacciones =
                new JLabel(
                        "Transacciones: "
                        + usuario.getTransacciones()
                        .size());

        lblTransacciones.setBounds(
                100,
                330,
                300,
                25);

        add(lblTransacciones);

        JLabel lblRepVendedor =
                new JLabel(
                        "Reputación vendedor: "
                        + String.format(
                                "%.2f",
                                usuario
                                .getPromedioReputacionVendedor()));

        lblRepVendedor.setBounds(
                100,
                370,
                350,
                25);

        add(lblRepVendedor);

        JLabel lblRepCliente =
                new JLabel(
                        "Reputación cliente: "
                        + String.format(
                                "%.2f",
                                usuario
                                .getPromedioReputacionCliente()));

        lblRepCliente.setBounds(
                100,
                410,
                350,
                25);

        add(lblRepCliente);

        //------------------------------------------------
        // BOTON VOLVER
        //------------------------------------------------

        JButton btnVolver =
                new JButton(
                        "Volver");

        btnVolver.setBounds(
                320,
                500,
                150,
                35);

        add(btnVolver);

        btnVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        ventana.setContentPane(

                                new Menu(
                                        ventana,
                                        usuario));

                        ventana.revalidate();
                        ventana.repaint();
                    }
                });
    }
}
