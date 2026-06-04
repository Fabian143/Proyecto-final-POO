package kernel;

public class Mensaje {
	private String contenido;
	private TiempoGeolocalizado fecha;
	private UsuarioNormal remitente;
	
	public Mensaje(String contenido, TiempoGeolocalizado fecha,UsuarioNormal remitente) {
		this.remitente=remitente;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public TiempoGeolocalizado getFecha() {
		return fecha;
	}

	public void setFecha(TiempoGeolocalizado fecha) {
		this.fecha = fecha;
	}

	public UsuarioNormal getRemitente() {
		return remitente;
	}

	public void setRemitente(UsuarioNormal remitente) {
		this.remitente = remitente;
	}
	
}

