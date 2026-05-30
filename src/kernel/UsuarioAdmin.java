package kernel;

import java.util.ArrayList;

public class UsuarioAdmin extends Usuario{
	private String contraseña=super.contraseña;
	ArrayList<Disputa> disputas;
	ValidadorFraude Validador;
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
