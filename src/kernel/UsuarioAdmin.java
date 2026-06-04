package kernel;

public class UsuarioAdmin extends Usuario {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    protected ValidadorFraude validador;

    public UsuarioAdmin(String nombre, String contraseña, String correo) {
        super(nombre, contraseña, correo);
        this.validador = new ValidadorFraude();
    }

    public ValidadorFraude getValidador() {
        return validador;
    }

    // Admin puede resolver disputas
    public void resolverDisputa(Disputa disputa) {
    	disputa.resolverDisputa();
    }
    
    public void aceptarDisputa(Disputa disputa) {
        disputa.aceptarDisputa();
    }
    
    public void rechazarDisputa(Disputa disputa) {
        disputa.rechazarDisputa();
    }
}
