package kernel;

import java.io.Serializable;

public class Disputa implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioNormal usuarioReportante;
    private UsuarioNormal usuarioReportado;
    private Publicacion publicacionReportada;
    private Transaccion transaccionReportada;

    private String motivo;

    private EstadoD estado;

    private TiempoGeolocalizado fecha;

    public Disputa(
            UsuarioNormal usuarioReportante,
            UsuarioNormal usuarioReportado,
            Publicacion publicacionReportada,
            Transaccion transaccionReportada,
            String motivo) {

        this.usuarioReportante = usuarioReportante;
        this.usuarioReportado = usuarioReportado;
        this.publicacionReportada = publicacionReportada;
        this.transaccionReportada = transaccionReportada;

        this.motivo = motivo;

        this.estado = EstadoD.Abierta;

        this.fecha = new TiempoGeolocalizado();
    }

    public void aceptarDisputa() {
        estado = EstadoD.En_Revision;
    }

    public void rechazarDisputa() {
        estado = EstadoD.Rechazada;
    }
    public void resolverDisputa() {
    	estado= EstadoD.Resuelta;
    }
    public UsuarioNormal getUsuarioReportante() {
        return usuarioReportante;
    }

    public void setUsuarioReportante(
            UsuarioNormal usuarioReportante) {

        this.usuarioReportante = usuarioReportante;
    }

    public UsuarioNormal getUsuarioReportado() {
        return usuarioReportado;
    }

    public void setUsuarioReportado(
            UsuarioNormal usuarioReportado) {

        this.usuarioReportado = usuarioReportado;
    }

    public Publicacion getPublicacionReportada() {
        return publicacionReportada;
    }

    public void setPublicacionReportada(
            Publicacion publicacionReportada) {

        this.publicacionReportada = publicacionReportada;
    }

    public Transaccion getTransaccionReportada() {
        return transaccionReportada;
    }

    public void setTransaccionReportada(
            Transaccion transaccionReportada) {

        this.transaccionReportada = transaccionReportada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoD getEstado() {
        return estado;
    }

    public void setEstado(EstadoD estado) {
        this.estado = estado;
    }

    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    public void setFecha(TiempoGeolocalizado fecha) {
        this.fecha = fecha;
    }
}