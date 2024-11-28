//CODIGO MODIFICADO
package ec.edu.uce.consola;

import ec.edu.uce.dominio.prestamoItem;
import ec.edu.uce.util.Validaciones;
import ec.edu.uce.dominio.Prestamo;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import java.text.SimpleDateFormat;

public class subMenuGestionarDevolucion {
    private static ArrayList<Prestamo> listaDevoluciones = new ArrayList<Prestamo>();
    private static ArrayList<prestamoItem> listaPrestamos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarDevolucion() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Devolución de Ítems ---");
            System.out.println("1. Crear devolución");
            System.out.println("2. Modificar devolución");
            System.out.println("3. Eliminar devolución");
            System.out.println("4. Registrar devolucion");
            System.out.println("5. Consultar reporte de devoluciones");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearDevolucion();
                    break;
                case 2:
                    modificarDevolucion();
                    break;
                case 3:
                    eliminarDevolucion();
                    break;
                case 4:
                    registrarDevolucion();
                    break;
                case 5:
                    generarReporteDevoluciones();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void crearDevolucion() {
        System.out.println("\n--- Crear Nueva Devolución ---");
        System.out.print("Ingrese el código del préstamo: ");
        String codigoPrestamo = scanner.nextLine();
        if (!Validaciones.validarExistenciaPrestamo(codigoPrestamo, listaPrestamos)) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
        String fechaDevolucionStr = scanner.nextLine();
        Date fechaDevolucion = new Date();  // Convertir la fecha desde el string ingresado

        System.out.print("Ingrese el estado del ítem (dañado/en buen estado): ");
        String estadoItem = scanner.nextLine();
        if (!Validaciones.validarEstadoItem(estadoItem)) {
            System.out.println("Estado no válido.");
            return;
        }

        double montoCobro = 0;
        if (estadoItem.equals("dañado")) {
            System.out.print("Ingrese el monto de cobro por daño: ");
            montoCobro = scanner.nextDouble();
            if (!Validaciones.validarMontoCobro(montoCobro)) {
                System.out.println("El monto de cobro debe ser mayor o igual a 0.");
                return;
            }
        }

        Prestamo devolucion = new Prestamo(codigoPrestamo, montoCobro, fechaDevolucion, estadoItem);
        listaDevoluciones.add(devolucion);
        System.out.println("Devolución registrada exitosamente.");
    }

    private static void modificarDevolucion() {
        System.out.print("\nIngrese el código del préstamo para modificar la devolución: ");
        String codigoPrestamo = scanner.nextLine();

        for (Prestamo devolucion : listaDevoluciones) {
            if (devolucion.getCodigoPrestamo().equals(codigoPrestamo)) {
                System.out.println("Devolución encontrada: " + devolucion);

                // Modificar atributos (estado, monto de cobro, etc.)
                System.out.print("Ingrese el nuevo estado del ítem: ");
                String estadoItem = scanner.nextLine();
                if (!Validaciones.validarEstadoItem(estadoItem)) {
                    System.out.println("Estado no válido.");
                    return;
                }

                devolucion.setEstadoItem(estadoItem);

                if (estadoItem.equals("dañado")) {
                    System.out.print("Ingrese el nuevo monto de cobro por daño: ");
                    double montoCobro = scanner.nextDouble();
                    if (!Validaciones.validarMontoCobro(montoCobro)) {
                        System.out.println("El monto de cobro debe ser mayor o igual a 0.");
                        return;
                    }
                    devolucion.setMontoCobro(montoCobro);
                }

                System.out.println("Devolución modificada exitosamente.");
                return;
            }
        }

        System.out.println("Devolución no encontrada.");
    }

    private static void eliminarDevolucion() {
        System.out.print("\nIngrese el código del préstamo para eliminar la devolución: ");
        String codigoPrestamo = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            if (listaDevoluciones.get(i).getCodigoPrestamo().equals(codigoPrestamo)) {
                listaDevoluciones.remove(i);
                System.out.println("Devolución eliminada exitosamente.");
                return;
            }
        }

        System.out.println("Devolución no encontrada.");
    }

    private static void registrarDevolucion() {
        int opcion;

        do {
            // Mostrar el submenú
            System.out.println("Sub menú: Registrar devolución de ítems");
            System.out.println("1. Registrar estado de ítems");
            System.out.println("2. Registrar datos del préstamo");
            System.out.println("3. Registrar fecha de devolución");
            System.out.println("4. Volver al menú");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    registrarEstadoItem();
                    break;
                case 2:
                    registrarDatosPrestamo();
                    break;
                case 3:
                    registrarFechaDevolucion();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
            }
        } while (opcion != 4);

    }
    private static void registrarEstadoItem() {
        System.out.print("Ingrese el ID del ítem: ");
        String idItem = scanner.nextLine();

        System.out.print("Ingrese el estado actual del ítem (Bueno, Regular, Malo): ");
        String estadoItem = scanner.nextLine();

        System.out.println("Estado del ítem registrado:");
        System.out.println("ID del ítem: " + idItem);
        System.out.println("Estado: " + estadoItem);

    }
    private static void registrarDatosPrestamo(){
        System.out.print("Ingrese el nombre del prestatario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el ID del préstamo: ");
        String idPrestamo = scanner.nextLine();

        System.out.print("Ingrese la fecha del préstamo (dd/mm/yyyy): ");
        String fechaPrestamo = scanner.nextLine();

        System.out.println("Datos del préstamo registrados:");
        System.out.println("Nombre del prestatario: " + nombre);
        System.out.println("ID del préstamo: " + idPrestamo);
        System.out.println("Fecha del préstamo: " + fechaPrestamo);

    }
    private static void registrarFechaDevolucion(){
        System.out.print("Ingrese el ID del préstamo: ");
        String idPrestamo = scanner.nextLine();

        System.out.print("Ingrese la fecha de devolución (dd/mm/yyyy): ");
        String fechaDevolucion = scanner.nextLine();

        System.out.println("Fecha de devolución registrada:");
        System.out.println("ID del préstamo: " + idPrestamo);
        System.out.println("Fecha de devolución: " + fechaDevolucion);

    }

    private static void generarReporteDevoluciones() {
        if (listaDevoluciones.isEmpty()) {
            System.out.println("No hay devoluciones registradas.");
        } else {
            System.out.println("\n--- Listado de Devoluciones ---");

            // Recorrer la lista de devoluciones y mostrar los detalles en una sola línea
            for (Prestamo devolucion : listaDevoluciones) {
                // Formato de la fecha
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaDevolucion = (devolucion.getfechaDevolucion() != null) ?
                        sdf.format(devolucion.getfechaDevolucion()) : "Fecha no disponible";

                // Acceder al nombre del usuario desde la clase Usuario
                String nombreUsuario = (devolucion.getNombreUsuario() != null && devolucion.getNombreUsuario() != null) ?
                        devolucion.getNombreUsuario(): "Nombre no disponible";

                // Imprimir cada devolución en una línea
                System.out.println(devolucion.getCodigoPrestamo() + ", " +
                        fechaDevolucion + ", " +
                        devolucion.getEstadoItem() + ", " +
                        devolucion.getMontoCobro() + ", " +
                        nombreUsuario);
            }

            // Mensaje indicando que el reporte ha sido "generado"
            System.out.println("\nReporte de devoluciones generado exitosamente!");
        }
    }
}
