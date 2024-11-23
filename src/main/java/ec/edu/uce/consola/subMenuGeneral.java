package ec.edu.uce.consola;

import ec.edu.uce.dominio.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subMenuGeneral {

    private Usuario usuarioActivo;
    private List<Usuario> usuariosRegistrados;

    public subMenuGeneral(Usuario usuarioActivo, List<Usuario> usuariosRegistrados) {
        this.usuarioActivo = usuarioActivo;
        this.usuariosRegistrados = usuariosRegistrados;
    }


    public void mostrarSubMenu() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo. Por favor, inicie sesión primero.");
            return;
        }


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú General:");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Facultad");
            System.out.println("3. Gestionar Laboratorio");
            System.out.println("4. Gestionar Item");
            System.out.println("5. Gestionar Préstamo de Ítems");
            System.out.println("6. Gestionar Garantía del Préstamo");
            System.out.println("7. Gestionar Devolución de Ítems");
            System.out.println("8. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                    case "1" -> new subMenuGestionarUsuario(usuariosRegistrados, usuarioActivo).mostrarMenu();
                    case "2" -> System.out.println("Gestionar Facultad");
                    case "3" -> System.out.println("Gestionar Laboratorio");
                    case "4" -> System.out.println("Gestionar Item");
                    case "5" -> System.out.println("Gestionar Préstamo de Ítems");
                    case "6" -> System.out.println("Gestionar Garantía del Préstamo");
                    case "7" -> System.out.println("Gestionar Devolución de Ítems");
                    case "8" -> {
                    System.out.println("Cerrando sesión...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void gestionarUsuario() {
        subMenuGestionarUsuario subMenuGestionarUsuario = new subMenuGestionarUsuario(usuariosRegistrados, usuarioActivo);
        subMenuGestionarUsuario.mostrarMenu();
    }



    private void gestionarFacultad() {
        // Llamar a la clase de gestión de facultad
        System.out.println("Accediendo a Gestión de Facultad...");
        // Por ejemplo:
        // GestionarFacultad gestionarFacultad = new GestionarFacultad();
        // gestionarFacultad.mostrarOpciones();
    }

    private void gestionarLaboratorio() {
        System.out.println("Accediendo a Gestión de Laboratorio...");
        // Implementar o llamar a la clase correspondiente
    }

    private void gestionarItem() {
        System.out.println("Accediendo a Gestión de Items...");
        // Implementar o llamar a la clase correspondiente
    }

    private void gestionarPrestamoItems() {
        System.out.println("Accediendo a Gestión de Préstamos...");
        // Implementar o llamar a la clase correspondiente
    }

    private void gestionarGarantiaPrestamo() {
        System.out.println("Accediendo a Gestión de Garantía del Préstamo...");
        // Implementar o llamar a la clase correspondiente
    }

    private void gestionarDevolucionItems() {
        System.out.println("Accediendo a Gestión de Devolución de Ítems...");
        // Implementar o llamar a la clase correspondiente
    }
}

