package kernel;

import interfaces.Calificable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements  Serializable {

    private static int contadorId = 1000;  // ID autogenerativo
    protected int id;
    protected String nombre;
    protected String contraseña;
    protected String correo;
    
    public Usuario(String nombre, String contraseña, String correo) {
        this.id = generarId();
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    // ID autogenerativo
    private static int generarId() {
        return contadorId++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }


    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
