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

        JButton btnMisPublicaciones =
                new JButton(
                        "Mis publicaciones");
        btnMisPublicaciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ventana.setContentPane(
                        new MisPublicaciones(
                                ventana,
                                usuario));

                ventana.revalidate();
                ventana.repaint();

        	}
        });

        btnMisPublicaciones.setBounds(
                100,
                100,
                250,
                40);

        add(btnMisPublicaciones);

        JButton btnOfertas =
                new JButton(
                        "Ofertas");
        btnOfertas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ventana.setContentPane(
                        new OfertasRecibidas(
                                ventana));

                ventana.revalidate();
                ventana.repaint();
        	}
        });

        btnOfertas.setBounds(
                100,
                150,
                250,
                40);

        add(btnOfertas);

        JButton btnMensajes =
                new JButton(
                        "Mensajes");
        btnMensajes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ventana.setContentPane(new MisMensajes(ventana));
                ventana.revalidate();
                ventana.repaint();
        	}
        });

        btnMensajes.setBounds(
                375,
                200,
                250,
                40);

        add(btnMensajes);

        JButton btnPerfil =
                new JButton(
                        "Mi Perfil");
        btnPerfil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ventana.setContentPane(

                        new MiPerfil(
                                ventana,
                                usuario));

                ventana.revalidate();
                ventana.repaint();
        	}
        });

        btnPerfil.setBounds(
                100,
                250,
                250,
                40);

        add(btnPerfil);

        JButton btnCerrarSesion =
                new JButton(
                        "Cerrar Sesión");

        btnCerrarSesion.setBounds(
                375,
                250,
                250,
                40);

        add(btnCerrarSesion);
        
        JButton btnExplorar = new JButton("Explorar publicaciones");
        btnExplorar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ventana.setContentPane(
                        new ExplorarPublicaciones(
                                ventana));

                ventana.revalidate();
                ventana.repaint();
        	}
        });
        btnExplorar.setBounds(375, 100, 250, 40);
        add(btnExplorar);
        
        JButton btnSubastas = new JButton("Subastas");
        btnSubastas.setBounds(375, 150, 250, 40);
        btnSubastas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new ExplorarSubastas(ventana));
                ventana.revalidate();
                ventana.repaint();
            }
        });
        add(btnSubastas);
        
        JButton btnCrearSubasta = new JButton("Crear Subasta");
        btnCrearSubasta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ventana.setContentPane(new CrearSubasta(ventana, usuario));
                ventana.revalidate();
                ventana.repaint();
        	}
        });
        btnCrearSubasta.setBounds(100, 200, 250, 40);
        add(btnCrearSubasta);

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
