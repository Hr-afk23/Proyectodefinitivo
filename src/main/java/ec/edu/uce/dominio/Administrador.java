package ec.edu.uce.dominio;

public class Administrador extends Usuario {
    private String laboratorioDeTrabajo;

    // Constructor con 6 parámetros
    public Administrador(String id, String nombre, String apellido, String correo, String contraseña, String laboratorioDeTrabajo) {
        super(id, nombre, apellido, correo, contraseña);
        this.laboratorioDeTrabajo = laboratorioDeTrabajo;
    }

    // Getter y Setter
    public String getLaboratorioDeTrabajo() {
        return laboratorioDeTrabajo;
    }

    public void setLaboratorioDeTrabajo(String laboratorioDeTrabajo) {
        this.laboratorioDeTrabajo = laboratorioDeTrabajo;
    }

    @Override
    public String toString() {
        return super.toString() + ", laboratorioDeTrabajo='" + laboratorioDeTrabajo + '\'' + '}';
    }
}
