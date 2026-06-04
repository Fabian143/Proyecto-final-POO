package kernel;

public class Puja{
    private UsuarioNormal usuarioqpuja;
    private double valor;
    private TiempoGeolocalizado t;
    
    public Puja(UsuarioNormal usuario,double valor, TiempoGeolocalizado t) {
        usuarioqpuja=usuario;
        this.t=t;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
