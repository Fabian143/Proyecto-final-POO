package kernel;

import java.util.ArrayList;

public class SubastaTiempoLimitado extends Publicacion {

    private static final long serialVersionUID = 1L;

    private long tiempoCierreMillis; 
    private ArrayList<Puja> pujas;
    private TiempoGeolocalizado tiempoSubastaFinal;

    public SubastaTiempoLimitado(
            UsuarioNormal propietario,
            Objeto objeto,
            TiempoGeolocalizado fechaInicio,
            TiempoGeolocalizado fechaFin) {

        super(propietario, objeto, EstadosP.EN_NEGOCIACION, fechaInicio);

        this.tiempoSubastaFinal = fechaFin;
        this.pujas = new ArrayList<>();
    }

    public void agregarPuja(Puja puja) {

        if (getEstado() != EstadosP.EN_NEGOCIACION) {
            throw new IllegalStateException(
                    "La subasta no está disponible para recibir pujas.");
        }

        pujas.add(puja);
    }

    public Puja obtenerMayorPuja() {

        if (pujas.isEmpty()) {
            return null;
        }

        Puja mejor = pujas.get(0);

        for (Puja p : pujas) {
            if (p.getValor() > mejor.getValor()) {
                mejor = p;
            }
        }

        return mejor;
    }

    public void finalizarSubasta() {

        if (pujas.isEmpty()) {
            setEstado(EstadosP.CANCELADO);
            return;
        }

        setEstado(EstadosP.RESERVADO);
    }

    public ArrayList<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(ArrayList<Puja> pujas) {
        this.pujas = pujas;
    }

    public TiempoGeolocalizado getTiempoSubastaFinal() {
        return tiempoSubastaFinal;
    }

    public void setTiempoSubastaFinal(
            TiempoGeolocalizado tiempoSubastaFinal) {

        this.tiempoSubastaFinal = tiempoSubastaFinal;
    }
}
