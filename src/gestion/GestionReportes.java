package gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kernel.Categoria;
import kernel.Publicacion;
import kernel.Reseña;
import kernel.Transaccion;
import kernel.UsuarioNormal;

public class GestionReportes {

    
    // 1. CATEGORÍAS MÁS ACTIVAS
   
    
    public static Map<Categoria, Integer> obtenerCategoriasMasActivas() {
        Map<Categoria, Integer> contador = new HashMap<>();
        
        // Inicializar contador para todas las categorías
        for (Categoria cat : Categoria.values()) {
            contador.put(cat, 0);
        }
        
        // Contar publicaciones por categoría
        for (Publicacion p : Sistema.gestionPublicaciones.obtenerTodas()) {
            Categoria cat = p.getObjeto().getCategoria();
            contador.put(cat, contador.get(cat) + 1);
        }
        
        return contador;
    }
    
    public static Categoria obtenerCategoriaMasActiva() {
        Map<Categoria, Integer> categorias = obtenerCategoriasMasActivas();
        Categoria masActiva = null;
        int max = 0;
        
        for (Map.Entry<Categoria, Integer> entry : categorias.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                masActiva = entry.getKey();
            }
        }
        
        return masActiva;
    }
    
   
    // 2. INTERCAMBIOS POR ZONA (CIUDAD)
  
    
    public static Map<String, Integer> obtenerIntercambiosPorZona() {
        Map<String, Integer> intercambiosPorCiudad = new HashMap<>();
        
        for (UsuarioNormal usuario : Sistema.gestionUsuarios.getUsuarios()) {
            String ciudad = usuario.getUbicacion().getUbicacionAproximada();
            int transaccionesCompletadas = 0;
            
            for (Transaccion t : usuario.getTransacciones()) {
                if (t.getEstadoActual() == kernel.EstadoTransaccion.COMPLETADA) {
                    transaccionesCompletadas++;
                }
            }
            
            if (transaccionesCompletadas > 0) {
                intercambiosPorCiudad.put(ciudad, 
                    intercambiosPorCiudad.getOrDefault(ciudad, 0) + transaccionesCompletadas);
            }
        }
        
        return intercambiosPorCiudad;
    }
    
 
    // 3. TASA DE SATISFACCIÓN
  
    
    public static double obtenerTasaSatisfaccionGlobal() {
        double sumaCalificaciones = 0;
        int totalCalificaciones = 0;
        
        for (UsuarioNormal usuario : Sistema.gestionUsuarios.getUsuarios()) {
            for (Reseña r : usuario.getReseñasComoVendedor()) {
                sumaCalificaciones += r.getCalificacion();
                totalCalificaciones++;
            }
            for (Reseña r : usuario.getReseñasComoCliente()) {
                sumaCalificaciones += r.getCalificacion();
                totalCalificaciones++;
            }
        }
        
        if (totalCalificaciones == 0) return 0;
        
        // Convertir a porcentaje (calificación sobre 5)
        return (sumaCalificaciones / (totalCalificaciones * 5)) * 100;
    }
    
    public static double obtenerPromedioCalificaciones() {
        double sumaCalificaciones = 0;
        int totalCalificaciones = 0;
        
        for (UsuarioNormal usuario : Sistema.gestionUsuarios.getUsuarios()) {
            for (Reseña r : usuario.getReseñasComoVendedor()) {
                sumaCalificaciones += r.getCalificacion();
                totalCalificaciones++;
            }
            for (Reseña r : usuario.getReseñasComoCliente()) {
                sumaCalificaciones += r.getCalificacion();
                totalCalificaciones++;
            }
        }
        
        if (totalCalificaciones == 0) return 0;
        return sumaCalificaciones / totalCalificaciones;
    }
    
   
    // 4. ESTADÍSTICAS ADICIONALES
    
    public static int obtenerTotalUsuarios() {
        return Sistema.gestionUsuarios.getUsuarios().size();
    }
    
    public static int obtenerTotalPublicaciones() {
        return Sistema.gestionPublicaciones.obtenerTodas().size();
    }
    
    public static int obtenerTotalTransaccionesCompletadas() {
        int total = 0;
        for (UsuarioNormal u : Sistema.gestionUsuarios.getUsuarios()) {
            for (Transaccion t : u.getTransacciones()) {
                if (t.getEstadoActual() == kernel.EstadoTransaccion.COMPLETADA) {
                    total++;
                }
            }
        }
        return total / 2; // Cada transacción está en dos usuarios
    }
    
    public static Map<String, Integer> obtenerTopUsuariosPorReputacion() {
        Map<String, Integer> top = new HashMap<>();
        
        for (UsuarioNormal u : Sistema.gestionUsuarios.getUsuarios()) {
            double promedio = (u.getPromedioReputacionVendedor() + u.getPromedioReputacionCliente()) / 2;
            int reputacionEntera = (int) Math.round(promedio);
            top.put(u.getNombre(), reputacionEntera);
        }
        
        return top;
    }
}