package ggui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
import gestion.Sistema;
import kernel.Categoria;
import kernel.Objeto;
import kernel.SubastaTiempoLimitado;
import kernel.TiempoGeolocalizado;
import kernel.UsuarioNormal;
 
/**
 * Pantalla para que el usuario cree una nueva publicacion
 * de tipo subasta con tiempo limitado.
 * El usuario ingresa descripcion, condiciones, categoria
 * y la duracion en horas de la subasta.
 */
public class CrearSubasta extends JPanel {
 
    private static final long serialVersionUID = 1L;
 
    // --------------------------------------------------
    // CAMPOS DE TEXTO
    // --------------------------------------------------
 
    private JTextField txtDescripcion;
    private JTextField txtCondiciones;
    private JTextField txtHoras;
 
    // --------------------------------------------------
    // COMBO DE CATEGORIAS
    // --------------------------------------------------
 
    private JComboBox<Categoria> comboCategoria;
 
    // --------------------------------------------------
    // CONSTRUCTOR
    // --------------------------------------------------
 
    public CrearSubasta(
            Principal ventana,
            UsuarioNormal usuario) {
 
        setLayout(null);
 
        // --------------------------------------------------
        // TITULO
        // --------------------------------------------------
 
        JLabel lblTitulo =
                new JLabel("Nueva Subasta");
 
        lblTitulo.setBounds(
                380,
                30,
                200,
                30);
 
        add(lblTitulo);
 
        // --------------------------------------------------
        // DESCRIPCION
        // --------------------------------------------------
 
        JLabel lblDescripcion =
                new JLabel("Descripción del objeto:");
 
        lblDescripcion.setBounds(
                100,
                100,
                180,
                25);
 
        add(lblDescripcion);
 
        txtDescripcion = new JTextField();
 
        txtDescripcion.setBounds(
                290,
                100,
                380,
                25);
 
        add(txtDescripcion);
 
        // --------------------------------------------------
        // CONDICIONES
        // --------------------------------------------------
 
        JLabel lblCondiciones =
                new JLabel("Condiciones:");
 
        lblCondiciones.setBounds(
                100,
                160,
                180,
                25);
 
        add(lblCondiciones);
 
        txtCondiciones = new JTextField();
 
        txtCondiciones.setBounds(
                290,
                160,
                380,
                25);
 
        add(txtCondiciones);
 
        // --------------------------------------------------
        // CATEGORIA
        // --------------------------------------------------
 
        JLabel lblCategoria =
                new JLabel("Categoría:");
 
        lblCategoria.setBounds(
                100,
                220,
                180,
                25);
 
        add(lblCategoria);
 
        comboCategoria =
                new JComboBox<>(Categoria.values());
 
        comboCategoria.setBounds(
                290,
                220,
                200,
                25);
 
        add(comboCategoria);
 
        // --------------------------------------------------
        // DURACION EN HORAS
        // --------------------------------------------------
 
        JLabel lblHoras =
                new JLabel("Duración (horas):");
 
        lblHoras.setBounds(
                100,
                280,
                180,
                25);
 
        add(lblHoras);
 
        txtHoras = new JTextField("24");
 
        txtHoras.setBounds(
                290,
                280,
                100,
                25);
 
        add(txtHoras);
 
        // --------------------------------------------------
        // BOTON GUARDAR
        // --------------------------------------------------
 
        JButton btnGuardar =
                new JButton("Publicar Subasta");
 
        btnGuardar.setBounds(
                200,
                380,
                180,
                35);
 
        add(btnGuardar);
 
        // --------------------------------------------------
        // BOTON VOLVER
        // --------------------------------------------------
 
        JButton btnVolver =
                new JButton("Cancelar");
 
        btnVolver.setBounds(
                430,
                380,
                150,
                35);
 
        add(btnVolver);
 
        // --------------------------------------------------
        // EVENTO GUARDAR
        // --------------------------------------------------
 
        btnGuardar.addActionListener(
        new ActionListener() {
 
            public void actionPerformed(
                    ActionEvent e) {
 
                try {
 
                    String descripcion =
                            txtDescripcion.getText().trim();
 
                    String condiciones =
                            txtCondiciones.getText().trim();
 
                    String horasTexto =
                            txtHoras.getText().trim();
 
                    // Validar que no haya campos vacios
                    if (descripcion.isEmpty()
                            || condiciones.isEmpty()
                            || horasTexto.isEmpty()) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "Complete todos los campos.");
 
                        return;
                    }
 
                    // Validar que las horas sean un numero valido
                    int horas;
 
                    try {
                        horas = Integer.parseInt(horasTexto);
 
                        if (horas <= 0) {
                            throw new NumberFormatException();
                        }
 
                    } catch (NumberFormatException ex) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "Ingrese un numero de horas valido (mayor a 0).");
 
                        return;
                    }
 
                    Categoria categoria =
                            (Categoria) comboCategoria.getSelectedItem();
 
                    // Crear el objeto que se va a subastar
                    Objeto objeto =
                            new Objeto(
                                    descripcion,
                                    condiciones,
                                    categoria);
 
                    // Calcular la fecha de cierre sumando las horas en milisegundos
                    long ahora = System.currentTimeMillis();
                    long cierreMs = ahora + (horas * 3600L * 1000L);
 
                    TiempoGeolocalizado fechaInicio =
                            new TiempoGeolocalizado(
                                    usuario.getUbicacion()
                                    .getUbicacionAproximada());
 
                    TiempoGeolocalizado fechaCierre =
                            new TiempoGeolocalizado(
                                    usuario.getUbicacion()
                                    .getUbicacionAproximada());
 
                    // Ajustar el timestamp de cierre manualmente
                    fechaCierre.setCoordenadas(0, cierreMs);
 
                    // Crear la subasta
                    SubastaTiempoLimitado subasta = new SubastaTiempoLimitado(usuario, objeto, fechaInicio, cierreMs);
 
                    // Agregar al usuario y guardar
                    usuario.agregarPublicacion(subasta);
 
                    Sistema.gestionUsuarios.guardarTodo();
 
                    JOptionPane.showMessageDialog(
                            null,
                            "Subasta publicada correctamente.\n"
                            + "Cierra en " + horas + " hora(s).");
 
                    ventana.setContentPane(
                            new Menu(ventana, usuario));
 
                    ventana.revalidate();
                    ventana.repaint();
 
                } catch (Exception ex) {
 
                    ex.printStackTrace();
 
                    JOptionPane.showMessageDialog(
                            null,
                            "Error al crear la subasta.");
                }
            }
        });
 
        // --------------------------------------------------
        // EVENTO VOLVER
        // --------------------------------------------------
 
        btnVolver.addActionListener(
        new ActionListener() {
 
            public void actionPerformed(
                    ActionEvent e) {
 
                ventana.setContentPane(
                        new Menu(ventana, usuario));
 
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }
}