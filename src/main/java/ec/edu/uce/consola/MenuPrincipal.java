package ec.edu.uce.consola;

import ec.edu.uce.dominio.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private List<Usuario> usuariosRegistrados;
    private Usuario usuarioActivo; // Usuario autenticado actualmente
    private Scanner scanner;
    private Universidad universidad;
    private List<Facultad> facultades;
    public MenuPrincipal(List<Usuario> usuariosRegistrados, Scanner scanner,Universidad universidad, List<Facultad> facultades) {
        this.usuariosRegistrados = usuariosRegistrados;
        this.universidad = universidad;
        this.scanner = scanner;
        this.facultades = facultades;
    }



    public void mostrarMenuPrincipal() {

        System.out.println("Bienvenido a la Plataforma de Gestión de Items");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrar Usuario");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        switch (opcion) {
            case 1 -> iniciarSesion();
            case 2 -> registrarUsuario();
            case 3 -> {
                System.out.println("Gracias por usar la plataforma. ¡Hasta luego!");
                System.exit(0);
            }
            default -> {
                System.out.println("Opción no válida.");
                mostrarMenuPrincipal(); //Mostrar menu nuevamente
            }
        }
    }

    private void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine().trim();

        boolean encontrado = false;
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getId().equals(id) && usuario.getContraseña().equals(contraseña)) {
                usuarioActivo = usuario;
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Credenciales inválidas. Por favor, intente de nuevo.");
            mostrarMenuPrincipal();
        } else {
            subMenuGeneral subMenuGeneral = new subMenuGeneral(usuarioActivo, usuariosRegistrados,universidad,facultades);
            subMenuGeneral.mostrarSubMenu();
        }
    }


    private Usuario validarCredenciales(String id, String contraseña) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getId().equals(id) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    private void registrarUsuario() {
        subMenuCrearUsuario subMenuCrearUsuario = new subMenuCrearUsuario(usuariosRegistrados);
        subMenuCrearUsuario.mostrarMenu();
        mostrarMenuPrincipal(); // Volver al menú principal después de registrar un usuario
    }

    private void mostrarSubMenuPorUsuario(Usuario usuario) {
        subMenuGeneral subMenuGeneral = new subMenuGeneral(usuarioActivo, usuariosRegistrados,universidad,facultades);
        subMenuGeneral.mostrarSubMenu();

        if (usuario instanceof Docente) {
            System.out.println("Accediendo al menú para docentes...");
            subMenuGeneral.mostrarSubMenu();
        } else if (usuario instanceof Estudiante) {
            System.out.println("Accediendo al menú para estudiantes...");
            subMenuGeneral.mostrarSubMenu();
        } else if (usuario instanceof Administrador) {
            System.out.println("Accediendo al menú para administradores de laboratorio...");
            subMenuGeneral.mostrarSubMenu();
        }

    }
}
