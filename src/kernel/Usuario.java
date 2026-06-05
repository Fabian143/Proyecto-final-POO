package kernel;

import java.io.Serializable;

/**
 * Clase que representa un usuario dentro del sistema de subastas.
 * Implementa Serializable para permitir almacenar objetos en archivos.
 *
 * Cada usuario posee:
 * - Un ID autogenerado.
 * - Nombre.
 * - Correo electrónico.
 * - Contraseña.
 * - Fecha y hora de registro.
 *
 * @author Wilfredo
 * @version 1.0
 */
public class Usuario implements Serializable {

    /**
     * Identificador para la serialización de objetos.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Contador utilizado para generar IDs automáticos.
     */
    private static int contadorId = 1000;

    /**
     * Identificador único del usuario.
     */
    protected int id;

    /**
     * Nombre del usuario.
     */
    protected String nombre;

    /**
     * Contraseña de acceso al sistema.
     */
    protected String contraseña;

    /**
     * Correo electrónico del usuario.
     */
    protected String correo;

    /**
     * Fecha y hora en la que se registró el usuario.
     */
    protected TiempoGeolocalizado tiempoRegistro;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombre Nombre del usuario.
     * @param contraseña Contraseña del usuario.
     * @param correo Correo electrónico del usuario.
     */
    public Usuario(String nombre, String contraseña, String correo) {

        this.id = generarId();
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tiempoRegistro = new TiempoGeolocalizado();
    }

    /**
     * Genera un ID automático para cada nuevo usuario.
     *
     * @return ID único generado.
     */
    private static int generarId() {
        return contadorId++;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña almacenada.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Obtiene la fecha y hora de registro.
     *
     * @return Objeto TiempoGeolocalizado.
     */
    public TiempoGeolocalizado getTiempoRegistro() {
        return tiempoRegistro;
    }

    /**
     * Modifica el nombre del usuario.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el correo del usuario.
     *
     * @param correo Nuevo correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Modifica la contraseña del usuario.
     *
     * @param contraseña Nueva contraseña.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Modifica la fecha y hora de registro.
     *
     * @param tiempoRegistro Nuevo registro temporal.
     */
    public void setTiempoRegistro(TiempoGeolocalizado tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    /**
     * Verifica si la contraseña ingresada coincide
     * con la almacenada en el sistema.
     *
     * @param contraseña Contraseña a verificar.
     * @return true si coincide, false en caso contrario.
     */
    public boolean verificarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    /**
     * Devuelve una representación textual del usuario.
     *
     * @return Información principal del usuario.
     */
    @Override
    public String toString() {

        return String.format(
                "Usuario{id=%d, nombre='%s', correo='%s', registrado=%s}",
                id,
                nombre,
                correo,
                tiempoRegistro.getFechaFormato()
        );
    }
}
