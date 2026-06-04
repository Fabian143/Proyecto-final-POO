package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kernel.UsuarioNormal;

public class Menu extends JPanel {

    private static final long serialVersionUID = 1L;

    public Menu(
            Principal ventana,
            UsuarioNormal usuario) {

        setLayout(null);

        JLabel lblBienvenido =
                new JLabel(
                        "Bienvenido "
                        + usuario.getNombre());

        lblBienvenido.setBounds(
                50,
                30,
                400,
                30);

        add(lblBienvenido);

        JButton btnPublicaciones =
                new JButton(
                        "Publicaciones");
        btnPublicaciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ventana.setContentPane(
                        new CrearPublicacion(
                                ventana,
                                usuario));

                ventana.revalidate();
                ventana.repaint();
        	}
        });

        btnPublicaciones.setBounds(
                100,
                100,
                250,
                40);

        add(btnPublicaciones);

        JButton btnOfertas =
                new JButton(
                        "Ofertas");

        btnOfertas.setBounds(
                100,
                170,
                250,
                40);

        add(btnOfertas);

        JButton btnMensajes =
                new JButton(
                        "Mensajes");

        btnMensajes.setBounds(
                100,
                240,
                250,
                40);

        add(btnMensajes);

        JButton btnPerfil =
                new JButton(
                        "Mi Perfil");

        btnPerfil.setBounds(
                100,
                310,
                250,
                40);

        add(btnPerfil);

        JButton btnCerrarSesion =
                new JButton(
                        "Cerrar Sesión");

        btnCerrarSesion.setBounds(
                100,
                450,
                250,
                40);

        add(btnCerrarSesion);

        btnCerrarSesion.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        ventana.setContentPane(
                                new Login(
                                        ventana));

                        ventana.revalidate();
                        ventana.repaint();
                    }
                });
    }
}
