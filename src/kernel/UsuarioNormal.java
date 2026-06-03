package kernel;

import java.util.ArrayList;

public class UsuarioNormal extends Usuario{
	String ubicacion;
	private String contraseña=super.contraseña;
	ArrayList<Publicacion> publicaciones;
	ArrayList<Reseña> reseñasComoVendedor;
	ArrayList<Reseña> reseñasComoCliente;
	ArrayList<Transaccion> transacciones;
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
