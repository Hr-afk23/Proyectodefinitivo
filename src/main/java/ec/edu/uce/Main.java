package ec.edu.uce;

import ec.edu.uce.consola.MenuPrincipal;
import ec.edu.uce.dominio.Docente;
import ec.edu.uce.dominio.Estudiante;
import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.dominio.Administrador;

import java.util.ArrayList;
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


        // Crear el scanner para el menú
        Scanner scanner = new Scanner(System.in);

        // Crear el objeto MenuPrincipal pasándole la lista de usuarios registrados
        MenuPrincipal menuPrincipal = new MenuPrincipal(usuariosRegistrados, scanner);

        // Mostrar el menú principal
        menuPrincipal.mostrarMenuPrincipal();
    }
}




