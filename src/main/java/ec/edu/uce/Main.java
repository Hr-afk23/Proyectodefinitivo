package ec.edu.uce;

import ec.edu.uce.consola.MenuPrincipal;
import ec.edu.uce.dominio.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Crear lista de usuarios
        List<Usuario> usuariosRegistrados = new ArrayList<>();

        // Crear usuarios
        //Docentes
        Docente docente1 = new Docente("anmar","Ana Martinez","Martinez","anmar@uce.edu.ec","Martinez123","Arquitectura");
        //Estudiante
        Estudiante estudiante1 = new Estudiante("juanp", "Juan", "Perez", "juanp@uce.edu.ec", "Perez456", "Ingeniería");
        //Admin
        Administrador administrador1 = new Administrador("adminlab", "Carlos", "Gomez", "adminlab@uce.edu.ec", "admin123","Laboratorio de informatica");

        // Agregar usuarios a la lista
        usuariosRegistrados.add(docente1);
        usuariosRegistrados.add(estudiante1);
        usuariosRegistrados.add(administrador1);

// Datos de la universidad
        String nombreUniversidad = "Universidad Central del Ecuador";
        String ubicacionUniversidad = "Av.Universitaria";

        // Definir las sedes
        List<String> sedes = new ArrayList<>();
        sedes.add("Quito");
        sedes.add("Santo Domingo");
        sedes.add("Galapagos");

        // Crear las facultades, asignando una sede a cada una
        List<Facultad> facultades = new ArrayList<>();
        facultades.add(new Facultad("Artes", "100001", "Quito"));
        facultades.add(new Facultad("Ciencias", "100002", "Quito"));
        facultades.add(new Facultad("Ingenieria y ciencias aplicadas", "100003", "Quito"));
        facultades.add(new Facultad("Odontologia", "100004", "Quito"));
        // Agregar el resto de las facultades según corresponda

        // Crear la universidad
        Universidad universidad = new Universidad(nombreUniversidad, ubicacionUniversidad, sedes, facultades);

        //Crear los laboratorios
        List<Laboratorio> laboratorios = new ArrayList<>();
        //Crear lista de prestamos
        List<Préstamo> préstamos = new ArrayList<>();
        // Crear el scanner para el menú
        Scanner scanner = new Scanner(System.in);

        // Mostrar el menú principal
        // Crear el objeto MenuPrincipal pasándole la lista de usuarios registrados
        MenuPrincipal menuPrincipal = new MenuPrincipal(usuariosRegistrados, scanner,universidad,facultades,laboratorios,préstamos);

        menuPrincipal.mostrarMenuPrincipal();
    }
}




