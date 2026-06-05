package gestion;

import java.util.ArrayList;

import kernel.EstadosP;
import kernel.Publicacion;
import kernel.UsuarioNormal;

public class GestionPublicaciones {

    public ArrayList<Publicacion> obtenerTodas() {

        ArrayList<Publicacion> publicaciones =
                new ArrayList<>();

        for(UsuarioNormal usuario :
                Sistema.gestionUsuarios
                .getUsuarios()) {

            publicaciones.addAll(
                    usuario.getPublicaciones());
        }

        return publicaciones;
    }

    public ArrayList<Publicacion>
    obtenerPublicacionesDisponibles() {

        ArrayList<Publicacion> disponibles =
                new ArrayList<>();

        for(Publicacion p :
                obtenerTodas()) {

            if(p.getEstado()
                    != EstadosP.CANCELADO) {

                disponibles.add(p);
            }
        }

        return disponibles;
    }
}
