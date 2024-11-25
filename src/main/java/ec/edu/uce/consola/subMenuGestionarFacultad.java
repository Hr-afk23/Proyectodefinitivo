package ec.edu.uce.consola;

import ec.edu.uce.dominio.Facultad;
import ec.edu.uce.dominio.Universidad;
import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subMenuGestionarFacultad {
    private Universidad universidad;
    private Usuario usuarioActivo;
    private final Scanner scanner;
    private List<String> historialAcciones; // Lista para almacenar el registro de acciones

    public subMenuGestionarFacultad(Universidad universidad, Usuario usuarioActivo) {
        this.universidad = universidad;
        this.scanner = new Scanner(System.in);
        this.historialAcciones = new ArrayList<>();  // Inicializar la lista
        this.usuarioActivo = usuarioActivo;
    }

    public void mostrarSubMenu() {
        String opcion;
        do {
            System.out.println("\n--- Submenú Gestionar Facultades ---");
            System.out.println("1. Crear Facultad");
            System.out.println("2. Modificar Facultad");
            System.out.println("3. Eliminar Facultad");
            System.out.println("4. Generar Reporte");
            System.out.println("5. Buscar Facultad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> crearFacultad();
                case "2" -> modificarFacultad();
                case "3" -> eliminarFacultad();
                case "4" -> generarReporte();
                case "5" -> buscarFacultad();
                case "0" -> System.out.println("Saliendo del submenú...");
                default -> System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("0"));
    }

    private void crearFacultad() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }

        System.out.print("Ingrese el nombre de la facultad: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código de la facultad: ");
        String codigo = scanner.nextLine();
        if (!Validaciones.validarCodigoUnico(codigo, universidad.getFacultades())) {
            System.out.println("El código ya existe. Intente nuevamente.");
            return;
        }

        // Mostrar sedes disponibles
        System.out.println("Seleccione la sede disponible:");
        for (int i = 0; i < universidad.getSedes().size(); i++) {
            System.out.println((i + 1) + ". " + universidad.getSedes().get(i));
        }
        System.out.print("Seleccione una sede (1, 2, 3): ");
        int sedeSeleccionada = Integer.parseInt(scanner.nextLine()) - 1;

        if (sedeSeleccionada < 0 || sedeSeleccionada >= universidad.getSedes().size()) {
            System.out.println("Sede no válida. Intente nuevamente.");
            return;
        }

        String sede = universidad.getSedes().get(sedeSeleccionada);
        Facultad nuevaFacultad = new Facultad(nombre, codigo, sede);
        universidad.agregarFacultad(nuevaFacultad);
        registrarAccion("Crear", nuevaFacultad);  // Registrar la acción
    }

    private void modificarFacultad() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }

        System.out.print("Ingrese el nombre o código de la facultad a modificar: ");
        String busqueda = scanner.nextLine();
        Facultad facultad = Validaciones.buscarFacultad(busqueda, universidad.getFacultades());
        if (facultad == null) {
            System.out.println("Facultad no encontrada.");
            return;
        }

        System.out.print("Nuevo nombre (deje vacío para no modificar): ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nuevo código (deje vacío para no modificar): ");
        String nuevoCodigo = scanner.nextLine();

        // Mostrar las sedes disponibles
        System.out.println("Seleccione la nueva sede disponible:");
        for (int i = 0; i < universidad.getSedes().size(); i++) {
            System.out.println((i + 1) + ". " + universidad.getSedes().get(i));
        }
        System.out.print("Seleccione una sede (1, 2, 3): ");
        int sedeSeleccionada = Integer.parseInt(scanner.nextLine()) - 1;

        // Validar que la sede seleccionada sea válida
        if (sedeSeleccionada < 0 || sedeSeleccionada >= universidad.getSedes().size()) {
            System.out.println("Sede no válida. Intente nuevamente.");
            return;
        }

        // Asignar la nueva sede seleccionada
        String nuevaSede = universidad.getSedes().get(sedeSeleccionada);

        // Modificar los atributos de la facultad
        if (!nuevoNombre.isEmpty()) facultad.setNombreFacultad(nuevoNombre);
        if (!nuevoCodigo.isEmpty() && Validaciones.validarCodigoUnico(nuevoCodigo, universidad.getFacultades())) {
            facultad.setCodigoFacultad(nuevoCodigo);
        }
        facultad.setSede(nuevaSede);  // Establecer la nueva sede

        // Registrar la acción de modificación
        registrarAccion("Modificar", facultad);
    }


    private void eliminarFacultad() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }
        System.out.print("Ingrese el nombre o código de la facultad a eliminar: ");
        String busqueda = scanner.nextLine();
        Facultad facultad = Validaciones.buscarFacultad(busqueda, universidad.getFacultades());
        if (facultad == null) {
            System.out.println("Facultad no encontrada.");
            return;
        }
        universidad.eliminarFacultad(facultad);
        registrarAccion("Eliminar", facultad);  // Registrar la acción
    }

    private void generarReporte() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }
        if (historialAcciones.isEmpty()) {
            System.out.println("No se han registrado acciones.");
        } else {
            System.out.println("Reporte de acciones:");
            for (String accion : historialAcciones) {
                System.out.println(accion);  // Imprime las acciones almacenadas
            }
        }
    }

    private void buscarFacultad() {
        System.out.print("Ingrese el nombre o código de la facultad a buscar: ");
        String busqueda = scanner.nextLine();
        Facultad facultad = Validaciones.buscarFacultad(busqueda, universidad.getFacultades());
        if (facultad == null) {
            System.out.println("Facultad no encontrada.");
        } else {
            System.out.println(facultad);
        }
    }

    // Método para registrar las acciones realizadas por el usuario
    private void registrarAccion(String accion, Facultad facultad) {
        if (usuarioActivo != null) {
            // Obtener nombre y apellido del usuario activo
            String usuarioNombre = usuarioActivo.getNombre();
            String usuarioApellido = usuarioActivo.getApellido();

            // Crear el mensaje con la acción realizada
            String mensaje = String.format("Usuario: %s %s - Acción: %s - Facultad: %s",
                    usuarioNombre, usuarioApellido, accion, facultad.getNombreFacultad());

            // Almacenar la acción en la lista historialAcciones
            historialAcciones.add(mensaje);
        } else {
            System.out.println("Error: No hay un usuario activo.");
        }
    }
}
