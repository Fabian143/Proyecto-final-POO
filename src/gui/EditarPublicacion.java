package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestion.Sistema;
import kernel.Categoria;
import kernel.Publicacion;

public class EditarPublicacion extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtDescripcion;
    private JTextField txtCondiciones;

    private JComboBox<Categoria> comboCategoria;

    public EditarPublicacion(
            Principal ventana,
            Publicacion publicacion) {

        setLayout(null);

        JLabel lblTitulo =
                new JLabel(
                        "Editar Publicación");

        lblTitulo.setBounds(
                350,
                40,
                200,
                30);

        add(lblTitulo);

        //-------------------------
        // DESCRIPCION
        //-------------------------

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

        //-------------------------
        // CONDICIONES
        //-------------------------

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

        //-------------------------
        // CATEGORIA
        //-------------------------

        JLabel lblCategoria =
                new JLabel("Categoría");

        lblCategoria.setBounds(
                150,
                240,
                100,
                25);

        add(lblCategoria);

        comboCategoria =
                new JComboBox<>(
                        Categoria.values());

        comboCategoria.setBounds(
                280,
                240,
                200,
                25);

        add(comboCategoria);

        //-------------------------
        // CARGAR DATOS
        //-------------------------

        txtDescripcion.setText(
                publicacion
                .getObjeto()
                .getDescripcion());

        txtCondiciones.setText(
                publicacion
                .getObjeto()
                .getCondiciones());

        comboCategoria.setSelectedItem(
                publicacion
                .getObjeto()
                .getCategoria());

        //-------------------------
        // BOTON GUARDAR
        //-------------------------

        JButton btnGuardar =
                new JButton(
                        "Guardar Cambios");

        btnGuardar.setBounds(
                250,
                350,
                170,
                35);

        add(btnGuardar);

        //-------------------------
        // BOTON VOLVER
        //-------------------------

        JButton btnVolver =
                new JButton(
                        "Cancelar");

        btnVolver.setBounds(
                450,
                350,
                150,
                35);

        add(btnVolver);

        //-------------------------
        // GUARDAR
        //-------------------------

        btnGuardar.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                try {

                  	String descripcion =
                            txtDescripcion.getText();

                    String condiciones =
                            txtCondiciones.getText();

                    if(descripcion.isBlank()
                            || condiciones.isBlank()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Complete todos los campos");

                        return;
                    }
                    

                    publicacion
                    .getObjeto()
                    .setDescripcion(
                            txtDescripcion
                            .getText());

                    publicacion
                    .getObjeto()
                    .setCondiciones(
                            txtCondiciones
                            .getText());

                    publicacion
                    .getObjeto()
                    .setCategoria(
                            (Categoria)
                            comboCategoria
                            .getSelectedItem());

                    Sistema.gestionUsuarios
                            .guardarTodo();

                    JOptionPane.showMessageDialog(
                            null,
                            "Publicación actualizada");

                    ventana.setContentPane(
                            new MisPublicaciones(
                                    ventana,
                                    Sistema.usuarioActual));

                    ventana.revalidate();
                    ventana.repaint();

                } catch(Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Error al actualizar");
                }
            }
        });

        //-------------------------
        // CANCELAR
        //-------------------------

        btnVolver.addActionListener(
        new ActionListener() {

            public void actionPerformed(
                    ActionEvent e) {

                ventana.setContentPane(
                        new MisPublicaciones(
                                ventana,
                                Sistema.usuarioActual));

                ventana.revalidate();
                ventana.repaint();
            }
        });
    }
}
