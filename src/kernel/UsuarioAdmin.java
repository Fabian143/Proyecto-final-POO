package kernel;

import interfaces.Reportable;

public class UsuarioAdmin extends Usuario implements Reportable {

    public UsuarioAdmin(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    public void mostrarDatos() {

        System.out.println("Administrador");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
    }

    @Override
    public void generarReporte() {

        System.out.println("Generando reporte...");
    }
}
