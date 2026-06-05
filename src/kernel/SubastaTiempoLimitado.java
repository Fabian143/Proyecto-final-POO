package kernel;

import java.util.ArrayList;

public class SubastaTiempoLimitado extends Publicacion {

    private static final long serialVersionUID = 1L;

    
    private ArrayList<Puja> pujas;
    private long tiempoCierreMillis; 

    public SubastaTiempoLimitado(
            UsuarioNormal propietario,
            Objeto objeto,
            TiempoGeolocalizado fechaInicio,
            long tiempoCierreMillis) {  // Ahora recibe long directamente
        
        super(propietario, objeto, EstadosP.EN_NEGOCIACION, fechaInicio);
        this.tiempoCierreMillis = tiempoCierreMillis;
        this.pujas = new ArrayList<>();
    }
    
 /// GETTER para el tiempo de cierre
    public long getTiempoCierreMillis() {
        return tiempoCierreMillis;
    }

    // SETTER 
    public void setTiempoCierreMillis(long tiempoCierreMillis) {
        this.tiempoCierreMillis = tiempoCierreMillis;
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

}
