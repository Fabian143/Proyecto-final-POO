package kernel;

import java.io.Serializable;

public class Puja implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioNormal pujador;
    private double valor;
    private TiempoGeolocalizado t;

    public Puja(UsuarioNormal usuario, double valor, TiempoGeolocalizado t) {
        this.pujador = usuario;
        this.valor = valor;
        this.t = t;
    }

    public UsuarioNormal getUsuarioqpuja() {
        return pujador;
    }

    public void setUsuarioqpuja(UsuarioNormal usuarioqpuja) {
        this.pujador = usuarioqpuja;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TiempoGeolocalizado getT() {
        return t;
    }

    public void setT(TiempoGeolocalizado t) {
        this.t = t;
    }
}
