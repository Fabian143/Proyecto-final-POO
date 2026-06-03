package kernel;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static int contadorId = 1000;
    protected int id;
    protected String nombre;
    protected String contraseña;
    protected String correo;
    protected TiempoGeolocalizado tiempoRegistro;

    public Usuario(String nombre, String contraseña, String correo) {
        this.id = generarId();
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tiempoRegistro = new TiempoGeolocalizado();
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

    public String getContraseña() {
        return contraseña;
    }

    public TiempoGeolocalizado getTiempoRegistro() {
        return tiempoRegistro;
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

    public void setTiempoRegistro(TiempoGeolocalizado tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    // Validar contraseña
    public boolean verificarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, nombre='%s', correo='%s', registrado=%s}",
                id, nombre, correo, tiempoRegistro.getFechaFormato());
    }
}
