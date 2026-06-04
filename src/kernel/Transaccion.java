package kernel;

import java.io.Serializable;

public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioNormal usuario1;
    private UsuarioNormal usuario2;
    private TiempoGeolocalizado fecha;
    private EstadoTransaccion estadoActual;
    private Publicacion publicacionOrigen;

    public Transaccion(Publicacion publicacionOrigen,UsuarioNormal usuario1,UsuarioNormal usuario2) {

        this.publicacionOrigen = publicacionOrigen;
        this.fecha = new TiempoGeolocalizado();
        this.estadoActual = EstadoTransaccion.EN_PROCESO;
        this.usuario1=usuario1;
        this.usuario2=usuario2;
    }


    public void completar() {
        estadoActual = EstadoTransaccion.COMPLETADA;
        publicacionOrigen.setEstado(EstadosP.FINALIZADO);
    }

    public void cancelar() {
        estadoActual = EstadoTransaccion.CANCELADA;
        publicacionOrigen.setEstado(EstadosP.CANCELADO);
    }

    public void abrirDisputa() {
        estadoActual = EstadoTransaccion.EN_DISPUTA;
    }

    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    public void setFecha(TiempoGeolocalizado fecha) {
        this.fecha = fecha;
    }

    public EstadoTransaccion getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoTransaccion estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Publicacion getPublicacionOrigen() {
        return publicacionOrigen;
    }

    public void setPublicacionOrigen(Publicacion publicacionOrigen) {
        this.publicacionOrigen = publicacionOrigen;
    }


	public UsuarioNormal getUsuario1() {
		return usuario1;
	}


	public void setUsuario1(UsuarioNormal usuario1) {
		this.usuario1 = usuario1;
	}


	public UsuarioNormal getUsuario2() {
		return usuario2;
	}


	public void setUsuario2(UsuarioNormal usuario2) {
		this.usuario2 = usuario2;
	}
    
}