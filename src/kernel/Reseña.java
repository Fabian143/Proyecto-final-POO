package kernel;


import java.io.Serializable;

public class Reseña implements Serializable {

    private int calificacion;
    private String comentario;

    public Reseña(int calificacion,
                  String comentario) {

        this.calificacion = calificacion;
        this.comentario = comentario;
    }
}
