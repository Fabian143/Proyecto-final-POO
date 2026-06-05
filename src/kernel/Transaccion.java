package kernel;

import java.io.Serializable;

/**
 * Clase que representa una transacción realizada entre dos usuarios.
 *
 * Una transacción se crea a partir de una publicación y permite
 * controlar el estado del intercambio realizado entre los participantes.
 *
 * La transacción puede encontrarse en diferentes estados:
 * - EN_PROCESO
 * - COMPLETADA
 * - CANCELADA
 * - EN_DISPUTA
 *
 * Implementa Serializable para permitir almacenar las transacciones
 * en archivos y recuperarlas posteriormente.
 *
 */
public class Transaccion implements Serializable {

    /**
     * Identificador para la serialización de objetos.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Primer usuario participante de la transacción.
     */
    private UsuarioNormal usuario1;

    /**
     * Segundo usuario participante de la transacción.
     */
    private UsuarioNormal usuario2;

    /**
     * Fecha y hora en la que se creó la transacción.
     */
    private TiempoGeolocalizado fecha;

    /**
     * Estado actual de la transacción.
     */
    private EstadoTransaccion estadoActual;

    /**
     * Publicación que dio origen a la transacción.
     */
    private Publicacion publicacionOrigen;

    /**
     * Constructor de la clase Transaccion.
     *
     * @param publicacionOrigen Publicación asociada.
     * @param usuario1 Primer usuario participante.
     * @param usuario2 Segundo usuario participante.
     */
    public Transaccion(Publicacion publicacionOrigen,
                       UsuarioNormal usuario1,
                       UsuarioNormal usuario2) {

        this.publicacionOrigen = publicacionOrigen;
        this.fecha = new TiempoGeolocalizado();
        this.estadoActual = EstadoTransaccion.EN_PROCESO;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    /**
     * Marca la transacción como completada.
     *
     * También actualiza el estado de la publicación
     * asociada a FINALIZADO.
     */
    public void completar() {

        estadoActual = EstadoTransaccion.COMPLETADA;
        publicacionOrigen.setEstado(EstadosP.FINALIZADO);
    }

    /**
     * Cancela la transacción.
     *
     * También actualiza el estado de la publicación
     * asociada a CANCELADO.
     */
    public void cancelar() {

        estadoActual = EstadoTransaccion.CANCELADA;
        publicacionOrigen.setEstado(EstadosP.CANCELADO);
    }

    /**
     * Cambia el estado de la transacción a EN_DISPUTA.
     *
     * Se utiliza cuando existe algún inconveniente
     * entre los participantes.
     */
    public void abrirDisputa() {

        estadoActual = EstadoTransaccion.EN_DISPUTA;
    }

    /**
     * Obtiene la fecha de creación de la transacción.
     *
     * @return Fecha registrada.
     */
    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha de la transacción.
     *
     * @param fecha Nueva fecha.
     */
    public void setFecha(TiempoGeolocalizado fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado actual de la transacción.
     *
     * @return Estado actual.
     */
    public EstadoTransaccion getEstadoActual() {
        return estadoActual;
    }

    /**
     * Modifica el estado actual de la transacción.
     *
     * @param estadoActual Nuevo estado.
     */
    public void setEstadoActual(EstadoTransaccion estadoActual) {
        this.estadoActual = estadoActual;
    }

    /**
     * Obtiene la publicación asociada a la transacción.
     *
     * @return Publicación origen.
     */
    public Publicacion getPublicacionOrigen() {
        return publicacionOrigen;
    }

    /**
     * Modifica la publicación asociada.
     *
     * @param publicacionOrigen Nueva publicación.
     */
    public void setPublicacionOrigen(Publicacion publicacionOrigen) {
        this.publicacionOrigen = publicacionOrigen;
    }

    /**
     * Obtiene el primer usuario participante.
     *
     * @return Usuario 1.
     */
    public UsuarioNormal getUsuario1() {
        return usuario1;
    }

    /**
     * Modifica el primer usuario participante.
     *
     * @param usuario1 Nuevo usuario.
     */
    public void setUsuario1(UsuarioNormal usuario1) {
        this.usuario1 = usuario1;
    }

    /**
     * Obtiene el segundo usuario participante.
     *
     * @return Usuario 2.
     */
    public UsuarioNormal getUsuario2() {
        return usuario2;
    }

    /**
     * Modifica el segundo usuario participante.
     *
     * @param usuario2 Nuevo usuario.
     */
    public void setUsuario2(UsuarioNormal usuario2) {
        this.usuario2 = usuario2;
    }

    /**
     * Devuelve una representación textual de la transacción.
     *
     * @return Información resumida de la transacción.
     */
    @Override
    public String toString() {

        return "Transaccion [Usuario1=" + usuario1.getNombre()
                + ", Usuario2=" + usuario2.getNombre()
                + ", Estado=" + estadoActual
                + ", Fecha=" + fecha.getFechaFormato()
                + "]";
    }
}
