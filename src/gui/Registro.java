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

public class Registro extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtNombre;
    private JTextField txtCorreo;
    private JTextField txtCiudad;

    private JPasswordField txtPass;
    private JPasswordField txtConfirmar;

    public Registro(Principal ventana) {

        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(350, 100, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(350, 130, 250, 25);
        add(txtNombre);

        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setBounds(350, 170, 100, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(350, 200, 250, 25);
        add(txtCorreo);

        JLabel lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(350, 240, 100, 25);
        add(lblCiudad);

        txtCiudad = new JTextField();
        txtCiudad.setBounds(350, 270, 250, 25);
        add(txtCiudad);

        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setBounds(350, 310, 100, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(350, 340, 250, 25);
        add(txtPass);

        JLabel lblConfirmar = new JLabel("Confirmar");
        lblConfirmar.setBounds(350, 380, 100, 25);
        add(lblConfirmar);

        txtConfirmar = new JPasswordField();
        txtConfirmar.setBounds(350, 410, 250, 25);
        add(txtConfirmar);

        JButton btnRegistrar =
                new JButton("Registrar");

        btnRegistrar.setBounds(
                350, 470, 250, 30);

        add(btnRegistrar);

        JButton btnVolver =
                new JButton("Volver");

        btnVolver.setBounds(
                350, 520, 250, 30);

        add(btnVolver);

        btnRegistrar.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        try {

                            String nombre =
                                    txtNombre.getText();

                            String correo =
                                    txtCorreo.getText();

                            String ciudad =
                                    txtCiudad.getText();

                            String contraseña =
                                    String.valueOf(
                                            txtPass.getPassword());

                            String confirmar =
                                    String.valueOf(
                                            txtConfirmar.getPassword());

                            if(nombre.isEmpty()
                                    || correo.isEmpty()
                                    || ciudad.isEmpty()
                                    || contraseña.isEmpty()) {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Complete todos los campos");

                                return;
                            }

                            if(!contraseña.equals(confirmar)) {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Las contraseñas no coinciden");

                                return;
                            }

                            if(Sistema.gestionUsuarios
                                    .existeCorreo(correo)) {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "El correo ya existe");

                                return;
                            }

                            UsuarioNormal usuario =
                                    new UsuarioNormal(
                                            nombre,
                                            contraseña,
                                            correo,
                                            ciudad);

                            Sistema.gestionUsuarios
                                    .registrar(usuario);

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Usuario registrado");

                            ventana.setContentPane(
                                    new Login(ventana));

                            ventana.revalidate();
                            ventana.repaint();

                        } catch(Exception ex) {
                        	

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Error al registrar");
                        }
                    }
                });

        btnVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        ventana.setContentPane(
                                new Login(ventana));

                        ventana.revalidate();
                        ventana.repaint();
                    }
                });
    }
}
