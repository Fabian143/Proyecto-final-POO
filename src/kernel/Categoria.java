package kernel;

public enum Categoria {
    ELECTRONICA("Electrónica"),
    ROPA("Ropa"),
    LIBROS("Libros"),
    MUEBLES("Muebles"),
    DEPORTES("Deportes"),
    HOGAR("Hogar"),
    OTROS("Otros");

    private String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
