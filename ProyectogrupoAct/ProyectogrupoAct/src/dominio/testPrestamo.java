package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testPrestamo {
    public static void main(String[] args) {
        // Crear instancia de la clase Prestamo
        System.out.println("--- Creando Préstamo ---");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Suponemos que la fecha de registro es el día actual
        Date fechaRegistro = new Date();
        Date fechaDevolucion = null;
        try {
            fechaDevolucion = sdf.parse("15/12/2024");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear objeto de la clase Prestamo
        Prestamo prestamo = new Prestamo("P001", 100.0, fechaRegistro, "Bueno");
        prestamo.setFechaDevolucion(fechaDevolucion);

        // Mostrar el estado del préstamo
        System.out.println(prestamo);

        // Agregar ítems al préstamo
        System.out.println("\n--- Agregando Ítems al Préstamo ---");
        Date fechaPrestamo = null;
        try {
            fechaPrestamo = sdf.parse("01/12/2024");
        } catch (Exception e) {
            e.printStackTrace();
        }

        prestamo.agregarItem("I001", "U001", fechaPrestamo, fechaDevolucion, "Bueno");
        prestamo.agregarItem("I002", "U002", fechaPrestamo, fechaDevolucion, "Bueno");

        // Imprimir los ítems agregados
        System.out.println("Préstamo después de agregar ítems:");
        System.out.println("Código del préstamo: " + prestamo.getCodigoPrestamo());
        System.out.println("Estado del ítem: " + prestamo.getEstadoItem());
        System.out.println("Fecha devolución: " + prestamo.getfechaDevolucion());

        // Ahora se intentará eliminar un ítem
        System.out.println("\n--- Eliminando un Ítem ---");
        prestamo.eliminarItem("I001");

        // Verificar si el ítem fue eliminado correctamente
        System.out.println("Préstamo después de eliminar un ítem:");
        System.out.println("Código del préstamo: " + prestamo.getCodigoPrestamo());

        // Mostrar el estado final del préstamo
        System.out.println("Estado del ítem: " + prestamo.getEstadoItem());
        System.out.println("Fecha devolución: " + prestamo.getfechaDevolucion());

        // Validar el estado del ítem
        System.out.println("\n--- Modificando el estado del ítem ---");
        prestamo.setEstadoItem("Regular");  // Validación de cambio de estado

        // Probar el estado inválido
        System.out.println("\n--- Intentando establecer un estado inválido ---");
        prestamo.setEstadoItem("Excelente"); // Estado inválido
        System.out.println("Estado después del intento de modificación: " + prestamo.getEstadoItem());

        // Probar monto de cobro
        System.out.println("\n--- Modificando el monto de cobro ---");
        prestamo.setMontoCobro(50.0);  // Modificar monto de cobro
        System.out.println("Monto de cobro actualizado: " + prestamo.getMontoCobro());

        // Probar monto negativo
        System.out.println("\n--- Intentando establecer un monto negativo ---");
        prestamo.setMontoCobro(-20.0);  // Intentar establecer monto negativo
    }
}
