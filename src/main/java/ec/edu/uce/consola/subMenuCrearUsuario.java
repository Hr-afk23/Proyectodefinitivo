package ec.edu.uce.consola;

import ec.edu.uce.dominio.*;
import ec.edu.uce.util.Validaciones;

import java.util.List;
import java.util.Scanner;

public class subMenuCrearUsuario {
    private final List<Usuario> usuariosRegistrados;

    public subMenuCrearUsuario(List<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        // Validación de nombre
        String nombre;
        do {
            System.out.println("Ingrese el nombre del usuario (Primera mayúscula, sin espacios, solo letras, máx. 45 caracteres):");
            nombre = scanner.nextLine();
            if (!Validaciones.validarNombreApellido(nombre)) {
                System.out.println("Nombre inválido. Intente nuevamente.");
            }
        } while (!Validaciones.validarNombreApellido(nombre));

        // Validación de apellido
        String apellido;
        do {
            System.out.println("Ingrese el apellido del usuario (Primera mayúscula, sin espacios, solo letras, máx. 45 caracteres):");
            apellido = scanner.nextLine();
            if (!Validaciones.validarNombreApellido(apellido)) {
                System.out.println("Apellido inválido. Intente nuevamente.");
            }
        } while (!Validaciones.validarNombreApellido(apellido));

        // Generar ID
        String id = nombre.substring(0, 2).toLowerCase() + apellido.substring(0, 3).toLowerCase();
        System.out.println("ID generado: " + id);

        // Validación de contraseña
        String contraseña;
        do {
            System.out.println("Ingrese la contraseña (1 mayúscula, 2 números, mínimo 6 caracteres):");
            contraseña = scanner.nextLine();
            if (!Validaciones.validarContraseña(contraseña)) {
                System.out.println("Contraseña inválida. Intente nuevamente.");
            }
        } while (!Validaciones.validarContraseña(contraseña));

        // Selección de tipo de usuario
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Docente");
        System.out.println("2. Estudiante");
        System.out.println("3. Administrador de Laboratorio");
        String tipo;
        do {
            tipo = scanner.nextLine();
            if (!Validaciones.validarOpcionMenu(tipo)) {
                System.out.println("Opción inválida. Por favor ingrese un número.");
            }
        } while (!Validaciones.validarOpcionMenu(tipo));

        switch (tipo) {
            case "1" -> registrarDocente(scanner, id, nombre, apellido, contraseña);
            case "2" -> registrarEstudiante(scanner, id, nombre, apellido, contraseña);
            case "3" -> registrarAdministrador(scanner, id, nombre, apellido, contraseña);
            default -> System.out.println("Opción no válida.");
        }
    }

    private void registrarDocente(Scanner scanner, String id, String nombre, String apellido, String contraseña) {
        String departamento;
        do {
            System.out.println("Ingrese el departamento del docente (Primera mayúscula, solo letras, máx. 100 caracteres):");
            departamento = scanner.nextLine();
            if (!Validaciones.validarTextoGeneral(departamento)) {
                System.out.println("Departamento inválido. Intente nuevamente.");
            }
        } while (!Validaciones.validarTextoGeneral(departamento));

        Docente docente = new Docente(id, nombre, apellido, id + "@uce.edu.ec", contraseña, departamento);
        usuariosRegistrados.add(docente);
        System.out.println("Docente registrado exitosamente.");
    }

    private void registrarEstudiante(Scanner scanner, String id, String nombre, String apellido, String contraseña) {
        String carrera;
        do {
            System.out.println("Ingrese la carrera del estudiante (Primera mayúscula, solo letras, máx. 100 caracteres):");
            carrera = scanner.nextLine();
            if (!Validaciones.validarTextoGeneral(carrera)) {
                System.out.println("Carrera inválida. Intente nuevamente.");
            }
        } while (!Validaciones.validarTextoGeneral(carrera));

        Estudiante estudiante = new Estudiante(id, nombre, apellido, id + "@uce.edu.ec", contraseña, carrera);
        usuariosRegistrados.add(estudiante);
        System.out.println("Estudiante registrado exitosamente.");
    }

    private void registrarAdministrador(Scanner scanner, String id, String nombre, String apellido, String contraseña) {
        String laboratorioDeTrabajo;
        do {
            System.out.println("Ingrese el laboratorio de trabajo del administrador (Primera mayúscula, solo letras, máx. 100 caracteres):");
            laboratorioDeTrabajo = scanner.nextLine();
            if (!Validaciones.validarTextoGeneral(laboratorioDeTrabajo)) {
                System.out.println("Laboratorio de trabajo inválido. Intente nuevamente.");
            }
        } while (!Validaciones.validarTextoGeneral(laboratorioDeTrabajo));

        Administrador Administrador = new Administrador(id, nombre, apellido, id + "@uce.edu.ec", contraseña, laboratorioDeTrabajo);
        usuariosRegistrados.add(Administrador);
        System.out.println("Administrador registrado exitosamente.");
    }
}
