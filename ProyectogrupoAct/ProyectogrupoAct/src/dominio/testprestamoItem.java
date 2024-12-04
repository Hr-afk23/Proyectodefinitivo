package dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testprestamoItem {
    public static void main(String[] args) {
        // Crear formato de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Crear instancia de la clase prestamoItem
        System.out.println("--- Creando Item de Préstamo ---");
        Date fechaPrestamo = null;
        Date fechaDevolucion = null;

        // Definir las fechas para las pruebas
        try {
            fechaPrestamo = sdf.parse("01/12/2024");
            fechaDevolucion = sdf.parse("15/12/2024");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear objeto prestamoItem
        prestamoItem item = new prestamoItem("I001", "U001", fechaPrestamo, fechaDevolucion, "Activo");

        // Mostrar los detalles del item creado
        System.out.println(item);

        // Verificar si las fechas y el estado son correctos
        System.out.println("\n--- Verificando fecha de préstamo y fecha de devolución ---");
        System.out.println("Fecha de préstamo: " + item.getFechaPrestamo());
        System.out.println("Fecha de devolución: " + item.getFechaDevolucion());
        System.out.println("Estado del ítem: " + item.getEstado());

        // Intentar establecer una fecha de préstamo futura
        System.out.println("\n--- Intentando establecer una fecha de préstamo futura ---");
        Date fechaFutura = new Date(System.currentTimeMillis() + 1000000000L); // fecha futura
        item.setFechaPrestamo(fechaFutura);  // Esto debería imprimir un error

        // Intentar establecer una fecha de devolución anterior a la actual
        System.out.println("\n--- Intentando establecer una fecha de devolución anterior ---");
        Date fechaPasada = new Date(System.currentTimeMillis() - 1000000000L); // fecha pasada
        item.setFechaDevolucion(fechaPasada);  // Esto debería imprimir un error

        // Cambiar estado a "Inactivo"
        System.out.println("\n--- Cambiando el estado a Inactivo ---");
        item.setEstado("Inactivo");
        System.out.println("Estado del ítem: " + item.getEstado());

        // Intentar establecer un estado inválido
        System.out.println("\n--- Intentando establecer un estado inválido ---");
        item.setEstado("Prestado");  // Estado inválido
        System.out.println("Estado del ítem después del intento inválido: " + item.getEstado());

        // Probar el código de ítem vacío
        System.out.println("\n--- Intentando establecer un código de ítem vacío ---");
        item.setCodigoItem("");  // Código vacío, debería generar error
        System.out.println("Código de ítem después del intento vacío: " + item.getCodigoItem());

        // Probar el código de usuario vacío
        System.out.println("\n--- Intentando establecer un código de usuario vacío ---");
        item.setCodigoUsuario("");  // Código de usuario vacío, debería generar error
        System.out.println("Código de usuario después del intento vacío: " + item.getCodigoUsuario());

        // Mostrar los detalles finales del ítem
        System.out.println("\n--- Detalles del ítem después de las modificaciones ---");
        System.out.println(item);
    }
}
