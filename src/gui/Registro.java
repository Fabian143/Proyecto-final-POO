package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import logica.Usuario;
import logica.Sistema;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public Registro(Principal ventana) {
		setBackground(new Color(135, 174, 182));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 226, 221));
		panel.setBounds(27, 58, 396, 395);
		add(panel);
		
		JLabel label = new JLabel("");
		
		JLabel nombreregistro = new JLabel("Nombre");
		nombreregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel apellidoregistro = new JLabel("Apellido ");
		apellidoregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel usuarioregistro = new JLabel("Usuario");
		usuarioregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel correoregistro = new JLabel("Correo");
		correoregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel contraseñaregistro = new JLabel("Contraseña");
		contraseñaregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		JLabel confircontraregistro = new JLabel("Confirmar contraseña");
		confircontraregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton registarregistro = new JButton("Registrarse");
		registarregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre =
				        textField.getText();

				String apellido =
				        textField_1.getText();

				String usuario =
				        textField_2.getText();

				String correo =
				        textField_3.getText();

				String contraseña =
				        textField_4.getText();

				String confirmar =
				        textField_5.getText();
				
				if(!contraseña.equals(confirmar)) {

				    JOptionPane.showMessageDialog(
				            null,
				            "Las contraseñas no coinciden");

				    return;
				}
				Usuario nuevo =
				        new Usuario(
				                nombre,
				                apellido,
				                usuario,
				                correo,
				                contraseña);

				Sistema.gestion.registrar(
				        nuevo);
				JOptionPane.showMessageDialog(
				        null,
				        "Usuario registrado");
				ventana.setContentPane(
				        new Login(ventana));

				ventana.revalidate();
			}
		});
		registarregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		registarregistro.setBackground(new Color(92, 250, 217));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(156)
					.addComponent(registarregistro)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
					.addGap(223))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(confircontraregistro, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(16)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(apellidoregistro, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(nombreregistro, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(usuarioregistro, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(correoregistro, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(contraseñaregistro, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreregistro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(apellidoregistro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(usuarioregistro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(correoregistro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(contraseñaregistro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(confircontraregistro, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(46)
							.addComponent(registarregistro, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel tituloregistro = new JLabel("Registro");
		tituloregistro.setHorizontalAlignment(SwingConstants.CENTER);
		tituloregistro.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		tituloregistro.setBounds(165, 10, 98, 30);
		add(tituloregistro);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnSalir.setBackground(new Color(92, 250, 217));
		btnSalir.setBounds(183, 463, 84, 20);
		add(btnSalir);

	}

}
