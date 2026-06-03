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

    // Método: Obtener promedio de reputación como vendedor
    public double getPromedioReputacionVendedor() {
        if (reseñasComoVendedor.isEmpty()) return 0;
        return reseñasComoVendedor.stream()
                .mapToDouble(Reseña::getCalificacion)
                .average()
                .orElse(0);
    }

    // Método: Obtener promedio de reputación como cliente
    public double getPromedioReputacionCliente() {
        if (reseñasComoCliente.isEmpty()) return 0;
        return reseñasComoCliente.stream()
                .mapToDouble(Reseña::getCalificacion)
                .average()
                .orElse(0);
    }

    // Método: Agregar reseña como vendedor
    public void agregarReseñaVendedor(Reseña reseña) {
        reseñasComoVendedor.add(reseña);
    }

    // Método: Agregar reseña como cliente
    public void agregarReseñaCliente(Reseña reseña) {
        reseñasComoCliente.add(reseña);
    }

    // Método: Agregar transacción
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    // Método: Agregar publicación
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }
}
