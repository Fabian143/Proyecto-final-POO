package kernel;

import java.io.Serializable;

public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
	private TiempoGeolocalizado fecha;
	private UsuarioNormal usuario;
	private Objeto objetoOfrecido;
	private Objeto objetoSolicitado;
	private EstadoOferta estado;
	
	public Oferta(TiempoGeolocalizado fecha, UsuarioNormal usuario, Objeto objetoOfrecido, Objeto objetoSolicitado,
			EstadoOferta estado) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.objetoOfrecido = objetoOfrecido;
		this.objetoSolicitado = objetoSolicitado;
		this.estado = estado;
	}
	
	public void aceptarOferta() {
	    estado = EstadoOferta.Aceptada;
	}
	public void cancelarOferta() {
	    estado = EstadoOferta.Cancelada;
	}
	public void ofertaPendiente() {
	    estado = EstadoOferta.Pendiente;
	}
	public void rechazarOferta() {
	    estado = EstadoOferta.Rechazada;
	}
	
	public TiempoGeolocalizado getFecha() {
		return fecha;
	}

	public void setFecha(TiempoGeolocalizado fecha) {
		this.fecha = fecha;
	}

	public UsuarioNormal getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioNormal usuario) {
		this.usuario = usuario;
	}

	public Objeto getObjetoOfrecido() {
		return objetoOfrecido;
	}

	public void setObjetoOfrecido(Objeto objetoOfrecido) {
		this.objetoOfrecido = objetoOfrecido;
	}

	public Objeto getObjetoSolicitado() {
		return objetoSolicitado;
	}

	public void setObjetoSolicitado(Objeto objetoSolicitado) {
		this.objetoSolicitado = objetoSolicitado;
	}

	public EstadoOferta getEstado() {
		return estado;
	}

	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
	}
	
	
}
