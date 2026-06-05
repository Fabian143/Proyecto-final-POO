package ggui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
import gestion.Sistema;
import kernel.Puja;
import kernel.SubastaTiempoLimitado;
import kernel.TiempoGeolocalizado;
 
/**
 * Pantalla de detalle de una subasta.
 * Muestra el objeto, el tiempo restante, la puja
 * mas alta actual y la tabla de todas las pujas.
 * Permite al usuario registrar una nueva puja.
 */
public class VerSubasta extends JPanel {
 
    private static final long serialVersionUID = 1L;
 
    // --------------------------------------------------
    // COMPONENTES
    // --------------------------------------------------
 
    private JTable tablaPujas;
    private JLabel lblPujaActual;
    private JTextField txtMiPuja;
 
    // --------------------------------------------------
    // CONSTRUCTOR
    // --------------------------------------------------
 
    public VerSubasta(
            Principal ventana,
            SubastaTiempoLimitado subasta) {
 
        setLayout(null);
 
        // --------------------------------------------------
        // TITULO
        // --------------------------------------------------
 
        JLabel lblTitulo =
                new JLabel("Subasta: "
                        + subasta.getObjeto().getDescripcion());
 
        lblTitulo.setBounds(
                50,
                20,
                700,
                30);
 
        add(lblTitulo);
 
        // --------------------------------------------------
        // DATOS DEL OBJETO
        // --------------------------------------------------
 
        JLabel lblCategoria =
                new JLabel("Categoría: "
                        + subasta.getObjeto().getCategoria());
 
        lblCategoria.setBounds(
                50,
                60,
                400,
                25);
 
        add(lblCategoria);
 
        JLabel lblCondiciones =
                new JLabel("Condiciones: "
                        + subasta.getObjeto().getCondiciones());
 
        lblCondiciones.setBounds(
                50,
                90,
                700,
                25);
 
        add(lblCondiciones);
 
        JLabel lblPropietario =
                new JLabel("Publicado por: "
                        + subasta.getPropietario().getNombre());
 
        lblPropietario.setBounds(
                50,
                120,
                400,
                25);
 
        add(lblPropietario);
 
        // --------------------------------------------------
        // TIEMPO RESTANTE
        // --------------------------------------------------
 
        long ahora = System.currentTimeMillis();
 
        // Se guardo el tiempo de cierre en la longitud del TiempoGeolocalizado
        long cierre = (long) subasta
                .getTiempoSubastaFinal()
                .getLongitudAproximada();
 
        String tiempoRestante;
 
        if (cierre == 0) {
 
            tiempoRestante = "Sin tiempo definido";
 
        } else if (ahora >= cierre) {
 
            tiempoRestante = "SUBASTA CERRADA";
 
        } else {
 
            long diffMs = cierre - ahora;
            long horas = diffMs / (3600 * 1000);
            long minutos = (diffMs % (3600 * 1000)) / 60000;
 
            tiempoRestante = horas + " h " + minutos + " min restantes";
        }
 
        JLabel lblTiempo =
                new JLabel("Tiempo restante: " + tiempoRestante);
 
        lblTiempo.setBounds(
                50,
                150,
                500,
                25);
 
        add(lblTiempo);
 
        // --------------------------------------------------
        // PUJA MAS ALTA
        // --------------------------------------------------
 
        Puja mayorPuja = subasta.obtenerMayorPuja();
 
        String textoPuja = mayorPuja == null
                ? "Sin pujas aun"
                : "$" + String.format("%.2f", mayorPuja.getValor())
                  + " — " + mayorPuja.getUsuarioqpuja().getNombre();
 
        lblPujaActual =
                new JLabel("Puja mas alta: " + textoPuja);
 
        lblPujaActual.setBounds(
                50,
                180,
                600,
                25);
 
        add(lblPujaActual);
 
        // --------------------------------------------------
        // TABLA DE PUJAS
        // --------------------------------------------------
 
        JScrollPane scroll = new JScrollPane();
 
        scroll.setBounds(
                50,
                220,
                880,
                200);
 
        add(scroll);
 
        tablaPujas = new JTable();
 
        scroll.setViewportView(tablaPujas);
 
        cargarTablaPujas(subasta);
 
        // --------------------------------------------------
        // CAMPO NUEVA PUJA
        // --------------------------------------------------
 
        JLabel lblNuevaPuja =
                new JLabel("Mi puja ($):");
 
        lblNuevaPuja.setBounds(
                50,
                445,
                100,
                25);
 
        add(lblNuevaPuja);
 
        txtMiPuja = new JTextField();
 
        txtMiPuja.setBounds(
                160,
                445,
                150,
                25);
 
        add(txtMiPuja);
 
        // --------------------------------------------------
        // BOTON PUJAR
        // --------------------------------------------------
 
        JButton btnPujar =
                new JButton("Registrar Puja");
 
        btnPujar.setBounds(
                330,
                440,
                160,
                35);
 
        add(btnPujar);
 
        // --------------------------------------------------
        // BOTON FINALIZAR SUBASTA (solo propietario)
        // --------------------------------------------------
 
        JButton btnFinalizar =
                new JButton("Finalizar Subasta");
 
        btnFinalizar.setBounds(
                510,
                440,
                180,
                35);
 
        // Solo el propietario puede ver este boton
        btnFinalizar.setVisible(
                subasta.getPropietario()
                == Sistema.usuarioActual);
 
        add(btnFinalizar);
 
        // --------------------------------------------------
        // BOTON VOLVER
        // --------------------------------------------------
 
        JButton btnVolver =
                new JButton("Volver");
 
        btnVolver.setBounds(
                710,
                440,
                120,
                35);
 
        add(btnVolver);
 
        // --------------------------------------------------
        // EVENTO PUJAR
        // --------------------------------------------------
 
        btnPujar.addActionListener(
        new ActionListener() {
 
            public void actionPerformed(
                    ActionEvent e) {
 
                try {
 
                    // No puede pujar el propio propietario
                    if (subasta.getPropietario()
                            == Sistema.usuarioActual) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "No puedes pujar en tu propia subasta.");
 
                        return;
                    }
 
                    // Verificar que la subasta siga abierta
                    long ahora = System.currentTimeMillis();
                    long cierre = (long) subasta
                            .getTiempoSubastaFinal()
                            .getLongitudAproximada();
 
                    if (cierre > 0 && ahora >= cierre) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "La subasta ya ha cerrado.");
 
                        return;
                    }
 
                    // Leer y validar el valor
                    String texto = txtMiPuja.getText().trim();
 
                    if (texto.isEmpty()) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "Ingrese un valor para su puja.");
 
                        return;
                    }
 
                    double valor = Double.parseDouble(texto);
 
                    if (valor <= 0) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "El valor de la puja debe ser mayor a 0.");
 
                        return;
                    }
 
                    // Verificar que supere la puja actual
                    Puja actual = subasta.obtenerMayorPuja();
 
                    if (actual != null && valor <= actual.getValor()) {
 
                        JOptionPane.showMessageDialog(
                                null,
                                "Tu puja debe superar la actual: $"
                                + String.format("%.2f", actual.getValor()));
 
                        return;
                    }
 
                    // Registrar la puja
                    Puja nuevaPuja =
                            new Puja(
                                    Sistema.usuarioActual,
                                    valor,
                                    new TiempoGeolocalizado());
 
                    subasta.agregarPuja(nuevaPuja);
 
                    Sistema.gestionUsuarios.guardarTodo();
 
                    // Actualizar etiqueta y tabla
                    lblPujaActual.setText(
                            "Puja mas alta: $"
                            + String.format("%.2f", valor)
                            + " — " + Sistema.usuarioActual.getNombre());
 
                    cargarTablaPujas(subasta);
 
                    txtMiPuja.setText("");
 
                    JOptionPane.showMessageDialog(
                            null,
                            "Puja registrada correctamente.");
 
                } catch (NumberFormatException ex) {
 
                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un numero valido.");
 
                } catch (Exception ex) {
 
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage());
                }
            }
        });
 
        // --------------------------------------------------
        // EVENTO FINALIZAR SUBASTA
        // --------------------------------------------------
 
        btnFinalizar.addActionListener(
        new ActionListener() {
 
            public void actionPerformed(
                    ActionEvent e) {
 
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas finalizar la subasta ahora?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION);
 
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
 
                subasta.finalizarSubasta();
 
                Sistema.gestionUsuarios.guardarTodo();
 
                Puja ganador = subasta.obtenerMayorPuja();
 
                String mensaje = ganador == null
                        ? "La subasta terminó sin pujas. Fue cancelada."
                        : "Subasta finalizada.\nGanador: "
                          + ganador.getUsuarioqpuja().getNombre()
                          + " con $" + String.format("%.2f", ganador.getValor());
 
                JOptionPane.showMessageDialog(null, mensaje);
 
                ventana.setContentPane(
                        new MisPublicaciones(
                                ventana,
                                Sistema.usuarioActual));
 
                ventana.revalidate();
                ventana.repaint();
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
                        new ExplorarPublicaciones(ventana));
 
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }
 
    // --------------------------------------------------
    // CARGAR TABLA DE PUJAS
    // --------------------------------------------------
 
    /**
     * Carga todas las pujas de la subasta en la tabla,
     * ordenadas de mayor a menor valor.
     */
    private void cargarTablaPujas(
            SubastaTiempoLimitado subasta) {
 
        DefaultTableModel modelo = new DefaultTableModel();
 
        modelo.addColumn("Usuario");
        modelo.addColumn("Valor ($)");
        modelo.addColumn("Fecha");
 
        // Ordenar pujas de mayor a menor
        subasta.getPujas().stream()
                .sorted((a, b) ->
                        Double.compare(b.getValor(), a.getValor()))
                .forEach(p -> modelo.addRow(
                        new Object[] {
                                p.getUsuarioqpuja().getNombre(),
                                String.format("%.2f", p.getValor()),
                                p.getT().getFechaFormato()
                        }));
 
        tablaPujas.setModel(modelo);
    }
}
