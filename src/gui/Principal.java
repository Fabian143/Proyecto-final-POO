package gui;

import javax.swing.JFrame;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;

    public Principal() {

        setTitle("Trueques");
        setSize(500,332);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new Login(this));

        setVisible(true);
    }

    public static void main(String[] args) {

        new Principal();
    }
}
