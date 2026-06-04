package kernel;

import java.util.ArrayList;

public class TruequeDirecto extends Publicacion {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Oferta> ofertas;

    public TruequeDirecto(UsuarioNormal propietario,Objeto objeto,TiempoGeolocalizado fecha) {
        super(propietario,objeto,EstadosT.EN_NEGOCIACION,fecha);
        this.ofertas = new ArrayList<>();
    }

    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
        oferta.ofertaPendiente();
    }

    private boolean existeOferta(Oferta oferta) {
        return ofertas.contains(oferta);
    }

    public void cancelarOferta(Oferta oferta) throws OfertaNoValida {
        if (!existeOferta(oferta)) {
            throw new OfertaNoValida(
                "La oferta no pertenece a este trueque."
            );
        }

        oferta.cancelarOferta();
    }

    public void aceptarOferta(Oferta oferta) throws OfertaNoValida {

        if (!existeOferta(oferta)) {
            throw new OfertaNoValida(
                "La oferta no pertenece a este trueque."
            );
        }

        oferta.aceptarOferta();
        rechazarOfertas(oferta);

        setEstado(EstadosT.RESERVADO);
    }

    public void rechazarOferta(Oferta oferta)
            throws OfertaNoValida {

        if (!existeOferta(oferta)) {
            throw new OfertaNoValida(
                "La oferta no pertenece a este trueque."
            );
        }

        oferta.rechazarOferta();
    }

    private void rechazarOfertas(Oferta ofertaAceptada) {

        for (Oferta o : ofertas) {

            if (o == ofertaAceptada) {
                continue;
            }

            o.rechazarOferta();
        }
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
}