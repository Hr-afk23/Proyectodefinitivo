package ec.edu.uce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombreFacultad;
    private String codigoFacultad;
    private String sedeFacultad;
    private List<Laboratorio> laboratorios=new ArrayList<>();
    private List<Facultad> facultades;


    public Facultad(String nombreFacultad, String codigoFacultad, String sedeFacultad) {
        this.nombreFacultad = nombreFacultad;
        this.codigoFacultad = codigoFacultad;
        this.sedeFacultad = sedeFacultad;
        this.laboratorios = laboratorios;
        this.facultades = facultades;
        
        
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
    //Laboratorios
    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }
    public void agregarLaboratorio(Laboratorio laboratorio) {
        laboratorios.add(laboratorio);
    }

    public void eliminarLaboratorio(Laboratorio laboratorio) {
        laboratorios.remove(laboratorio);
    }
    
    
    
    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
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
