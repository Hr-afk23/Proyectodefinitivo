package ec.edu.uce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombreUniversidad;
    private String ubicacionUniversidad;
    private List<String> sedes;
    private List<Facultad> facultades;

    public Universidad(String nombreUniversidad, String ubicacionUniversidad, List<String> sedes,List<Facultad> facultades) {
        this.nombreUniversidad = nombreUniversidad;
        this.ubicacionUniversidad = ubicacionUniversidad;
        this.sedes = sedes;
        this.facultades = facultades;
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
}
