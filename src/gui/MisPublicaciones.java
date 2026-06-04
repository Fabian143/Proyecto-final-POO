package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestion.Sistema;
import kernel.Publicacion;
import kernel.UsuarioNormal;

public class MisPublicaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable tablaPublicaciones;

    public MisPublicaciones(
            Principal ventana,
            UsuarioNormal usuario) {

        setLayout(null);

        JScrollPane scrollPane =
                new JScrollPane();

        scrollPane.setBounds(
                50,
                50,
                850,
                350);

        add(scrollPane);

        tablaPublicaciones =
                new JTable();

        scrollPane.setViewportView(
                tablaPublicaciones);

        cargarTabla(usuario);

        JButton btnCrear =
                new JButton("Crear");

        btnCrear.setBounds(
                50,
                450,
                120,
                35);

        add(btnCrear);

        JButton btnVer =
                new JButton("Ver");

        btnVer.setBounds(
                200,
                450,
                120,
                35);

        add(btnVer);

        JButton btnEliminar =
                new JButton("Eliminar");

        btnEliminar.setBounds(
                350,
                450,
                120,
                35);

        add(btnEliminar);

        JButton btnVolver =
                new JButton("Volver");

        btnVolver.setBounds(
                641,
                450,
                120,
                35);

        add(btnVolver);
        
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int fila =
                        tablaPublicaciones
                        .getSelectedRow();

                if(fila == -1) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione una publicación");

                    return;
                }

                Publicacion publicacion =
                        Sistema.usuarioActual
                        .getPublicaciones()
                        .get(fila);

                ventana.setContentPane(
                        new EditarPublicacion(
                                ventana,
                                publicacion));

                ventana.revalidate();
                ventana.repaint();

        	}
        });
        btnEditar.setBounds(497, 450, 120, 35);
        add(btnEditar);

        //----------------------------------
        // CREAR
        //----------------------------------

        btnCrear.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        ventana.setContentPane(
                                new CrearPublicacion(
                                        ventana,
                                        usuario));

                        ventana.revalidate();
                        ventana.repaint();
                    }
                });

        //----------------------------------
        // VOLVER
        //----------------------------------

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

        //----------------------------------
        // VER
        //----------------------------------

        btnVer.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        int fila =
                                tablaPublicaciones
                                .getSelectedRow();

                        if(fila == -1) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Seleccione una publicación");

                            return;
                        }

                        Publicacion p =
                                usuario.getPublicaciones()
                                .get(fila);

                        JOptionPane.showMessageDialog(
                                null,
                                "ID: " +
                                p.getId() +

                                "\nDescripción: " +
                                p.getObjeto()
                                .getDescripcion()

                                +

                                "\nCondiciones: " +
                                p.getObjeto()
                                .getCondiciones()

                                +

                                "\nCategoría: " +
                                p.getObjeto()
                                .getCategoria()

                                +

                                "\nEstado: " +
                                p.getEstado());
                    }
                });

        //----------------------------------
        // ELIMINAR
        //----------------------------------

        btnEliminar.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e) {

                        int fila =
                                tablaPublicaciones
                                .getSelectedRow();

                        if(fila == -1) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Seleccione una publicación");

                            return;
                        }

                        usuario.getPublicaciones()
                               .remove(fila);

                        Sistema.gestionUsuarios
                               .guardarTodo();

                        cargarTabla(usuario);

                        JOptionPane.showMessageDialog(
                                null,
                                "Publicación eliminada");
                    }
                });
    }

    //----------------------------------
    // CARGAR TABLA
    //----------------------------------

    private void cargarTabla(
            UsuarioNormal usuario) {

        DefaultTableModel modelo =
                new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Categoría");
        modelo.addColumn("Estado");

        for(Publicacion p :
                usuario.getPublicaciones()) {

            modelo.addRow(
                    new Object[] {

                            p.getId(),

                            p.getObjeto()
                            .getDescripcion(),

                            p.getObjeto()
                            .getCategoria(),

                            p.getEstado()
                    });
        }

        tablaPublicaciones
                .setModel(modelo);
    }
}
