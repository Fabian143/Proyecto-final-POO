package kernel;

public class OfertaNoValida extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public OfertaNoValida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
