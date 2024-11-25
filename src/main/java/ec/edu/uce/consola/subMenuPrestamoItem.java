package ec.edu.uce.consola;

import ec.edu.uce.dominio.Item;
import ec.edu.uce.dominio.Préstamo;
import ec.edu.uce.dominio.PrestamoItem;
import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.util.Validaciones;

import java.util.*;

public class subMenuPrestamoItem {
    private static List<Usuario> usuarios;
    private static List<Item> items;
    private static List<Préstamo> prestamos;

    public subMenuPrestamoItem(List<Usuario> usuarios, List<Item> items, List<Préstamo> prestamos) {
        this.usuarios = usuarios;
        this.items = items;
        this.prestamos = prestamos;
    }

    public static void mostrarMenuPrestamo() {
        System.out.println("Mostrando menú de préstamos...");
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        do {
            System.out.println("\n=== GESTIÓN DE PRÉSTAMOS DE ÍTEMS ===");
            System.out.println("1. Crear préstamo");
            System.out.println("2. Consultar préstamo");
            System.out.println("3. Modificar préstamo");
            System.out.println("4. Eliminar préstamo");
            System.out.println("5. Generar reporte de préstamos");
            System.out.println("6. Regresar al menú principal");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    crearPrestamo(scanner);
                    break;
                case "2":
                    consultarPrestamo(scanner);
                    break;
                case "3":
                    modificarPrestamo(scanner);
                    break;
                case "4":
                    eliminarPrestamo(scanner);
                    break;
                case "5":
                    generarReporte();
                    break;
                case "6":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (!salir);
    }

    private static void crearPrestamo(Scanner scanner) {
        System.out.println("\n=== CREAR PRÉSTAMO ===");

        // Validar usuario
        System.out.print("Ingrese el ID del usuario que realiza el préstamo: ");
        String idUsuario = scanner.nextLine();

        if (!Validaciones.esCadenaValida(idUsuario)) {
            System.out.println("El ID no puede estar vacio , intente nuevamente.");
            return;
        }

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getId().equals(idUsuario))
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            System.out.println("Usuario no encontrado. Intente nuevamente.");
            return;
        }

        // Validar ítem
        System.out.print("Ingrese el código del ítem a prestar: ");
        String codigoItem = scanner.nextLine();

        if (!Validaciones.esCadenaValida(codigoItem)) {
            System.out.println("El código del ítem no puede estar vacío.");
            return;
        }

        Item item = items.stream()
                .filter(i -> i.getCodigo().equals(codigoItem) && i.getEstado().equalsIgnoreCase("disponible"))
                .findFirst()
                .orElse(null);

        if (item == null) {
            System.out.println("Ítem no encontrado o no disponible. Intente nuevamente.");
            return;
        }

        // Validar cantidad
        System.out.print("Ingrese la cantidad de ítems a prestar: ");
        String cantidadTexto = scanner.nextLine();

        if (!Validaciones.esNumerico(cantidadTexto)) {
            System.out.println("La cantidad debe ser un número. Intente nuevamente.");
            return;
        }

        int cantidad = Integer.parseInt(cantidadTexto);

        if (cantidad <= 0 || cantidad > item.getCantidadDisponible()) {
            System.out.println("Cantidad no válida. Verifique la disponibilidad del ítem.");
            return;
        }

        // Creación del préstamo
        Date fechaInicio = new Date(); // Fecha actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Plazo de 7 días por defecto
        Date fechaFin = calendar.getTime();

        PrestamoItem prestamoItem = new PrestamoItem(cantidad, "Pendiente", "");
        List<PrestamoItem> listaItems = new ArrayList<>();
        listaItems.add(prestamoItem);

        Préstamo prestamo = new Préstamo(prestamos.size() + 1, fechaInicio, fechaFin, "Sin garantía", usuario, listaItems);
        prestamos.add(prestamo);

        // Cambiar estado del ítem
        item.setEstado("prestado");

        System.out.println("Préstamo creado exitosamente:");
        System.out.println(prestamo);
    }

    private static void consultarPrestamo(Scanner scanner) {
        System.out.print("Ingrese el ID del préstamo a consultar: ");
        String idTexto = scanner.nextLine();

        if (!Validaciones.esNumerico(idTexto)) {
            System.out.println("El ID debe ser numérico.");
            return;
        }

        int idPrestamo = Integer.parseInt(idTexto);

        Préstamo prestamo = prestamos.stream()
                .filter(p -> p.getId() == idPrestamo)
                .findFirst()
                .orElse(null);

        if (prestamo != null) {
            System.out.println("Detalles del préstamo: " + prestamo);
        } else {
            System.out.println("Préstamo no encontrado.");
        }
    }

    private static void modificarPrestamo(Scanner scanner) {
        System.out.print("Ingrese el ID del préstamo a modificar: ");
        String idTexto = scanner.nextLine();

        if (!Validaciones.esNumerico(idTexto)) {
            System.out.println("El ID debe ser numérico.");
            return;
        }

        int idPrestamo = Integer.parseInt(idTexto);

        Préstamo prestamo = prestamos.stream()
                .filter(p -> p.getId() == idPrestamo)
                .findFirst()
                .orElse(null);

        if (prestamo == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo estado del préstamo (Pendiente/Completado): ");
        String nuevoEstado = scanner.nextLine();

        if (!Validaciones.esCadenaValida(nuevoEstado) ||
                (!nuevoEstado.equalsIgnoreCase("Pendiente") && !nuevoEstado.equalsIgnoreCase("Completado"))) {
            System.out.println("Estado inválido.");
            return;
        }

        prestamo.setEstado(nuevoEstado);
        System.out.println("Préstamo actualizado exitosamente.");
    }

    private static void eliminarPrestamo(Scanner scanner) {
        System.out.print("Ingrese el ID del préstamo a eliminar: ");
        String idTexto = scanner.nextLine();

        if (!Validaciones.esNumerico(idTexto)) {
            System.out.println("El ID debe ser numérico.");
            return;
        }

        int idPrestamo = Integer.parseInt(idTexto);

        Préstamo prestamo = prestamos.stream()
                .filter(p -> p.getId() == idPrestamo)
                .findFirst()
                .orElse(null);

        if (prestamo == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        prestamos.remove(prestamo);
        System.out.println("Préstamo eliminado exitosamente.");
    }

    private static void generarReporte() {
        System.out.println("\n=== REPORTE DE PRÉSTAMOS ===");
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            prestamos.forEach(System.out::println);
        }
    }
}
