package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import logica.Sistema;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField usuariologin;
	private JPasswordField contraseñalogin;

	/**
	 * Create the panel.
	 */
	public Login(Principal ventana) {
		setBackground(new Color(135, 174, 182));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 67, 374, 135);
		panel.setBackground(new Color(204, 226, 221));
		add(panel);
		panel.setLayout(null);
		
		usuariologin = new JTextField();
		usuariologin.setBounds(124, 27, 126, 19);
		panel.add(usuariologin);
		usuariologin.setColumns(10);
		
		JLabel usu = new JLabel("Usuario");
		usu.setBounds(63, 20, 62, 27);
		panel.add(usu);
		usu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel contra = new JLabel("Contraseña");
		contra.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		contra.setBounds(39, 57, 86, 27);
		panel.add(contra);
		
		JButton iniciosesionlogin = new JButton("Iniciar sesion");
		iniciosesionlogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		iniciosesionlogin.setBackground(new Color(92, 250, 217));
		iniciosesionlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario =
				        usuariologin.getText();

				String contraseña =
				        String.valueOf(
				        contraseñalogin.getPassword());

				if(Sistema.gestion.iniciarSesion(
				        usuario,
				        contraseña)) {

				    JOptionPane.showMessageDialog(
				            null,
				            "Bienvenido");

				    ventana.setContentPane(
				            new Menu(ventana));

				    ventana.revalidate();

				} else {

				    JOptionPane.showMessageDialog(
				            null,
				            "Usuario incorrecto");
				}
			}
		});
		iniciosesionlogin.setBounds(132, 106, 110, 19);
		panel.add(iniciosesionlogin);
		
		contraseñalogin = new JPasswordField();
		contraseñalogin.setBounds(124, 64, 126, 18);
		panel.add(contraseñalogin);
		
		JLabel tituloproyecto = new JLabel("Trueques ");
		tituloproyecto.setBounds(176, 10, 98, 30);
		add(tituloproyecto);
		tituloproyecto.setHorizontalAlignment(SwingConstants.CENTER);
		tituloproyecto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		
		JButton registrologin = new JButton("Registrarse");
		registrologin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		registrologin.setBackground(new Color(92, 250, 217));
		registrologin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					    ventana.setContentPane(
					            new Registro(ventana));

					    ventana.revalidate();
					};
		});
		registrologin.setBounds(88, 218, 91, 30);
		add(registrologin);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(92, 250, 217));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					    System.exit(0);
					};
		});
		btnSalir.setBounds(279, 218, 91, 30);
		add(btnSalir);

	}
}
