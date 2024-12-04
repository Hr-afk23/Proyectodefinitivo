package dominio;

import java.util.Date;

public class Prestamo {
    private String codigoPrestamo;
    private double montoGarantia;
    private Date fechaRegistro;
    private Date fechaDevolucion;
    private String estadoItem;  // "dañado" o "en buen estado"
    private double montoCobro;  // Cobro por daño si aplica
    private String nombreUsuario;

    // Composición: un préstamo tiene muchos ítems
    private prestamoItem[] items;  // Arreglo de prestamoItem
    private int itemscont; // Contador de ítems

    // Constructor
    public Prestamo(String codigoPrestamo, double montoGarantia, Date fechaRegistro, String estado) {
        this.montoGarantia = montoGarantia;
        this.fechaRegistro = fechaRegistro;
        this.codigoPrestamo = codigoPrestamo;
        this.estadoItem = estadoItem;
        this.nombreUsuario = nombreUsuario;
        this.fechaDevolucion = fechaDevolucion;
        this.montoCobro = montoCobro;
        this.items = new prestamoItem[10]; //  hasta 10 ítems
        this.itemscont = 0;
    }

    //metodo para agregar prestamo item
    public void agregarItem(String codigoItem, String codigoUsuario, Date fechaPrestamo, Date fechaDevolucion, String estado) {
        prestamoItem item = new prestamoItem(codigoItem, codigoUsuario, fechaPrestamo, fechaDevolucion, estado);
        if (itemscont < items.length) {
            items[itemscont++] = item; // Agregar el ítem
        } else {
            System.out.println("No se pueden agregar más ítems al préstamo.");
        }
    }

    //metodo para eliminar un prestamoItem
    public void eliminarItem(String codigoItem) {
        for (int i = 0; i < itemscont; i++) {
            if (items[i].getCodigoItem().equals(codigoItem)) {
                // Eliminar el ítem moviendo los elementos restantes
                for (int j = i; j < itemscont - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--itemscont] = null;
                break;
            }
        }
    }

    // Getters y setters
    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        if (estadoItem == null || (!estadoItem.equalsIgnoreCase("Bueno")
                && !estadoItem.equalsIgnoreCase("Regular")
                && !estadoItem.equalsIgnoreCase("Malo"))) {
            System.out.println("Estado inválido. Debe ser 'Bueno', 'Regular' o 'Malo'.");
            return;
        }
        this.estadoItem = estadoItem;
    }

    public double getMontoCobro() {
        return montoCobro;
    }

    public void setMontoCobro(double montoCobro) {
        if (montoCobro < 0) {
            System.out.println("El monto de cobro no puede ser negativo.");
            return;
        }
        this.montoCobro = montoCobro;
    }

    public String getNombreUsuario(){ return nombreUsuario; }

    public Date getfechaDevolucion() { return fechaDevolucion;
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

    @Override
    public String toString() {
        return "Código Préstamo: " + codigoPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado del Ítem: " + estadoItem + ", Monto Cobro: " + montoCobro;
    }
}