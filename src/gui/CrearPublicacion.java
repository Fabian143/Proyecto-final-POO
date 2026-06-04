package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestion.Sistema;
import kernel.Categoria;
import kernel.Objeto;
import kernel.TiempoGeolocalizado;
import kernel.TruequeDirecto;
import kernel.UsuarioNormal;

public class CrearPublicacion extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtDescripcion;
    private JTextField txtCondiciones;

    private JComboBox<Categoria> comboCategoria;

    public CrearPublicacion(
            Principal ventana,
            UsuarioNormal usuario) {

        setLayout(null);

        JLabel lblTitulo =
                new JLabel("Nueva Publicación");

        lblTitulo.setBounds(
                350,
                40,
                200,
                30);

        add(lblTitulo);

        JLabel lblDescripcion =
                new JLabel("Descripción");

        lblDescripcion.setBounds(
                150,
                120,
                100,
                25);

        add(lblDescripcion);

        txtDescripcion =
                new JTextField();

        txtDescripcion.setBounds(
                280,
                120,
                350,
                25);

        add(txtDescripcion);

        JLabel lblCondiciones =
                new JLabel("Condiciones");

        lblCondiciones.setBounds(
                150,
                180,
                100,
                25);

        add(lblCondiciones);

        txtCondiciones =
                new JTextField();

        txtCondiciones.setBounds(
                280,
                180,
                350,
                25);

        add(txtCondiciones);

        JLabel lblCategoria =
                new JLabel("Categoría");

        lblCategoria.setBounds(
                150,
                240,
                100,
                25);

        add(lblCategoria);

        comboCategoria =
                new JComboBox<Categoria>(
                        Categoria.values());

        comboCategoria.setBounds(
                280,
                240,
                200,
                25);

        add(comboCategoria);

        JButton btnGuardar =
                new JButton("Guardar");

        btnGuardar.setBounds(
                250,
                350,
                150,
                35);

        add(btnGuardar);

        JButton btnVolver =
                new JButton("Volver");

        btnVolver.setBounds(
                450,
                350,
                150,
                35);

        add(btnVolver);

        btnGuardar.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        try {

                            String descripcion =
                                    txtDescripcion.getText();

                            String condiciones =
                                    txtCondiciones.getText();

                            Categoria categoria =
                                    (Categoria)
                                    comboCategoria.getSelectedItem();

                            if(descripcion.isEmpty()
                                    || condiciones.isEmpty()) {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Complete todos los campos");

                                return;
                            }

                            Objeto objeto =
                                    new Objeto(
                                            descripcion,
                                            condiciones,
                                            categoria);

                            TruequeDirecto publicacion =
                                    new TruequeDirecto(
                                            usuario,
                                            objeto,
                                            new TiempoGeolocalizado());

                            usuario.agregarPublicacion(
                                    publicacion);

                            Sistema.gestionUsuarios
                                    .guardarTodo();

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Publicación creada correctamente");

                            ventana.setContentPane(
                                    new Menu(
                                            ventana,
                                            usuario));

                            ventana.revalidate();
                            ventana.repaint();

                        } catch(Exception ex) {

                            ex.printStackTrace();

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Error al crear publicación");
                        }
                    }
                });

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