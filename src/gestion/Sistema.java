package gestion;

import kernel.UsuarioNormal;

public class Sistema {

    public static GestionUsuarios gestionUsuarios =
            new GestionUsuarios();

    public static UsuarioNormal usuarioActual;

    public static GestionPublicaciones
gestionPublicaciones =
        new GestionPublicaciones();
}
