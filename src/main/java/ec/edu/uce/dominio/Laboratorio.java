package ec.edu.uce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nombreLaboratorio;
    private String idLaboratorio;
    private String facultadQuePertenece;
    private List<Item> items; // Declaración de la lista de ítems
    private List<Préstamo> prestamos; // Declaración de la lista de préstamos
    // Constructor
    public Laboratorio(String nombreLaboratorio, String idLaboratorio, String facultadQuePertenece) {
        this.nombreLaboratorio = nombreLaboratorio;
        this.idLaboratorio = idLaboratorio;
        this.facultadQuePertenece = facultadQuePertenece;
        this.items = new ArrayList<>(); // Inicialización de la lista de ítems
        this.prestamos = new ArrayList<>(); // Inicialización de la lista de préstamos
    }

    // Getters y Setters
    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getFacultadQuePertenece() {
        return facultadQuePertenece;
    }

    public void setFacultadQuePertenece(String facultadQuePertenece) {
        this.facultadQuePertenece = facultadQuePertenece;
    }
    public List<Item> getItems() {
        return items;
    }

    public List<Préstamo> getPrestamos() {
        return prestamos;
    }
    // Operaciones
    public void agregarItem(Item item) {
        items.add(item);
        System.out.println("Item agregado: " + item.getCodigo());
    }

    public void registrarPrestamo(Préstamo prestamo) {
        prestamos.add(prestamo);
        System.out.println("Préstamo registrado.");
    }
    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombreLaboratorio='" + nombreLaboratorio + '\'' +
                ", idLaboratorio='" + idLaboratorio + '\'' +
                ", facultadQuePertenece='" + facultadQuePertenece + '\'' +
                ", items=" + items.size() +
                ", prestamos=" + prestamos.size() +
                '}';
    }
    }

