package ec.edu.uce.dominio;

public class Estudiante extends Usuario {
    private String carrera;

    // Constructor con 6 parámetros
    public Estudiante(String id, String nombre, String apellido, String correo, String contraseña, String carrera) {
        super(id, nombre, apellido, correo, contraseña);
        this.carrera = carrera;
    }
     // Constructor que toma un objeto Usuario  
    public Estudiante(Usuario usuario, String carrera) {  
        super(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContraseña());  
        this.carrera = carrera;  
    }  

    // Getter y Setter
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    // Operación específica
    public void solicitarPrestamo() {
        System.out.println("Estudiante " + getNombre() + " ha solicitado un préstamo para la carrera: " + carrera);
    }
    @Override
    public String toString() {
        return super.toString() + ", carrera='" + carrera + '\'' + '}';
    }
}
