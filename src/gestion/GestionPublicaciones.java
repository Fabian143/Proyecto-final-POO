package gestion;

import java.util.ArrayList;

import kernel.Publicacion;
import kernel.UsuarioNormal;

public class GestionPublicaciones {

    public ArrayList<Publicacion>
    obtenerTodas() {

        ArrayList<Publicacion>
        publicaciones =
                new ArrayList<>();

        for(UsuarioNormal usuario :
                Sistema.gestionUsuarios
                .getUsuarios()) {

            publicaciones.addAll(
                    usuario.getPublicaciones());
        }

        return publicaciones;
    }
}
