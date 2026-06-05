package kernel;

import java.io.Serializable;
import java.util.ArrayList;

public class Objeto implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contadorId = 6000;
    protected int id;
    private String descripcion;
    private String condiciones;
    private Categoria categoria;
    private ArrayList<Integer> numerosFotos;
    private int totalFotos;

    public Objeto(String descripcion, String condiciones, Categoria categoria) {
        this.id = generarId();
        this.descripcion = descripcion;
        this.condiciones = condiciones;
        this.categoria = categoria;
        this.numerosFotos = new ArrayList<>();
        this.totalFotos = 0;
    }

    private static int generarId() {
        return contadorId++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public ArrayList<Integer> getNumerosFotos() {
        return numerosFotos;
    }

    public int getTotalFotos() {
        return totalFotos;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Métodos para gestionar fotos
    // Agregar foto: incrementa total y agrega número
    public void agregarFoto() {
        totalFotos++;
        numerosFotos.add(totalFotos);
    }

    // Remover foto por número específico
    public void removerFoto(int numeroFoto) {
        if (numerosFotos.contains(numeroFoto)) {
            numerosFotos.remove(Integer.valueOf(numeroFoto));
        }
    }

    // Obtener nombre de archivo para una foto
    public String getNombreArchivoFoto(int numeroFoto) {
        if (numerosFotos.contains(numeroFoto)) {
            return "objeto_" + this.id + "_foto" + numeroFoto + ".jpg";
        }
        return null;
    }

    // Obtener ruta completa de una foto
    public String getRutaFoto(int numeroFoto) {
        if (numerosFotos.contains(numeroFoto)) {
            return "fotos/" + getNombreArchivoFoto(numeroFoto);
        }
        return null;
    }

    // Verificar si existe una foto con ese número
    public boolean existeFoto(int numeroFoto) {
        return numerosFotos.contains(numeroFoto);
    }

    @Override
    public String toString() {
        return String.format("Objeto{id=%d, descripción='%s', categoría=%s, condición='%s', fotos=%d}",
                id, descripcion, categoria.getNombre(), condiciones, totalFotos);
    }
    
    
}
