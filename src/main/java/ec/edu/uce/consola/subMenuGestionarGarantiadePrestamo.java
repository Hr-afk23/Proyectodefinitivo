package ec.edu.uce.consola;

import ec.edu.uce.util.Validaciones;
import ec.edu.uce.dominio.Préstamo;
import java.util.List;
import java.util.Scanner;

public class subMenuGestionarGarantiadePrestamo {

    private List<Préstamo> préstamos; //
    private Scanner scanner;

    public subMenuGestionarGarantiadePrestamo(List<Préstamo> préstamos) {
        this.préstamos = préstamos;
        this.scanner = new Scanner(System.in);
    }

    public void subMenuPrestamo() {
        while (true) {
            System.out.println("\nGestión de Garantías de Préstamo:");
            System.out.println("1. Crear garantía");
            System.out.println("2. Modificar garantía");
            System.out.println("3. Consultar garantía");
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
                case "1" -> crearGarantía();
                case "2" -> modificarGarantía();
                case "3" -> consultarGarantía();
                case "4" -> {
                    return; // Volver al menú anterior
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void crearGarantía() {
        System.out.print("-Ingrese id del préstamo: ");
        int idPrestamo = obtenerIdPrestamo(); //  ID como entero
        Préstamo préstamo = buscarPrestamo(idPrestamo);
        if (préstamo == null) {
            System.out.println("Préstamo no encontrado con el ID proporcionado.");
            return;
        }

        System.out.println("-Condiciones de la garantía");
        System.out.print("Monto a abonar para el préstamo Nro: " + idPrestamo + ": ");
        double monto = obtenerMonto();

        préstamo.agregarGarantía(monto);

        System.out.println("Garantía creada exitosamente.");
    }

    private void modificarGarantía() {
        System.out.print("-Ingrese id del préstamo: ");
        int idPrestamo = obtenerIdPrestamo(); // ID como entero
        Préstamo préstamo = buscarPrestamo(idPrestamo);
        if (préstamo == null) {
            System.out.println("Préstamo no encontrado con el ID proporcionado.");
            return;
        }

        System.out.println("-Actualizar condiciones de la garantía");
        System.out.print("Ingrese el nuevo monto para el préstamo Nro: " + idPrestamo + ": ");
        double nuevoMonto = obtenerMonto();

        préstamo.actualizarGarantía(nuevoMonto);

        System.out.print("-¿Aprobar garantía? (Si/No): ");
        String aprobacion = scanner.nextLine().trim().toLowerCase();
        if (aprobacion.equals("si")) {
            System.out.println("Garantía modificada y aprobada exitosamente.");
        } else {
            System.out.println("Modificación de garantía cancelada.");
        }
    }

    private void consultarGarantía() {
        System.out.print("-Ingrese id del préstamo: ");
        int idPrestamo = obtenerIdPrestamo(); // ID como entero
        Préstamo préstamo = buscarPrestamo(idPrestamo);
        if (préstamo == null) {
            System.out.println("Préstamo no encontrado con el ID proporcionado.");
        } else {
            System.out.println("Información del préstamo con ID: " + idPrestamo);
            System.out.println(préstamo.mostrarGarantía()); // Cambio en el nombre del método
        }
    }

    private Préstamo buscarPrestamo(int idPrestamo) { // Cambio a int
        return préstamos.stream()
                .filter(p -> p.getId() == idPrestamo) // Cambiado a comparación de enteros
                .findFirst()
                .orElse(null);
    }

    private int obtenerIdPrestamo() { // Metodo para obtener ID
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un ID válido (número entero): ");
            }
        }
        return id;
    }

    private double obtenerMonto() {
        double monto;
        while (true) {
            try {
                monto = Double.parseDouble(scanner.nextLine());
                if (monto < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un monto válido (número positivo): ");
            }
        }
        return monto;
    }
}
