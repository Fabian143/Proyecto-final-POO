package kernel;

import java.util.ArrayList;

public class UsuarioAdmin extends Usuario {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<Disputa> disputas;
    protected ValidadorFraude validador;

    public UsuarioAdmin(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
        this.disputas = new ArrayList<>();
        this.validador = new ValidadorFraude();
    }

    // Getters
    public ArrayList<Disputa> getDisputas() {
        return disputas;
    }

    public ValidadorFraude getValidador() {
        return validador;
    }

    // Admin puede resolver disputas
    public void resolverDisputa(Disputa disputa) {
        // Lógica de resolución
    }
}
