package kernel;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <UsuarioNormal> participantes;
	TiempoGeolocalizado fecha=new TiempoGeolocalizado();
	EstadosT estadoActual;
	Objeto objeto;
}
