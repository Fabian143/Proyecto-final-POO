package kernel;

import java.io.Serializable;

/**
 * Clase que representa una publicación dentro del sistema de subastas
 * e intercambios.
 *
 * Cada publicación está asociada a:
 * - Un identificador único autogenerado.
 * - Un propietario.
 * - Un objeto ofrecido.
 * - Un estado actual.
 * - Una fecha de creación.
 *
 * Implementa Serializable para permitir almacenar objetos
 * en archivos de forma permanente.
 */
public class Publicacion implements Serializable {

    /**
     * Identificador para la serialización de objetos.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Contador utilizado para generar IDs automáticos.
     */
    private static int contadorId = 2000;

    /**
     * Identificador único de la publicación.
     */
    protected int id;

    /**
     * Estado actual de la publicación.
     */
    protected EstadosP estado;

    /**
     * Fecha y hora de creación de la publicación.
     */
    protected TiempoGeolocalizado fecha;

    /**
     * Usuario propietario de la publicación.
     */
    protected UsuarioNormal propietario;

    /**
     * Objeto ofrecido en la publicación.
     */
    protected Objeto objeto;

    /**
     * Constructor de la clase Publicacion.
     *
     * @param propietario Usuario dueño de la publicación.
     * @param objeto Objeto que se ofrece.
     * @param estado Estado inicial de la publicación.
     * @param fecha Fecha y hora de creación.
     */
    public Publicacion(UsuarioNormal propietario,
                       Objeto objeto,
                       EstadosP estado,
                       TiempoGeolocalizado fecha) {

        this.id = generarId();
        this.propietario = propietario;
        this.objeto = objeto;
        this.fecha = fecha;
        this.estado = estado;
    }

    /**
     * Genera un ID automático para cada nueva publicación.
     *
     * @return ID único generado.
     */
    private static int generarId() {
        return contadorId++;
    }

    /**
     * Obtiene el identificador de la publicación.
     *
     * @return ID de la publicación.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el estado actual de la publicación.
     *
     * @return Estado de la publicación.
     */
    public EstadosP getEstado() {
        return estado;
    }

    /**
     * Obtiene la fecha de creación de la publicación.
     *
     * @return Fecha registrada.
     */
    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    /**
     * Obtiene el propietario de la publicación.
     *
     * @return Usuario propietario.
     */
    public UsuarioNormal getPropietario() {
        return propietario;
    }

    /**
     * Obtiene el objeto asociado a la publicación.
     *
     * @return Objeto publicado.
     */
    public Objeto getObjeto() {
        return objeto;
    }

    /**
     * Modifica el estado actual de la publicación.
     *
     * @param estado Nuevo estado.
     */
    public void setEstado(EstadosP estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación textual de la publicación.
     *
     * En este caso se muestra la descripción del objeto asociado.
     *
     * @return Descripción del objeto publicado.
     */
    @Override
    public String toString() {

        return objeto.getDescripcion();
    }
}
