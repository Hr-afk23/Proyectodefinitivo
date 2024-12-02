package ec.edu.uce.dominio;

import java.util.Date;
import java.util.List;

public class Préstamo {
    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private String garantia;
    private Usuario usuario;
    private double montoGarantía;


    // Constructor
    public Préstamo(int id, Date fechaInicio, Date fechaFin, String garantia, Usuario usuario, List<PrestamoItem> listaItems) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.garantia = garantia;
        this.usuario = usuario;
        this.montoGarantía =0;
    }
    // Constructor que toma un objeto Préstamo  
    public Préstamo(Préstamo otroPrestamo) {  
        this.id = otroPrestamo.id;  
        this.fechaInicio = otroPrestamo.fechaInicio != null ? new Date(otroPrestamo.fechaInicio.getTime()) : null; // Copia de Date  
        this.fechaFin = otroPrestamo.fechaFin != null ? new Date(otroPrestamo.fechaFin.getTime()) : null; // Copia de Date  
        this.garantia = otroPrestamo.garantia;  
        this.usuario = otroPrestamo.usuario;  
        this.Montogarantía = otroPrestamo.Montogarantía; // Copia del monto de garantía  
    }  
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarGarantía(double monto) {
        this.Montogarantía = monto; // Establece el monto de la Montogarantía
    }

    public void actualizarGarantía(double nuevoMonto) {
        this.Montogarantía = nuevoMonto; // Actualiza el monto de la Montogarantía
    }

    public String mostrarGarantía() {
        return "Garantía: " + Montogarantía; // Devuelve el monto de la Montogarantía
    }


    @Override
    public String toString() {
        return "Préstamo{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", garantia='" + garantia + '\'' +
                ", usuario=" + usuario +
                '}';

    }

    public void setEstado(String nuevoEstado) {
    }
}
