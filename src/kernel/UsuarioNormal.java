package kernel;

import java.util.ArrayList;

public class UsuarioNormal extends Usuario {
    
    protected String ubicacion;
    protected ArrayList<Publicacion> publicaciones;
    protected ArrayList<Reseña> reseñasComoVendedor;
    protected ArrayList<Reseña> reseñasComoCliente;
    protected ArrayList<Transaccion> transacciones;

    public UsuarioNormal(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
        this.publicaciones = new ArrayList<>();
        this.reseñasComoVendedor = new ArrayList<>();
        this.reseñasComoCliente = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    // Getters
    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public ArrayList<Reseña> getReseñasComoVendedor() {
        return reseñasComoVendedor;
    }

    public ArrayList<Reseña> getReseñasComoCliente() {
        return reseñasComoCliente;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    // Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
