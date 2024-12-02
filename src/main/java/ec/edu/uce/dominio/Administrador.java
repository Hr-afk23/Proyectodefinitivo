package ec.edu.uce.dominio;

public class Administrador extends Usuario {
    private String laboratorioDeTrabajo;

    // Constructor con 6 parámetros
    public Administrador(String id, String nombre, String apellido, String correo, String contraseña, String laboratorioDeTrabajo) {
        super(id, nombre, apellido, correo, contraseña);
        this.laboratorioDeTrabajo = laboratorioDeTrabajo;
    }
     // Constructor que toma un objeto Usuario  
    public Administrador(Usuario usuario, String laboratorioDeTrabajo) {  
        super(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContraseña());  
        this.laboratorioDeTrabajo = laboratorioDeTrabajo;  
    }  

    // Getter y Setter
    public String getLaboratorioDeTrabajo() {
        return laboratorioDeTrabajo;
    }

    public void setLaboratorioDeTrabajo(String laboratorioDeTrabajo) {
        this.laboratorioDeTrabajo = laboratorioDeTrabajo;
    }
    // Operación específica
    public void solicitarLaboratorioDeTrabajo() {
        System.out.println("Administrador " + getNombre() + " ha solicitado información del laboratorio: " + laboratorioDeTrabajo);
    }
    @Override
    public String toString() {
        return super.toString() + ", laboratorioDeTrabajo='" + laboratorioDeTrabajo + '\'' + '}';
    }
}
