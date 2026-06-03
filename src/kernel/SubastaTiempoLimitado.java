package kernel;

import java.time.LocalDate;

public class SubastaTiempoLimitado extends Publicacion {

    private double pujaMinima;
    private LocalDate fechaCierre;

    public SubastaTiempoLimitado(
            int id,
            String descripcion,
            String categoria,
            String ubicacion,
            double pujaMinima,
            LocalDate fechaCierre) {

        super(id, descripcion, categoria, ubicacion);

        this.pujaMinima = pujaMinima;
        this.fechaCierre = fechaCierre;
    }

    @Override
    public void mostrarPublicacion() {

        System.out.println("SUBASTA");
        System.out.println(descripcion);
        System.out.println("Puja mínima: " + pujaMinima);
    }
}
