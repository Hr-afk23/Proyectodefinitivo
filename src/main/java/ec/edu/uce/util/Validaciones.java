package ec.edu.uce.util;
import ec.edu.uce.dominio.Facultad;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validaciones {
    private static final Scanner scanner = new Scanner(System.in);
    //Validaciones de menu principal
    //Validaciones de subMneuGeneral

    public static boolean validarOpcionMenu(String opcion) {
        try {
            int numero = Integer.parseInt(opcion); // Intentar convertir a entero
            return numero > 0; // Verificar que sea positivo
        } catch (NumberFormatException e) {
            return false; // Retorna false si no es un número
        }
     }


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


        //Validaciones Gestionar Facultad

    public static boolean validarCodigoUnico(String codigo, List<Facultad> facultades) {
        return facultades.stream().noneMatch(facultad -> facultad.getCodigoFacultad().equals(codigo));
    }

    public static Facultad buscarFacultad(String criterio, List<Facultad> facultades) {
        return facultades.stream()
                .filter(facultad -> facultad.getNombreFacultad().equalsIgnoreCase(criterio)
                        || facultad.getCodigoFacultad().equals(criterio))
                .findFirst()
                .orElse(null);
    }















}























































































