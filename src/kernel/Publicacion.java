package kernel;

import java.io.Serializable;

public class Publicacion implements Serializable {
    
    private static int contadorId = 2000;
    protected int id;
    protected EstadoTransaccion estado;
    protected TiempoGeolocalizado fecha;
    protected UsuarioNormal propietario;
    protected Objeto objeto;
    protected tipoP tipo;

    public Publicacion(UsuarioNormal propietario, Objeto objeto, tipoP tipo) {
        this.id = generarId();
        this.propietario = propietario;
        this.objeto = objeto;
        this.tipo = tipo;
        this.fecha = new TiempoGeolocalizado();
        this.estado = new EstadoTransaccion();
    }

    private static int generarId() {
        return contadorId++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    public UsuarioNormal getPropietario() {
        return propietario;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public tipoP getTipo() {
        return tipo;
    }

    // Setters
    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }
}
