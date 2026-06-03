package kernel;

import interfaces.Geolocalizable;
import enums.EstadoPublicacion;

import java.io.Serializable;

public abstract class Publicacion
        implements Geolocalizable, Serializable {

    protected int id;
    protected String descripcion;
    protected String categoria;
    protected String ubicacion;
    protected EstadoPublicacion estado;

    public Publicacion(int id,
                       String descripcion,
                       String categoria,
                       String ubicacion) {

        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.estado = EstadoPublicacion.PUBLICADO;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoPublicacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPublicacion estado) {
        this.estado = estado;
    }

    @Override
    public String obtenerUbicacion() {
        return ubicacion;
    }

    public abstract void mostrarPublicacion();
}
