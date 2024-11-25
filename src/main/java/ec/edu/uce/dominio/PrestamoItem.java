package ec.edu.uce.dominio;

public class PrestamoItem {
    private int cantidad;
    private String devolucion;
    private String reporte;

    // Constructor
    public PrestamoItem(int cantidad, String devolucion, String reporte) {
        this.cantidad = cantidad;
        this.devolucion = devolucion;
        this.reporte = reporte;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    // Métodos adicionales
    public void generarReporteDeDevolucion(String reporte) {
        this.reporte = reporte;
    }
    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
        System.out.println("Cantidad asignada: " + cantidad);
    }
    public void actualizarCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
        System.out.println("Cantidad actualizada a: " + nuevaCantidad);
    }
    public void modificarDevolucion(String nuevaDevolucion) {
        this.devolucion = nuevaDevolucion;
        System.out.println("Devolución modificada a: " + nuevaDevolucion);
    }
    public void eliminarDevolucion() {
        this.devolucion = null;
        System.out.println("Devolución eliminada.");
    }
    public void registrarDevolucion(String nuevaDevolucion) {
        this.devolucion = nuevaDevolucion;
        System.out.println("Devolución registrada: " + nuevaDevolucion);
    }
    public void crearDevolucion(String nuevaDevolucion) {
        registrarDevolucion(nuevaDevolucion);
    }
    public void consultarReporteDevolucion() {
        System.out.println("Reporte actual: " + reporte);
    }

    @Override
    public String toString() {
        return "PrestamoItem{" +
                "cantidad=" + cantidad +
                ", devolucion='" + devolucion + '\'' +
                ", reporte='" + reporte + '\'' +
                '}';
    }
}
