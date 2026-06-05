package gui;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;

    public Principal() {
        // Carga del icono de la aplicación
        setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/icono1.png")));
    	
        setTitle("Sistema de Trueques");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        
        // Evita que la ventana cambie de tamaño (desactiva maximizar y estirar)
        setResizable(false); 
        
        // Configura la 'X' para que NO haga nada al ser presionada
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        setContentPane(new Login(this));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}