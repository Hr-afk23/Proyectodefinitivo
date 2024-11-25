package ec.edu.uce.dominio;

public class Facultad {
    private String nombreFacultad;
    private String codigoFacultad;
    private String sedeFacultad;

    public Facultad(String nombreFacultad, String codigoFacultad, String sedeFacultad) {
        this.nombreFacultad = nombreFacultad;
        this.codigoFacultad = codigoFacultad;
        this.sedeFacultad = sedeFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(String codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getSede() {
        return sedeFacultad;
    }

    public void setSede(String sede) {
        this.sedeFacultad = sede;
    }

    @Override
    public String toString() {
        return "Facultad{" +
                "nombre='" + nombreFacultad + '\'' +
                ", código='" + codigoFacultad + '\'' +
                ", sede='" + sedeFacultad + '\'' +
                '}';
    }
}
