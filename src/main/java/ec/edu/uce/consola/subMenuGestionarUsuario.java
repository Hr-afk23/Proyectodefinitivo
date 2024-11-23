package ec.edu.uce.consola;

import ec.edu.uce.dominio.*;
import ec.edu.uce.util.Validaciones;

import java.util.List;
import java.util.Scanner;

public class subMenuGestionarUsuario {
    private  List<Usuario> usuariosRegistrados;
    private  Usuario usuarioActivo;
    private Scanner scanner;

    public subMenuGestionarUsuario(List<Usuario> usuariosRegistrados, Usuario usuarioActivo) {
        this.usuariosRegistrados = usuariosRegistrados;
        this.usuarioActivo = usuarioActivo;
        this.scanner = new Scanner(System.in); // Inicializar el Scanner aquí

    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGestión de Usuarios:");
            System.out.println("1. Modificar Usuario");
            System.out.println("2. Eliminar Usuario");
            System.out.println("3. Buscar Usuario");
            System.out.println("4. Volver al Menú Anterior");

            String opcion;
            do {
                System.out.println("Seleccione una opción:");
                opcion = scanner.nextLine();
                if (!Validaciones.validarOpcionMenu(opcion)) {
                    System.out.println("Opción no válida. Por favor, ingrese un número.");
                }
            } while (!Validaciones.validarOpcionMenu(opcion));

            switch (opcion) {
                case "1" -> modificarUsuario();
                case "2" -> eliminarUsuario();
                case "3" -> buscarUsuario();
                case "4" -> {
                    return; // Volver al menú anterior
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void modificarUsuario() {
        Scanner scanner = new Scanner(System.in);

        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }

        System.out.println("Modificando al usuario activo: " + usuarioActivo.getNombre() + " " + usuarioActivo.getApellido());

        // Modificar atributos generales
        String nombre, apellido, contraseña;
        do {
            System.out.println("Ingrese el nuevo nombre (o presione Enter para mantener):");
            nombre = scanner.nextLine();
            if (!nombre.isEmpty() && !Validaciones.validarNombreApellido(nombre)) {
                System.out.println("Nombre inválido. Intente nuevamente.");
            }
        } while (!nombre.isEmpty() && !Validaciones.validarNombreApellido(nombre));

        do {
            System.out.println("Ingrese el nuevo apellido (o presione Enter para mantener):");
            apellido = scanner.nextLine();
            if (!apellido.isEmpty() && !Validaciones.validarNombreApellido(apellido)) {
                System.out.println("Apellido inválido. Intente nuevamente.");
            }
        } while (!apellido.isEmpty() && !Validaciones.validarNombreApellido(apellido));

        do {
            System.out.println("Ingrese la nueva contraseña (o presione Enter para mantener):");
            contraseña = scanner.nextLine();
            if (!contraseña.isEmpty() && !Validaciones.validarContraseña(contraseña)) {
                System.out.println("Contraseña inválida. Intente nuevamente.");
            }
        } while (!contraseña.isEmpty() && !Validaciones.validarContraseña(contraseña));

        // Actualizar datos
        if (!nombre.isEmpty()) usuarioActivo.setNombre(nombre);
        if (!apellido.isEmpty()) usuarioActivo.setApellido(apellido);
        if (!contraseña.isEmpty()) usuarioActivo.setContraseña(contraseña);

        // Modificar atributos específicos según el tipo de usuario
        if (usuarioActivo instanceof Docente docente) {
            System.out.println("Ingrese el nuevo departamento (o presione Enter para mantener):");
            String departamento = scanner.nextLine();
            if (!departamento.isEmpty() && Validaciones.validarTextoGeneral(departamento)) {
                docente.setDepartamento(departamento);
            }
        } else if (usuarioActivo instanceof Estudiante estudiante) {
            System.out.println("Ingrese la nueva carrera (o presione Enter para mantener):");
            String carrera = scanner.nextLine();
            if (!carrera.isEmpty() && Validaciones.validarTextoGeneral(carrera)) {
                estudiante.setCarrera(carrera);
            }
        } else if (usuarioActivo instanceof Administrador Administrador) {
            System.out.println("Ingrese el nuevo laboratorio de trabajo (o presione Enter para mantener):");
            String laboratorio = scanner.nextLine();
            if (!laboratorio.isEmpty() && Validaciones.validarTextoGeneral(laboratorio)) {
                Administrador.setLaboratorioDeTrabajo(laboratorio);
            }
        }

        System.out.println("Usuario modificado exitosamente.");
    }

    private void eliminarUsuario() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para eliminar.");
            return;
        }

        System.out.println("¿Está seguro de que desea eliminar su cuenta? (sí/no)");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("si")) {
            usuariosRegistrados.remove(usuarioActivo);
            System.out.println("Usuario eliminado correctamente.");
            usuarioActivo = null; // Resetear el usuario activo.

            // Regresar al MenuPrincipal
            MenuPrincipal menuPrincipal = new MenuPrincipal(usuariosRegistrados, scanner);

            menuPrincipal.mostrarMenuPrincipal();
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private void buscarUsuario() {
        Scanner scanner = new Scanner(System.in);

        if (!(usuarioActivo instanceof Administrador)) {
            System.out.println("Acceso denegado. Solo los administradores de laboratorio pueden buscar usuarios.");
            return;
        }

        System.out.println("Buscar usuario:");
        System.out.println("1. Por ID");
        System.out.println("2. Por Nombre");
        String opcion;
        do {
            opcion = scanner.nextLine();
            if (!Validaciones.validarOpcionMenu(opcion)) {
                System.out.println("Opción no válida. Por favor, ingrese un número.");
            }
        } while (!Validaciones.validarOpcionMenu(opcion));

        if (opcion.equals("1")) {
            System.out.println("Ingrese el ID del usuario:");
            String id = scanner.nextLine();
            usuariosRegistrados.stream()
                    .filter(u -> u.getId().equalsIgnoreCase(id))
                    .forEach(System.out::println);
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el nombre del usuario:");
            String nombre = scanner.nextLine();
            usuariosRegistrados.stream()
                    .filter(u -> u.getNombre().equalsIgnoreCase(nombre))
                    .forEach(System.out::println);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

