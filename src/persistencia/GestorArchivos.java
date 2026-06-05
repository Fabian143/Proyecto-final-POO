package persistencia;

import java.io.*;
import java.util.ArrayList;

import kernel.Publicacion;
import kernel.Transaccion;
import kernel.Usuario;

/**
 * Clase encargada de la persistencia de datos del sistema.
 *
 * Permite guardar y cargar información relacionada con:
 * - Usuarios
 * - Publicaciones
 * - Transacciones
 *
 * Utiliza serialización de objetos para almacenar la información
 * en archivos binarios (.dat).
 *
 * Esta clase centraliza el acceso a los archivos del sistema.
 *
 * @author Wilfredo
 * @version 1.0
 */
public class GestorArchivos {

    /**
     * Nombre del archivo donde se almacenan los usuarios.
     */
    private final String archivoUsuarios = "usuarios.dat";

    /**
     * Nombre del archivo donde se almacenan las publicaciones.
     */
    private final String archivoPublicaciones = "publicaciones.dat";

    /**
     * Nombre del archivo donde se almacenan las transacciones.
     */
    private final String archivoTransacciones = "transacciones.dat";

    // ==========================
    // USUARIOS
    // ==========================

    /**
     * Guarda la lista de usuarios en el archivo usuarios.dat.
     *
     * @param usuarios Lista de usuarios a guardar.
     */
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

    /**
     * Carga la lista de usuarios almacenada en el archivo.
     *
     * @return Lista de usuarios recuperada.
     */
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

    /**
     * Guarda la lista de publicaciones en el archivo publicaciones.dat.
     *
     * @param publicaciones Lista de publicaciones a guardar.
     */
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

    /**
     * Recupera las publicaciones almacenadas en el archivo.
     *
     * @return Lista de publicaciones cargadas.
     */
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

    /**
     * Guarda la lista de transacciones en el archivo transacciones.dat.
     *
     * @param transacciones Lista de transacciones a guardar.
     */
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

    /**
     * Recupera las transacciones almacenadas en el archivo.
     *
     * @return Lista de transacciones cargadas.
     */
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
