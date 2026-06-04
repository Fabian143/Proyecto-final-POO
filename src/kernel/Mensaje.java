package kernel;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensaje implements Serializable {

    private Usuario emisor;
    private String texto;

    private LocalDateTime fecha;

    public Mensaje(
            Usuario emisor,
            String texto) {

        this.emisor = emisor;
        this.texto = texto;
        this.fecha = LocalDateTime.now();
    }
}
