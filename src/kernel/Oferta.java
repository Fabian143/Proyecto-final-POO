package kernel;

import enums.EstadoOferta;

import java.io.Serializable;
import java.time.LocalDate;

public class Oferta implements Serializable {

    protected Usuario usuario;
    protected LocalDate fecha;
    protected EstadoOferta estado;

    public Oferta(Usuario usuario) {

        this.usuario = usuario;
        this.fecha = LocalDate.now();
        this.estado = EstadoOferta.PENDIENTE;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }
}
