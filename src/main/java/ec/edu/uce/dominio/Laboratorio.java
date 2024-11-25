package ec.edu.uce.dominio;

public class Laboratorio {
    private String nombre;
    private Facultad facultad; // Facultad a la que pertenece

    public Laboratorio(String nombre, Facultad facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombre='" + nombre + '\'' +
                ", facultad=" + facultad.getNombreFacultad() +
                '}';
    }
}
