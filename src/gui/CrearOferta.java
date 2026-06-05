package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gestion.Sistema;
import kernel.EstadoOferta;
import kernel.Oferta;
import kernel.Publicacion;
import kernel.TiempoGeolocalizado;
import kernel.TruequeDirecto;

public class CrearOferta extends JPanel {

    private static final long serialVersionUID = 1L;

    private JComboBox<Publicacion> comboMisObjetos;

    public CrearOferta(
            Principal ventana,
            TruequeDirecto publicacionDestino) {

        setLayout(null);

        JLabel lblTitulo =
                new JLabel("Enviar Oferta");

        lblTitulo.setBounds(
                350,
                40,
                200,
                30);

        add(lblTitulo);

        JLabel lblObjetoSolicitado =
                new JLabel(
                        "Objeto solicitado:");

        lblObjetoSolicitado.setBounds(
                100,
                120,
                150,
                25);

        add(lblObjetoSolicitado);

        JLabel lblDescripcion =
                new JLabel(
                        publicacionDestino
                        .getObjeto()
                        .getDescripcion());

        lblDescripcion.setBounds(
                250,
                120,
                300,
                25);

        add(lblDescripcion);

        JLabel lblMisObjetos =
                new JLabel(
                        "Seleccione objeto a ofrecer:");

        lblMisObjetos.setBounds(
                100,
                200,
                200,
                25);

        add(lblMisObjetos);

        comboMisObjetos =
                new JComboBox<>();

        comboMisObjetos.setBounds(
                300,
                200,
                300,
                25);

        add(comboMisObjetos);

        //---------------------------------
        // CARGAR PUBLICACIONES DEL USUARIO
        //---------------------------------

        for(Publicacion p :

                Sistema.usuarioActual
                .getPublicaciones()) {

            comboMisObjetos.addItem(p);
        }

        //---------------------------------
        // BOTON ENVIAR
        //---------------------------------

        JButton btnEnviar =
                new JButton(
                        "Enviar Oferta");

        btnEnviar.setBounds(
                250,
                320,
                150,
                35);

        add(btnEnviar);

        //---------------------------------
        // BOTON VOLVER
        //---------------------------------

        JButton btnVolver =
                new JButton(
                        "Volver");

        btnVolver.setBounds(
                450,
                320,
                150,
                35);

        add(btnVolver);

        //---------------------------------
        // EVENTO ENVIAR
        //---------------------------------

        btnEnviar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                try {

                    Publicacion publicacionOfrecida =
                            (Publicacion)
                            comboMisObjetos
                            .getSelectedItem();

                    if(publicacionOfrecida
                            == null) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Seleccione un objeto");

                        return;
                    }

                    Oferta oferta =
                            new Oferta(

                                    new TiempoGeolocalizado(),

                                    Sistema.usuarioActual,

                                    publicacionOfrecida
                                    .getObjeto(),

                                    publicacionDestino
                                    .getObjeto(),

                                    EstadoOferta.Pendiente
                            );

                    publicacionDestino
                    .agregarOferta(oferta);

                    Sistema.gestionUsuarios
                    .guardarTodo();

                    JOptionPane.showMessageDialog(
                            null,
                            "Oferta enviada correctamente");

                    ventana.setContentPane(
                            new ExplorarPublicaciones(
                                    ventana));

                    ventana.revalidate();
                    ventana.repaint();

                } catch(Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(
                            null,
                            "Error al enviar oferta");
                }
            }
        });

        //---------------------------------
        // EVENTO VOLVER
        //---------------------------------

        btnVolver.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                ventana.setContentPane(
                        new ExplorarPublicaciones(
                                ventana));

                ventana.revalidate();
                ventana.repaint();
            }
        });
    }
}