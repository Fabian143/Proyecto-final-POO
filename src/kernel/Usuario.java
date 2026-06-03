package kernel;

import interfaces.Calificable;
import java.io.Serializable;

public abstract class Usuario implements Calificable, Serializable {

    protected int id;
    protected String nombre;
    protected String correo;
    protected double reputacion;

    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.reputacion = 5.0;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public double getReputacion() {
        return reputacion;
    }
    public void setReputacion(double reputacion) {
        this.reputacion = reputacion;
    }
    public abstract void mostrarDatos();
    @Override
    public void calificar(double nota) {
        reputacion = (reputacion + nota) / 2;
    }
}
