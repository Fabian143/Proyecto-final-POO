package kernel;

public class Puja extends Oferta {

    private double valor;

    public Puja(Usuario usuario,
                double valor) {

        super(usuario);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
