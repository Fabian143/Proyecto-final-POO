package kernel;

import java.util.ArrayList;

public class Transaccion {
	ArrayList <UsuarioNormal> participantes;
	TiempoGeolocalizado fecha=new TiempoGeolocalizado();
	EstadosT estadoActual;
	Objeto objeto;
}
