package kernel;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaccion implements Serializable {

    private Usuario comprador;
    private Usuario vendedor;

    private LocalDate fecha;

    public Transaccion(
            Usuario comprador,
            Usuario vendedor) {

        this.comprador = comprador;
        this.vendedor = vendedor;
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
