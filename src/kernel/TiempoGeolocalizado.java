package kernel;

import java.io.Serializable;

public class TiempoGeolocalizado implements Serializable {
    
    private long timestamp;
    private String ubicacionAproximada;  // Zona/Barrio/Ciudad
    private double latitudAproximada;    // Coordenadas aproximadas
    private double longitudAproximada;

    // Constructor: Solo tiempo
    public TiempoGeolocalizado() {
        this.timestamp = System.currentTimeMillis();
        this.ubicacionAproximada = "No especificada";
        this.latitudAproximada = 0.0;
        this.longitudAproximada = 0.0;
    }

    // Constructor: Con ubicación (que el usuario proporciona)
    public TiempoGeolocalizado(String ubicacionAproximada) {
        this.timestamp = System.currentTimeMillis();
        this.ubicacionAproximada = ubicacionAproximada;
        this.latitudAproximada = 0.0;
        this.longitudAproximada = 0.0;
    }

    // Constructor: Con coordenadas aproximadas
    public TiempoGeolocalizado(String ubicacionAproximada, double latitud, double longitud) {
        this.timestamp = System.currentTimeMillis();
        this.ubicacionAproximada = ubicacionAproximada;
        this.latitudAproximada = latitud;
        this.longitudAproximada = longitud;
    }

    // Getters Tiempo
    public long getFecha() {
        return timestamp;
    }

    public long getFechaHora() {
        return timestamp;
    }

    public String getFechaFormato() {
        return new java.util.Date(timestamp).toString();
    }

    // Getters Geolocalización
    public String getUbicacionAproximada() {
        return ubicacionAproximada;
    }

    public double getLatitudAproximada() {
        return latitudAproximada;
    }

    public double getLongitudAproximada() {
        return longitudAproximada;
    }

    // Setters
    public void setUbicacionAproximada(String ubicacion) {
        this.ubicacionAproximada = ubicacion;
    }

    public void setCoordenadas(double latitud, double longitud) {
        this.latitudAproximada = latitud;
        this.longitudAproximada = longitud;
    }

    // Método: Calcular distancia aproximada entre dos ubicaciones (Fórmula Haversine)
    public double calcularDistancia(TiempoGeolocalizado otra) {
        if (otra == null) return -1;
        
        double lat1 = this.latitudAproximada;
        double lon1 = this.longitudAproximada;
        double lat2 = otra.latitudAproximada;
        double lon2 = otra.longitudAproximada;
        
        // Si no hay coordenadas, retorna -1
        if (lat1 == 0 && lon1 == 0 && lat2 == 0 && lon2 == 0) {
            return -1;
        }
        
        double R = 6371; // Radio de la Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return R * c; // Distancia en km
    }

    // Método: Verificar si está en la misma zona
    public boolean estaMismaZona(TiempoGeolocalizado otra) {
        if (otra == null) return false;
        return this.ubicacionAproximada.equalsIgnoreCase(otra.ubicacionAproximada);
    }

    @Override
    public String toString() {
        return String.format("TiempoGeolocalizado{fecha=%s, ubicación='%s', coords=(%.2f,%.2f)}",
                new java.util.Date(timestamp), ubicacionAproximada, 
                latitudAproximada, longitudAproximada);
    }
}
