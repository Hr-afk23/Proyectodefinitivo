package ec.edu.uce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombreUniversidad;
    private String ubicacionUniversidad;
    private List<String> sedes;
    private List<Facultad> facultades;
   //constructor
    public Universidad(String nombreUniversidad, String ubicacionUniversidad, List<String> sedes,List<Facultad> facultades) {
        this.nombreUniversidad = nombreUniversidad;
        this.ubicacionUniversidad = ubicacionUniversidad;
        this.sedes = sedes;
        this.facultades = new ArrayList<>();
    }
    // Constructor que toma un objeto Universidad  
    public Universidad(Universidad otraUniversidad) {  
        this.nombreUniversidad = otraUniversidad.nombreUniversidad;  
        this.ubicacionUniversidad = otraUniversidad.ubicacionUniversidad;  
        this.sedes = new ArrayList<>(otraUniversidad.sedes); // C lista de sedes  
        this.facultades = new ArrayList<>(otraUniversidad.facultades); // C lista de facultades  
    }  
    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public String getUbicacionUniversidad() {
        return ubicacionUniversidad;
    }

    public List<String> getSedes() {
        return sedes;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void agregarFacultad(Facultad facultad) {
        facultades.add(facultad);
    }

    public void eliminarFacultad(Facultad facultad) {
        facultades.remove(facultad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Universidad{")
          .append("nombreUniversidad='").append(nombreUniversidad).append('\'')
          .append(", ubicacionUniversidad='").append(ubicacionUniversidad).append('\'')
          .append(", sedes=").append(sedes)
          .append(", facultades=").append(facultades)
          .append('}');
        return sb.toString();
    }

}
