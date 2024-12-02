package ec.edu.uce.dominio;

public class Docente extends Usuario {
    private String departamento;

    // Constructor con 6 parámetros
    public Docente(String id, String nombre, String apellido, String correo, String contraseña, String departamento) {
        super(id, nombre, apellido, correo, contraseña);
        this.departamento = departamento;
    }
    // Constructor que toma objeto Usuario  
    public Docente(Usuario usuario, String departamento) {  
        super(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContraseña());  
        this.departamento = departamento;  
    }  
    
    // Getter y Setter
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    // Operación específica
    public void solicitarDepartamento() {
        System.out.println("Docente " + getNombre() + " ha solicitado un cambio al departamento: " + departamento);
    }
    @Override
    public String toString() {
        return super.toString() + ", departamento='" + departamento + '\'' + '}';
    }
}
