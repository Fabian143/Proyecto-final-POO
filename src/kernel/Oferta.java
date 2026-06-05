package kernel;

import java.io.Serializable;

/**
 * Clase que representa una oferta de intercambio entre usuarios.
 *
 * Una oferta contiene:
 * - El usuario que realiza la oferta.
 * - El objeto que ofrece.
 * - El objeto que desea obtener.
 * - La fecha de creación de la oferta.
 * - El estado actual de la oferta.
 *
 * Implementa Serializable para permitir almacenar las ofertas
 * en archivos y recuperarlas posteriormente.
 *
 * @author Wilfredo
 * @version 1.0
 */
public class Oferta implements Serializable {

    /**
     * Identificador para la serialización de objetos.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Fecha y hora en que se realizó la oferta.
     */
    private TiempoGeolocalizado fecha;

    /**
     * Usuario que realiza la oferta.
     */
    private UsuarioNormal usuario;

    /**
     * Objeto que el usuario ofrece para el intercambio.
     */
    private Objeto objetoOfrecido;

    /**
     * Objeto que el usuario desea recibir.
     */
    private Objeto objetoSolicitado;

    /**
     * Estado actual de la oferta.
     */
    private EstadoOferta estado;

    /**
     * Constructor de la clase Oferta.
     *
     * @param fecha Fecha de creación de la oferta.
     * @param usuario Usuario que realiza la oferta.
     * @param objetoOfrecido Objeto ofrecido por el usuario.
     * @param objetoSolicitado Objeto que desea obtener.
     * @param estado Estado inicial de la oferta.
     */
    public Oferta(TiempoGeolocalizado fecha,
                  UsuarioNormal usuario,
                  Objeto objetoOfrecido,
                  Objeto objetoSolicitado,
                  EstadoOferta estado) {

        this.fecha = fecha;
        this.usuario = usuario;
        this.objetoOfrecido = objetoOfrecido;
        this.objetoSolicitado = objetoSolicitado;
        this.estado = estado;
    }

    /**
     * Cambia el estado de la oferta a Aceptada.
     */
    public void aceptarOferta() {
        estado = EstadoOferta.Aceptada;
    }

    /**
     * Cambia el estado de la oferta a Cancelada.
     */
    public void cancelarOferta() {
        estado = EstadoOferta.Cancelada;
    }

    /**
     * Cambia el estado de la oferta a Pendiente.
     */
    public void ofertaPendiente() {
        estado = EstadoOferta.Pendiente;
    }

    /**
     * Cambia el estado de la oferta a Rechazada.
     */
    public void rechazarOferta() {
        estado = EstadoOferta.Rechazada;
    }

    /**
     * Obtiene la fecha de la oferta.
     *
     * @return Fecha de creación.
     */
    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha de la oferta.
     *
     * @param fecha Nueva fecha.
     */
    public void setFecha(TiempoGeolocalizado fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el usuario que realizó la oferta.
     *
     * @return Usuario asociado.
     */
    public UsuarioNormal getUsuario() {
        return usuario;
    }

    /**
     * Modifica el usuario asociado a la oferta.
     *
     * @param usuario Nuevo usuario.
     */
    public void setUsuario(UsuarioNormal usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el objeto ofrecido.
     *
     * @return Objeto ofrecido.
     */
    public Objeto getObjetoOfrecido() {
        return objetoOfrecido;
    }

    /**
     * Modifica el objeto ofrecido.
     *
     * @param objetoOfrecido Nuevo objeto ofrecido.
     */
    public void setObjetoOfrecido(Objeto objetoOfrecido) {
        this.objetoOfrecido = objetoOfrecido;
    }

    /**
     * Obtiene el objeto solicitado.
     *
     * @return Objeto solicitado.
     */
    public Objeto getObjetoSolicitado() {
        return objetoSolicitado;
    }

    /**
     * Modifica el objeto solicitado.
     *
     * @param objetoSolicitado Nuevo objeto solicitado.
     */
    public void setObjetoSolicitado(Objeto objetoSolicitado) {
        this.objetoSolicitado = objetoSolicitado;
    }

    /**
     * Obtiene el estado actual de la oferta.
     *
     * @return Estado de la oferta.
     */
    public EstadoOferta getEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la oferta.
     *
     * @param estado Nuevo estado.
     */
    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    /**
     * Devuelve una representación textual de la oferta.
     *
     * @return Información resumida de la oferta.
     */
    @Override
    public String toString() {
        return "Oferta [Usuario=" + usuario.getNombre()
                + ", Ofrece=" + objetoOfrecido.getDescripcion()
                + ", Solicita=" + objetoSolicitado.getDescripcion()
                + ", Estado=" + estado + "]";
    }
}
