package ec.edu.uce.dominio;

public class Laboratorio {
    private String nombreLaboratorio;
    private String idLaboratorio;
    private String facultadQuePertenece;

    // Constructor
    public Laboratorio(String nombreLaboratorio, String idLaboratorio, String facultadQuePertenece) {
        this.nombreLaboratorio = nombreLaboratorio;
        this.idLaboratorio = idLaboratorio;
        this.facultadQuePertenece = facultadQuePertenece;
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

    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombreLaboratorio='" + nombreLaboratorio + '\'' +
                ", idLaboratorio='" + idLaboratorio + '\'' +
                ", facultadQuePertenece='" + facultadQuePertenece + '\'' +
                '}';
    }
}
