package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import gestion.Sistema;
import kernel.Conversacion;
import kernel.UsuarioNormal;

public class MisMensajes extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tablaConversaciones;

    public MisMensajes(Principal ventana) {
        setLayout(null);

        JLabel lblTitulo = new JLabel("Mis Conversaciones");
        lblTitulo.setBounds(400, 20, 200, 30);
        add(lblTitulo);

        // TABLA DE CONVERSACIONES
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 70, 880, 400);
        add(scrollPane);

        tablaConversaciones = new JTable();
        scrollPane.setViewportView(tablaConversaciones);
        cargarTabla();

        // BOTÓN VER MENSAJES
        JButton btnVer = new JButton("Ver Conversación");
        btnVer.setBounds(300, 500, 180, 35);
        add(btnVer);

        // BOTÓN NUEVO MENSAJE
        JButton btnNuevo = new JButton("Nuevo Mensaje");
        btnNuevo.setBounds(520, 500, 180, 35);
        add(btnNuevo);

        // BOTÓN VOLVER
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(740, 500, 120, 35);
        add(btnVolver);

        // EVENTOS
        btnVer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tablaConversaciones.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione una conversación");
                    return;
                }
                
                Conversacion conversacion = obtenerConversacion(fila);
                if (conversacion != null) {
                    ventana.setContentPane(new VerConversacion(ventana, conversacion));
                    ventana.revalidate();
                    ventana.repaint();
                }
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar diálogo para seleccionar usuario
                String[] nombresUsuarios = obtenerNombresOtrosUsuarios();
                
                if (nombresUsuarios.length == 0) {
                    JOptionPane.showMessageDialog(null, "No hay otros usuarios para contactar");
                    return;
                }
                
                String seleccionado = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione un usuario:",
                    "Nuevo Mensaje",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombresUsuarios,
                    nombresUsuarios[0]
                );
                
                if (seleccionado != null) {
                    UsuarioNormal otro = buscarUsuarioPorNombre(seleccionado);
                    if (otro != null) {
                        Conversacion conversacion = Sistema.usuarioActual.obtenerOConversacionCon(otro);
                        Sistema.gestionUsuarios.guardarTodo();
                        ventana.setContentPane(new VerConversacion(ventana, conversacion));
                        ventana.revalidate();
                        ventana.repaint();
                    }
                }
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new Menu(ventana, Sistema.usuarioActual));
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }

    private void cargarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Contacto");
        modelo.addColumn("Último mensaje");
        modelo.addColumn("Cantidad mensajes");

        for (Conversacion c : Sistema.usuarioActual.getConversaciones()) {
            UsuarioNormal contacto = (c.getRemitente() == Sistema.usuarioActual) 
                ? c.getDestinatario() : c.getRemitente();
            
            String ultimoMensaje = "";
            if (c.cantidadMensajes() > 0) {
                ultimoMensaje = c.getMensajes().get(c.cantidadMensajes() - 1).getContenido();
                if (ultimoMensaje.length() > 50) {
                    ultimoMensaje = ultimoMensaje.substring(0, 47) + "...";
                }
            } else {
                ultimoMensaje = "Sin mensajes";
            }
            
            modelo.addRow(new Object[]{
                contacto.getNombre(),
                ultimoMensaje,
                c.cantidadMensajes()
            });
        }
        
        tablaConversaciones.setModel(modelo);
    }

    private Conversacion obtenerConversacion(int fila) {
        int contador = 0;
        for (Conversacion c : Sistema.usuarioActual.getConversaciones()) {
            if (contador == fila) return c;
            contador++;
        }
        return null;
    }

    private String[] obtenerNombresOtrosUsuarios() {
        ArrayList<String> nombres = new ArrayList<>();
        for (UsuarioNormal u : Sistema.gestionUsuarios.getUsuarios()) {
            if (u != Sistema.usuarioActual) {
                nombres.add(u.getNombre());
            }
        }
        return nombres.toArray(new String[0]);
    }

    private UsuarioNormal buscarUsuarioPorNombre(String nombre) {
        for (UsuarioNormal u : Sistema.gestionUsuarios.getUsuarios()) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }
}
