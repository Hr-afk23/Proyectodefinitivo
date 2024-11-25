package ec.edu.uce.consola;

import ec.edu.uce.dominio.Facultad;
import ec.edu.uce.dominio.Laboratorio;
import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.util.Validaciones;

import java.util.List;
import java.util.Scanner;

public class subMenuGestionarLaboratorio {

    private List<Facultad> facultades;
    private Usuario usuarioActivo;
    private final Scanner scanner;

    public subMenuGestionarLaboratorio(List<Facultad> facultades, Usuario usuarioActivo) {
        this.facultades = facultades;
        this.usuarioActivo = usuarioActivo;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarSubMenuLaboratorio() {
        String opcion;
        do {
            System.out.println("\n--- Submenú Gestionar Laboratorios ---");
            System.out.println("1. Crear Laboratorio (Administrador)");
            System.out.println("2. Modificar Laboratorio (Administrador)");
            System.out.println("3. Eliminar Laboratorio (Administrador)");
            System.out.println("4. Buscar Laboratorio (Todos los usuarios)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> crearLaboratorio();
                case "2" -> modificarLaboratorio();
                case "3" -> eliminarLaboratorio();
                case "4" -> buscarLaboratorio();
                case "0" -> System.out.println("Saliendo del submenú...");
                default -> System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("0"));
    }

    private void crearLaboratorio() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }
        System.out.print("Ingrese el nombre del laboratorio: ");
        String nombreLaboratorio = scanner.nextLine();
        if (!Validaciones.validarNombreLaboratorio(nombreLaboratorio)) {
            System.out.println("Nombre no válido. Debe empezar con mayúscula y tener hasta 100 caracteres.");
            return;
        }

        System.out.print("Ingrese el ID del laboratorio: ");
        String idLaboratorio = scanner.nextLine();
        if (!Validaciones.validarIdLaboratorio(idLaboratorio)) {
            System.out.println("ID no válido. Debe ser un número de hasta 4 dígitos sin espacios.");
            return;
        }

        // Mostrar facultades disponibles
        System.out.println("Seleccione la facultad a la que pertenece el laboratorio:");
        for (int i = 0; i < facultades.size(); i++) {
            System.out.println((i + 1) + ". " + facultades.get(i).getNombreFacultad());
        }
        System.out.print("Seleccione una facultad (1, 2, ...): ");
        int seleccion = Integer.parseInt(scanner.nextLine()) - 1;

        if (seleccion < 0 || seleccion >= facultades.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Facultad facultadSeleccionada = facultades.get(seleccion);
        Laboratorio nuevoLaboratorio = new Laboratorio(nombreLaboratorio, idLaboratorio, facultadSeleccionada.getNombreFacultad());
        facultadSeleccionada.getLaboratorios().add(nuevoLaboratorio);

        System.out.println("Laboratorio creado exitosamente.");
    }

    private void modificarLaboratorio() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }
        System.out.print("Ingrese el nombre o ID del laboratorio a modificar: ");
        String busqueda = scanner.nextLine();
        Laboratorio laboratorio = buscarLaboratorioInterno(busqueda);

        if (laboratorio == null) {
            System.out.println("Laboratorio no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre del laboratorio (deje vacío para no modificar): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.isEmpty() && !Validaciones.validarNombreLaboratorio(nuevoNombre)) {
            System.out.println("Nombre no válido. Debe empezar con mayúscula y tener hasta 100 caracteres.");
            return;
        }

        System.out.print("Nuevo ID del laboratorio (deje vacío para no modificar): ");
        String nuevoId = scanner.nextLine();
        if (!nuevoId.isEmpty() && !Validaciones.validarIdLaboratorio(nuevoId)) {
            System.out.println("ID no válido. Debe ser un número de hasta 4 dígitos sin espacios.");
            return;
        }

        System.out.println("Seleccione la nueva facultad (deje vacío para no modificar):");
        for (int i = 0; i < facultades.size(); i++) {
            System.out.println((i + 1) + ". " + facultades.get(i).getNombreFacultad());
        }
        System.out.print("Seleccione una facultad (1, 2, ...) o presione Enter para no modificar: ");
        String seleccion = scanner.nextLine();

        if (!nuevoNombre.isEmpty()) laboratorio.setNombreLaboratorio(nuevoNombre);
        if (!nuevoId.isEmpty()) laboratorio.setIdLaboratorio(nuevoId);
        if (!seleccion.isEmpty()) {
            int indice = Integer.parseInt(seleccion) - 1;
            if (indice < 0 || indice >= facultades.size()) {
                System.out.println("Selección no válida.");
                return;
            }
            laboratorio.setFacultadQuePertenece(facultades.get(indice).getNombreFacultad());
        }

        System.out.println("Laboratorio modificado exitosamente.");
    }

    private void eliminarLaboratorio() {
        if (usuarioActivo == null) {
            System.out.println("No hay un usuario activo para modificar.");
            return;
        }
        System.out.print("Ingrese el nombre o ID del laboratorio a eliminar: ");
        String busqueda = scanner.nextLine();
        Laboratorio laboratorio = buscarLaboratorioInterno(busqueda);

        if (laboratorio == null) {
            System.out.println("Laboratorio no encontrado.");
            return;
        }

        Facultad facultad = facultades.stream()
                .filter(f -> f.getLaboratorios().contains(laboratorio))
                .findFirst().orElse(null);

        if (facultad != null) {
            facultad.getLaboratorios().remove(laboratorio);
            System.out.println("Laboratorio eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el laboratorio.");
        }
    }

    private void buscarLaboratorio() {
        System.out.print("Ingrese el nombre o ID del laboratorio a buscar: ");
        String busqueda = scanner.nextLine();
        Laboratorio laboratorio = buscarLaboratorioInterno(busqueda);

        if (laboratorio == null) {
            System.out.println("Laboratorio no encontrado.");
        } else {
            System.out.println(laboratorio);
        }
    }

    private Laboratorio buscarLaboratorioInterno(String busqueda) {
        return facultades.stream()
                .flatMap(f -> f.getLaboratorios().stream())
                .filter(l -> l.getNombreLaboratorio().equalsIgnoreCase(busqueda) || l.getIdLaboratorio().equals(busqueda))
                .findFirst()
                .orElse(null);
    }
}
