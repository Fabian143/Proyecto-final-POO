package ggui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gestion.Sistema;
import kernel.Conversacion;
import kernel.Mensaje;
import kernel.TiempoGeolocalizado;
import kernel.UsuarioNormal;

public class VerConversacion extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JTextArea areaMensajes;
    private JTextField txtMensaje;
    private Conversacion conversacion;

    public VerConversacion(Principal ventana, Conversacion conversacion) {
        this.conversacion = conversacion;
        setLayout(null);

        // Identificar contacto
        UsuarioNormal contacto = (conversacion.getRemitente() == Sistema.usuarioActual) 
            ? conversacion.getDestinatario() : conversacion.getRemitente();

        JLabel lblTitulo = new JLabel("Conversación con: " + contacto.getNombre());
        lblTitulo.setBounds(50, 20, 400, 30);
        add(lblTitulo);

        // ÁREA DE MENSAJES
        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        areaMensajes.setLineWrap(true);
        areaMensajes.setWrapStyleWord(true);
        
        JScrollPane scrollMensajes = new JScrollPane(areaMensajes);
        scrollMensajes.setBounds(50, 70, 850, 400);
        add(scrollMensajes);

        // CAMPO NUEVO MENSAJE
        txtMensaje = new JTextField();
        txtMensaje.setBounds(50, 490, 650, 60);
        add(txtMensaje);

        // BOTÓN ENVIAR
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(720, 490, 100, 60);
        add(btnEnviar);

        // BOTÓN VOLVER
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(830, 490, 80, 60);
        add(btnVolver);

        // Cargar mensajes existentes
        cargarMensajes();

        // EVENTO ENVIAR
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String contenido = txtMensaje.getText().trim();
                if (contenido.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Escriba un mensaje");
                    return;
                }
                
                Mensaje nuevoMensaje = new Mensaje(
                    contenido,
                    new TiempoGeolocalizado(),
                    Sistema.usuarioActual
                );
                
                conversacion.agregarMensaje(nuevoMensaje);
                Sistema.gestionUsuarios.guardarTodo();
                
                txtMensaje.setText("");
                cargarMensajes();
            }
        });

        // EVENTO VOLVER
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new MisMensajes(ventana));
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }

    private void cargarMensajes() {
        areaMensajes.setText("");
        for (Mensaje m : conversacion.getMensajes()) {
            String remitente = (m.getRemitente() == Sistema.usuarioActual) 
                ? "Yo" : m.getRemitente().getNombre();
            
            areaMensajes.append("[" + m.getFecha().getFechaFormato() + "] ");
            areaMensajes.append(remitente + ": ");
            areaMensajes.append(m.getContenido() + "\n\n");
        }
        
        // Auto-scroll al final
        areaMensajes.setCaretPosition(areaMensajes.getDocument().getLength());
    }
}