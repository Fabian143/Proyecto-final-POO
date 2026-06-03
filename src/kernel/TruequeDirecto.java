package kernel;

public class TruequeDirecto extends Publicacion {

    public TruequeDirecto(int id,
                          String descripcion,
                          String categoria,
                          String ubicacion) {

        super(id, descripcion, categoria, ubicacion);
    }

    @Override
    public void mostrarPublicacion() {

        System.out.println("TRUEQUE");
        System.out.println(descripcion);
    }
}
