package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import java.awt.Canvas;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu(Principal ventana) {
		setBackground(new Color(135, 174, 182));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 226, 221));
		panel.setBounds(10, 10, 386, 74);
		add(panel);
		panel.setLayout(null);
		
		JLabel tituloproyecto = new JLabel("Trueques ");
		tituloproyecto.setBounds(130, 10, 125, 39);
		panel.add(tituloproyecto);
		tituloproyecto.setHorizontalAlignment(SwingConstants.CENTER);
		tituloproyecto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 103, 386, 53);
		add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton subastas = new JButton("Subastas");
		subastas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		subastas.setBackground(new Color(128, 255, 128));
		panel_1.add(subastas, "name_10404965059100");
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 166, 386, 53);
		add(panel_1_1);
		panel_1_1.setLayout(new CardLayout(0, 0));
		
		JButton publicaciones = new JButton("Publicaciones");
		publicaciones.setBackground(new Color(255, 255, 187));
		publicaciones.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		panel_1_1.add(publicaciones, "name_10408125505900");
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(10, 229, 386, 53);
		add(panel_1_2);
		panel_1_2.setLayout(new CardLayout(0, 0));
		
		JButton mensajes = new JButton("Mensajes");
		mensajes.setBackground(new Color(193, 240, 255));
		panel_1_2.add(mensajes, "name_10410829562800");
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(10, 292, 386, 53);
		add(panel_1_3);
		panel_1_3.setLayout(new CardLayout(0, 0));
		
		JButton reputacion = new JButton("Reputacion");
		reputacion.setBackground(new Color(255, 155, 255));
		panel_1_3.add(reputacion, "name_10414603498500");
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setBounds(10, 355, 386, 53);
		add(panel_1_3_1);
		panel_1_3_1.setLayout(new CardLayout(0, 0));
		
		JButton cerrarsesion = new JButton("Cerrar sesion");
		cerrarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
					    ventana.setContentPane(
					            new Login(ventana));

					    ventana.revalidate();
					};
		});
		cerrarsesion.setBackground(new Color(255, 128, 128));
		panel_1_3_1.add(cerrarsesion, "name_10416523355100");

	}
}
