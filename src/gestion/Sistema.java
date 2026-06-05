package gestion;

import kernel.UsuarioNormal;

public class Sistema {

    public static GestionUsuarios gestionUsuarios =
            new GestionUsuarios();

     public static GestionPublicaciones
gestionPublicaciones =
        new GestionPublicaciones();

    public static UsuarioNormal usuarioActual;

}
