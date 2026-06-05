package kernel;

import java.util.ArrayList;

public class UsuarioNormal extends Usuario {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected TiempoGeolocalizado ubicacion;
    protected ArrayList<Publicacion> publicaciones;
    protected ArrayList<Reseña> reseñasComoVendedor;
    protected ArrayList<Reseña> reseñasComoCliente;
    protected ArrayList<Transaccion> transacciones;
    protected ArrayList<Conversacion> conversaciones;

    public UsuarioNormal(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
        this.ubicacion = new TiempoGeolocalizado();
        this.publicaciones = new ArrayList<>();
        this.reseñasComoVendedor = new ArrayList<>();
        this.reseñasComoCliente = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.conversaciones = new ArrayList<>();
    }

    public UsuarioNormal(String nombre, String contraseña, String correo, String ciudadUbicacion) {
        super(nombre, contraseña, correo);
        this.ubicacion = new TiempoGeolocalizado(ciudadUbicacion);
        this.publicaciones = new ArrayList<>();
        this.reseñasComoVendedor = new ArrayList<>();
        this.reseñasComoCliente = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.conversaciones = new ArrayList<>();
    }

    public UsuarioNormal(String nombre, String contraseña, String correo, String ciudadUbicacion, double latitud, double longitud) {
        super(nombre, contraseña, correo);
        this.ubicacion = new TiempoGeolocalizado(ciudadUbicacion, latitud, longitud);
        this.publicaciones = new ArrayList<>();
        this.reseñasComoVendedor = new ArrayList<>();
        this.reseñasComoCliente = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.conversaciones = new ArrayList<>();
    }

    // Getters
    public TiempoGeolocalizado getUbicacion() {
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

    public ArrayList<Conversacion> getConversaciones() {
        return conversaciones;
    } 

    // Setters
    public void setUbicacion(TiempoGeolocalizado ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setUbicacion(String ciudadUbicacion) {
        this.ubicacion = new TiempoGeolocalizado(ciudadUbicacion);
    }

    public void setUbicacion(String ciudadUbicacion, double latitud, double longitud) {
        this.ubicacion = new TiempoGeolocalizado(ciudadUbicacion, latitud, longitud);
    }
    public void setConversaciones(ArrayList<Conversacion> conversaciones) {
        this.conversaciones = conversaciones;
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

    // Método: Verificar si otro usuario está en la misma zona
    public boolean estamosEnMismaZona(UsuarioNormal otro) {
        return this.ubicacion.estaMismaZona(otro.ubicacion);
    }

    // Método: Calcular distancia a otro usuario
    public double calcularDistanciaA(UsuarioNormal otro) {
        return this.ubicacion.calcularDistancia(otro.ubicacion);
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
    
    
 // Método para obtener o crear conversación con otro usuario
    public Conversacion obtenerOConversacionCon(UsuarioNormal otroUsuario) {
        for (Conversacion c : conversaciones) {
            if ((c.getRemitente() == this && c.getDestinatario() == otroUsuario) ||
                (c.getRemitente() == otroUsuario && c.getDestinatario() == this)) {
                return c;
            }
        }
        
        // No existe, crear nueva
        Conversacion nueva = new Conversacion(this, otroUsuario);
        conversaciones.add(nueva);
        
        // También agregar al otro usuario (simetría)
        otroUsuario.getConversaciones().add(nueva);
        
        return nueva;
    }
}
