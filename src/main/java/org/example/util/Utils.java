package org.example.util;

public class Utils {

    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.contains("@gmail.com") && !email.contains(" ");
    }

    public static boolean validarSenhaForte(String senha) {
        if (senha == null || senha.length() < 5) {
            return false;
        }
        boolean temMaiuscula = false;
        boolean temNumero = false;
        for (char caractere : senha.toCharArray()) {
            if (Character.isUpperCase(caractere)) {
                temMaiuscula = true;
            }
            if (Character.isDigit(caractere)) {
                temNumero = true;
            }
        }
        return temMaiuscula && temNumero;
    }

}