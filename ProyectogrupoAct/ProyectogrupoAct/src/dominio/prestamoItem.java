package dominio;

import java.util.Date;
public class prestamoItem {

    private String codigoItem;
    private String codigoUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;  // "Activo", "Devuelto", "Retrasado"

    // Constructor
    public prestamoItem(String codigoItem, String codigoUsuario, Date fechaPrestamo, Date fechaDevolucion, String estado) {
        this.codigoItem = codigoItem;
        this.codigoUsuario = codigoUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    // Getters y setters
    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        if (codigoItem == null || codigoItem.trim().isEmpty()) {
            System.out.println("El código del ítem no puede ser nulo o vacío.");
            return;
        }
        this.codigoItem = codigoItem;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        if (codigoUsuario == null || codigoUsuario.trim().isEmpty()) {
            System.out.println("El código del usuario no puede ser nulo o vacío.");
            return;
        }
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        if (fechaPrestamo == null) {
            System.out.println("La fecha de préstamo no puede ser nula.");
            return;
        }
        Date fechaActual = new Date();
        if (fechaPrestamo.after(fechaActual)) {
            System.out.println("La fecha de préstamo no puede ser posterior a la fecha actual.");
            return;
        }
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        if (fechaDevolucion == null) {
            System.out.println("La fecha de devolución no puede ser nula.");
            return;
        }
        Date fechaActual = new Date();
        if (fechaDevolucion.before(fechaActual)) {
            System.out.println("La fecha de devolución no puede ser anterior a la fecha actual.");
            return;
        }

        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            System.out.println("El estado no puede ser nulo o vacío.");
            return;
        }
        if (!estado.equalsIgnoreCase("Activo") && !estado.equalsIgnoreCase("Inactivo") && !estado.equalsIgnoreCase("Pendiente")) {
            System.out.println("El estado ingresado no es válido. Debe ser Activo, Inactivo o Pendiente.");
            return;
        }

        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Código Ítem: " + codigoItem + ", Usuario: " + codigoUsuario + ", Fecha Préstamo: " + fechaPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado: " + estado;
    }

}
