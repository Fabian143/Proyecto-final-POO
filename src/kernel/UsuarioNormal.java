package kernel;

public class UsuarioNormal extends Usuario {

    public UsuarioNormal(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    public void mostrarDatos() {

        System.out.println("Usuario Normal");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Reputación: " + reputacion);
    }
}
