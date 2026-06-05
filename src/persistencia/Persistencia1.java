package persistencia;

import modelo.Usuario;
import modelo.Publicacion;
import modelo.Transaccion;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    private final String archivoUsuarios = "usuarios.dat";
    private final String archivoPublicaciones = "publicaciones.dat";
    private final String archivoTransacciones = "transacciones.dat";

    // ==========================
    // USUARIOS
    // ==========================

    public void guardarUsuarios(ArrayList<Usuario> usuarios) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(archivoUsuarios));

            salida.writeObject(usuarios);

            salida.close();

        } catch (IOException e) {

            System.out.println("Error al guardar usuarios");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Usuario> cargarUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(archivoUsuarios));

            usuarios =
                    (ArrayList<Usuario>) entrada.readObject();

            entrada.close();

        } catch (Exception e) {

            System.out.println("Archivo usuarios no encontrado");
        }

        return usuarios;
    }

    // ==========================
    // PUBLICACIONES
    // ==========================

    public void guardarPublicaciones(
            ArrayList<Publicacion> publicaciones) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(archivoPublicaciones));

            salida.writeObject(publicaciones);

            salida.close();

        } catch (IOException e) {

            System.out.println("Error al guardar publicaciones");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Publicacion> cargarPublicaciones() {

        ArrayList<Publicacion> publicaciones =
                new ArrayList<>();

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(archivoPublicaciones));

            publicaciones =
                    (ArrayList<Publicacion>)
                            entrada.readObject();

            entrada.close();

        } catch (Exception e) {

            System.out.println(
                    "Archivo publicaciones no encontrado");
        }

        return publicaciones;
    }

    // ==========================
    // TRANSACCIONES
    // ==========================

    public void guardarTransacciones(
            ArrayList<Transaccion> transacciones) {

        try {

            ObjectOutputStream salida =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    archivoTransacciones));

            salida.writeObject(transacciones);

            salida.close();

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar transacciones");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Transaccion> cargarTransacciones() {

        ArrayList<Transaccion> transacciones =
                new ArrayList<>();

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(
                            new FileInputStream(
                                    archivoTransacciones));

            transacciones =
                    (ArrayList<Transaccion>)
                            entrada.readObject();

            entrada.close();

        } catch (Exception e) {

            System.out.println(
                    "Archivo transacciones no encontrado");
        }

        return transacciones;
    }
}
