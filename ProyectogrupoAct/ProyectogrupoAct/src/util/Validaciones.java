package util;
import dominio.prestamoItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Validaciones {
    private static final Scanner scanner = new Scanner(System.in);
    //Validaciones de menu principal
    //Validaciones de subMneuGeneral

    public static boolean validarNombreApellido(String texto) {
        // Primera letra mayúscula, resto minúsculas, sin espacios y hasta 45 caracteres
        String regex = "^[A-Z][a-z]{1,44}$";
        return Pattern.matches(regex, texto);
    }

    public static boolean validarTextoGeneral(String texto) {
        // Primera letra mayúscula, resto pueden incluir espacios, hasta 100 caracteres
        String regex = "^[A-Z][a-zA-Z ]{0,99}$";
        return Pattern.matches(regex, texto);
    }

    public static boolean validarContraseña(String contraseña) {
        // Al menos una mayúscula, dos números, el resto en minúsculas, mínimo 6 caracteres
        String regex = "^(?=.*[A-Z])(?=.*\\d.*\\d)[a-zA-Z\\d]{6,}$";
        return Pattern.matches(regex, contraseña);
    }

    public static boolean validarOpcionMenu(String opcion) {
        // Verifica que sea un número válido
        return opcion.matches("\\d+");
    }
    // Verificar si el código de usuario existe
    public static boolean validarExistenciaUsuario(String codigoUsuario, ArrayList<String> listaUsuarios) {
        return listaUsuarios.contains(codigoUsuario);
    }

    // Verificar si la fecha de devolución es posterior a la fecha de préstamo
    public static boolean validarFechas(Date fechaPrestamo, Date fechaDevolucion) {
        return fechaDevolucion.after(fechaPrestamo);
    }

    // Verificar que el estado sea uno de los valores válidos ("Activo", "Devuelto", "Retrasado")
    public static boolean validarEstadoPrestamo(String estado) {
        return estado.equals("Activo") || estado.equals("Devuelto") || estado.equals("Retrasado");
    }


    //Gestionar garantia de prestamos

    // Verificar si el código de préstamo existe
    public static boolean validarExistenciaPrestamo(String codigoPrestamo, ArrayList<prestamoItem> listaPrestamos) {
        for (prestamoItem prestamo : listaPrestamos) {
            if (prestamo.getCodigoItem().equals(codigoPrestamo)) {
                return true;
            }
        }
        return false;
    }

    // Verificar si el monto de garantía es válido (mayor que 0)
    public static boolean validarMontoGarantia(double montoGarantia) {
        return montoGarantia > 0;
    }

    // Verificar que el estado de la garantía sea válido
    public static boolean validarEstadoGarantia(String estado) {
        return estado.equals("activa") || estado.equals("eliminada");
    }
    public static boolean validarEstadoItem(String estadoItem) {
        return estadoItem.equalsIgnoreCase("dañado") || estadoItem.equalsIgnoreCase("en buen estado");
    }
    //Gestionar Devolucion de items

    // Verificar si el monto de cobro es válido (mayor que 0)
    public static boolean validarMontoCobro(double montoCobro) {
        return montoCobro >= 0;
    }
}