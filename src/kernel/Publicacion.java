package kernel;

import java.io.Serializable;

public class Publicacion implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contadorId = 2000;
    protected int id;
    protected EstadosP estado;
    protected TiempoGeolocalizado fecha;
    protected UsuarioNormal propietario;
    protected Objeto objeto;

    public Publicacion(UsuarioNormal propietario, Objeto objeto,EstadosP estado,TiempoGeolocalizado fecha) {
        this.id = generarId();
        this.propietario = propietario;
        this.objeto = objeto;
        this.fecha = fecha;
        this.estado = estado;
    }

    private static int generarId() {
        return contadorId++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public EstadosP getEstado() {
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


    // Setters
    public void setEstado(EstadosP estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {

        return objeto.getDescripcion();
    }
}
