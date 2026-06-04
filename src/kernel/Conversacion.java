package kernel;

import java.io.Serializable;
import java.util.ArrayList;

public class Conversacion implements Serializable {

    private ArrayList<Mensaje> mensajes;

    public Conversacion() {
        mensajes = new ArrayList<>();
    }

    public void agregarMensaje(Mensaje m) {
        mensajes.add(m);
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }
}
