package kernel;

public class ValidadorFraude {

    public boolean verificarCuentaDuplicada(
            UsuarioNormal usuario1,
            UsuarioNormal usuario2) {

        return usuario1.getCorreo()
                .equalsIgnoreCase(usuario2.getCorreo());
    }

    public boolean verificarAutoPuja(
            UsuarioNormal usuario,
            SubastaTiempoLimitado subasta) {

        return usuario == subasta.getPropietario();
    }

    public boolean verificarOfertaPropia(
            UsuarioNormal usuario,
            TruequeDirecto trueque) {

        return usuario == trueque.getPropietario();
    }
}