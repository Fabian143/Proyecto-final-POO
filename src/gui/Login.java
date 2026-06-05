package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gestion.Sistema;
import kernel.UsuarioNormal;

public class Login extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCorreo;
    private JPasswordField txtContraseña;

    public Login(Principal ventana) {

        setLayout(null);

        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(350, 180, 100, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(350, 210, 250, 25);
        add(txtCorreo);

        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setBounds(350, 260, 100, 25);
        add(lblPass);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(350, 290, 250, 25);
        add(txtContraseña);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(350, 350, 250, 30);
        add(btnLogin);

        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(350, 400, 250, 30);
        add(btnRegistro);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(350, 450, 250, 30);
        add(btnSalir);

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String correo =
                        txtCorreo.getText();

                String contraseña =
                        String.valueOf(
                                txtContraseña.getPassword());

                UsuarioNormal usuario =
                        Sistema.gestionUsuarios
                                .login(
                                        correo,
                                        contraseña);

                if (usuario != null) {
                	
                	Sistema.usuarioActual =
                            usuario;

                    JOptionPane.showMessageDialog(
                            null,
                            "Bienvenido " +
                                    usuario.getNombre());

                    ventana.setContentPane(
                            new Menu(
                                    ventana,
                                    usuario));

                    ventana.revalidate();
                    ventana.repaint();

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Correo o contraseña incorrectos");
                }
            }
        });

        btnRegistro.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                ventana.setContentPane(
                        new Registro(ventana));

                ventana.revalidate();
                ventana.repaint();
            }
        });

        btnSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
    }
}
