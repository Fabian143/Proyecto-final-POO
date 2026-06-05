package ggui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import gestion.GestionReportes;
import gestion.Sistema;
import kernel.Categoria;

public class ReportesEstadisticas extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JTextArea areaReportes;
    private JTable tablaCategorias;

    public ReportesEstadisticas(Principal ventana) {
        setLayout(null);

        // TÍTULO
        JLabel lblTitulo = new JLabel("📊 Reportes y Estadísticas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(350, 20, 300, 30);
        add(lblTitulo);

        // ============================================
        // TABLA DE CATEGORÍAS MÁS ACTIVAS
        // ============================================
        
        JLabel lblCategorias = new JLabel("📁 Categorías más activas:");
        lblCategorias.setBounds(50, 70, 300, 25);
        add(lblCategorias);
        
        JScrollPane scrollCategorias = new JScrollPane();
        scrollCategorias.setBounds(50, 100, 400, 200);
        add(scrollCategorias);
        
        tablaCategorias = new JTable();
        scrollCategorias.setViewportView(tablaCategorias);
        cargarTablaCategorias();
        
        // ============================================
        // ÁREA DE REPORTES GENERALES
        // ============================================
        
        JLabel lblReportes = new JLabel("📈 Resumen general:");
        lblReportes.setBounds(500, 70, 300, 25);
        add(lblReportes);
        
        areaReportes = new JTextArea();
        areaReportes.setEditable(false);
        areaReportes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollReportes = new JScrollPane(areaReportes);
        scrollReportes.setBounds(500, 100, 450, 400);
        add(scrollReportes);
        
        cargarReportesGenerales();
        
        // ============================================
        // BOTONES
        // ============================================
        
        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(800, 520, 120, 35);
        add(btnVolver);
        
        // Botón Refrescar
        JButton btnRefrescar = new JButton("🔄 Refrescar");
        btnRefrescar.setBounds(650, 520, 120, 35);
        add(btnRefrescar);
        
        // ============================================
        // EVENTOS
        // ============================================
        
        btnRefrescar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTablaCategorias();
                cargarReportesGenerales();
            }
        });
        
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new Menu(ventana, Sistema.usuarioActual));
                ventana.revalidate();
                ventana.repaint();
            }
        });
    }
    
    private void cargarTablaCategorias() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Categoría");
        modelo.addColumn("Cantidad de publicaciones");
        
        Map<Categoria, Integer> categorias = GestionReportes.obtenerCategoriasMasActivas();
        
        // Ordenar por cantidad (mayor a menor)
        categorias.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> {
                modelo.addRow(new Object[]{
                    entry.getKey().getNombre(),
                    entry.getValue()
                });
            });
        
        tablaCategorias.setModel(modelo);
        
        // Ajustar ancho de columnas
        tablaCategorias.getColumnModel().getColumn(0).setPreferredWidth(150);
        tablaCategorias.getColumnModel().getColumn(1).setPreferredWidth(100);
    }
    
    private void cargarReportesGenerales() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("═══════════════════════════════════════════\n");
        sb.append("           📊 ESTADÍSTICAS GENERALES        \n");
        sb.append("═══════════════════════════════════════════\n\n");
        
        // Usuarios
        sb.append("👥 USUARIOS:\n");
        sb.append("   • Total usuarios registrados: ").append(GestionReportes.obtenerTotalUsuarios()).append("\n");
        sb.append("   • Usuario actual: ").append(Sistema.usuarioActual.getNombre()).append("\n\n");
        
        // Publicaciones
        sb.append("📦 PUBLICACIONES:\n");
        sb.append("   • Total publicaciones: ").append(GestionReportes.obtenerTotalPublicaciones()).append("\n");
        
        Categoria masActiva = GestionReportes.obtenerCategoriaMasActiva();
        if (masActiva != null) {
            sb.append("   • Categoría más activa: ").append(masActiva.getNombre()).append("\n");
        }
        sb.append("\n");
        
        // Transacciones
        sb.append("🔄 TRANSACCIONES:\n");
        sb.append("   • Transacciones completadas: ").append(GestionReportes.obtenerTotalTransaccionesCompletadas()).append("\n\n");
        
        // Satisfacción
        sb.append("⭐ CALIFICACIONES Y SATISFACCIÓN:\n");
        sb.append("   • Promedio de calificaciones: ").append(String.format("%.2f", GestionReportes.obtenerPromedioCalificaciones())).append("/5\n");
        sb.append("   • Tasa de satisfacción: ").append(String.format("%.1f", GestionReportes.obtenerTasaSatisfaccionGlobal())).append("%\n\n");
        
        // Intercambios por zona
        sb.append("🌍 INTERCAMBIOS POR ZONA:\n");
        Map<String, Integer> intercambiosPorZona = GestionReportes.obtenerIntercambiosPorZona();
        if (intercambiosPorZona.isEmpty()) {
            sb.append("   • No hay intercambios registrados aún\n");
        } else {
            intercambiosPorZona.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    sb.append("   • ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" intercambios\n");
                });
        }
        sb.append("\n");
        
        // Top usuarios por reputación
        sb.append("🏆 TOP USUARIOS POR REPUTACIÓN:\n");
        Map<String, Integer> topReputacion = GestionReportes.obtenerTopUsuariosPorReputacion();
        topReputacion.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(5)
            .forEach(entry -> {
                String estrellas = "";
                for (int i = 0; i < entry.getValue(); i++) estrellas += "⭐";
                sb.append("   • ").append(entry.getKey()).append(": ").append(entry.getValue()).append("/5 ").append(estrellas).append("\n");
            });
        
        areaReportes.setText(sb.toString());
    }
}
