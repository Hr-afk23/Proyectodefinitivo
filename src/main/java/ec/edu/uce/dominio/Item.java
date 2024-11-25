package ec.edu.uce.dominio;

public class Item {
    private String codigo;
    private String estado; // Estado del ítem
    private int cantidadDisponible; // Cantidad de ítems disponibles para préstamo

    // Constructor
    public Item(String codigo, String estado, int cantidadDisponible) {
        this.codigo = codigo;
        this.estado = estado;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    // Métodos adicionales
    /**
     * Actualiza el estado del ítem.
     * @param nuevoEstado El nuevo estado del ítem.
     */
    public void actualizarEstado(String nuevoEstado) {
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        this.estado = nuevoEstado;
    }

    /**
     * Actualiza la cantidad disponible del ítem, asegurándose de que sea no negativa.
     * @param nuevaCantidad La nueva cantidad disponible.
     */
    public void actualizarCantidadDisponible(int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa.");
        }
        this.cantidadDisponible = nuevaCantidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}