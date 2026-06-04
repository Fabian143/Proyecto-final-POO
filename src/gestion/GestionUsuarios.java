package gestion;

import java.util.ArrayList;

import kernel.UsuarioNormal;
import persistencia.ArchivoUsuarios;

public class GestionUsuarios {

    private ArrayList<UsuarioNormal> usuarios;

    public GestionUsuarios() {

    usuarios =
            ArchivoUsuarios.cargar();
}

    public void registrar(
        UsuarioNormal usuario) {

    usuarios.add(usuario);

    ArchivoUsuarios.guardar(
            usuarios);
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

        public ArrayList<UsuarioNormal>
        getUsuarios() {

    return usuarios;
}

        return null;
    }
}
