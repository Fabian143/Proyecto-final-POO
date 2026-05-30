package kernel;

public class EstadoTransaccion {
	EstadosT estados;
	
	private EstadosT estadoActual;
	
	public EstadosT getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(EstadosT estadoActual) {
		this.estadoActual = estadoActual;
	}

	
}
