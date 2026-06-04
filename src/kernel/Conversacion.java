package kernel;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioNormal remitente;
    private UsuarioNormal destinatario;

    private ArrayList<Mensaje> mensajes;

    public Conversacion(
            UsuarioNormal remitente,
            UsuarioNormal destinatario) {

        this.remitente = remitente;
        this.destinatario = destinatario;
        this.mensajes = new ArrayList<>();
    }

    public void agregarMensaje(Mensaje m) {
        mensajes.add(m);
    }

    public int cantidadMensajes() {
        return mensajes.size();
    }

    public UsuarioNormal getRemitente() {
        return remitente;
    }

    public void setRemitente(UsuarioNormal remitente) {
        this.remitente = remitente;
    }

    public UsuarioNormal getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(UsuarioNormal destinatario) {
        this.destinatario = destinatario;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}