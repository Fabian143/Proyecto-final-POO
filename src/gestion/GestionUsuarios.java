package gestion;

import java.util.ArrayList;

import kernel.UsuarioNormal;

public class GestionUsuarios {

    private ArrayList<UsuarioNormal> usuarios;

    public GestionUsuarios() {

        usuarios = new ArrayList<UsuarioNormal>();
    }

    public void registrar(UsuarioNormal usuario) {

        usuarios.add(usuario);
    }

    public boolean existeCorreo(String correo) {

        for (UsuarioNormal u : usuarios) {

            if (u.getCorreo().equalsIgnoreCase(correo)) {

                return true;
            }
        }

        return false;
    }

    public UsuarioNormal login(
            String correo,
            String contraseña) {

        for (UsuarioNormal u : usuarios) {

            if (u.getCorreo().equalsIgnoreCase(correo)
                    && u.verificarContraseña(contraseña)) {

                return u;
            }
        }

        return null;
    }
}
