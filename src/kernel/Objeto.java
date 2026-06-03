package kernel;

import java.io.Serializable;
import java.util.ArrayList;

public class Objeto implements Serializable {
    
    private String descripcion;
    private String condiciones;
    private String categoria;
    private ArrayList<String> fotos;

    public Objeto(String descripcion, String condiciones, String categoria) {
        this.descripcion = descripcion;
        this.condiciones = condiciones;
        this.categoria = categoria;
        this.fotos = new ArrayList<>();
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public String getCategoria() {
        return categoria;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Métodos para gestionar fotos
    public void agregarFoto(String rutaFoto) {
        fotos.add(rutaFoto);
    }

    public void removerFoto(String rutaFoto) {
        fotos.remove(rutaFoto);
    }
}
