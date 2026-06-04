package persistencia;

import java.io.*;
import java.util.ArrayList;

import kernel.UsuarioNormal;

public class ArchivoUsuarios {

    private static final String ARCHIVO =
            "usuarios.dat";

    @SuppressWarnings("unchecked")
    public static ArrayList<UsuarioNormal> cargar() {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(
                                    ARCHIVO));

            ArrayList<UsuarioNormal> usuarios =
                    (ArrayList<UsuarioNormal>)
                            entrada.readObject();

            entrada.close();

            return usuarios;

        } catch(Exception e) {

            return new ArrayList<UsuarioNormal>();
        }
    }

    public static void guardar(
            ArrayList<UsuarioNormal> usuarios) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    ARCHIVO));

            salida.writeObject(usuarios);

            salida.close();

        } catch(Exception e) {

            System.out.println(
                    "Error guardando usuarios");
        }
    }
}
