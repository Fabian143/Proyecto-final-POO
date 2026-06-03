package kernel;

import java.io.Serializable;

public class Reseña implements Serializable {
    
    private static int contadorId = 5000;
    protected int id;
    protected UsuarioNormal autor;
    protected double calificacion;
    protected String comentario;
    protected TiempoGeolocalizado fecha;

    // Constructor completo
    public Reseña(UsuarioNormal autor, double calificacion, String comentario) {
        this.id = generarId();
        this.autor = autor;
        this.calificacion = validarCalificacion(calificacion);
        this.comentario = comentario != null ? comentario : "";
        this.fecha = new TiempoGeolocalizado();
    }

    private static int generarId() {
        return contadorId++;
    }

    // Validar que la calificación esté entre 1 y 5
    private double validarCalificacion(double calificacion) {
        if (calificacion < 1.0 || calificacion > 5.0) {
            throw new IllegalArgumentException("La calificación debe estar entre 1.0 y 5.0");
        }
        return calificacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public UsuarioNormal getAutor() {
        return autor;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public TiempoGeolocalizado getFecha() {
        return fecha;
    }

    // Setters
    public void setCalificacion(double calificacion) {
        this.calificacion = validarCalificacion(calificacion);
    }

    public void setComentario(String comentario) {
        this.comentario = comentario != null ? comentario : "";
    }

    @Override
    public String toString() {
        return String.format("Reseña{id=%d, autor=%s, calificación=%.1f, fecha=%s, comentario='%s'}",
                id, autor.getNombre(), calificacion, fecha.getFechaFormato(), comentario);
    }
}
