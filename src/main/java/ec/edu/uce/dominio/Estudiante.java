package ec.edu.uce.dominio;

public class Estudiante extends Usuario {
    private String carrera;

    // Constructor con 6 parámetros
    public Estudiante(String id, String nombre, String apellido, String correo, String contraseña, String carrera) {
        super(id, nombre, apellido, correo, contraseña);
        this.carrera = carrera;
    }

    // Getter y Setter
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() + ", carrera='" + carrera + '\'' + '}';
    }
}
