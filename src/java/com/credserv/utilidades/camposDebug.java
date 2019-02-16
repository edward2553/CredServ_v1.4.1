/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.utilidades;

/**
 *
 * @author edwar
 */
public class camposDebug {

    public static boolean campo_espacioEnBlancoOnumero(String campo) {

        boolean resultado;

        try {
            Double.parseDouble(campo);
            resultado = true;
        } catch (NumberFormatException exception) {
            if (campo.equalsIgnoreCase(" ") || campo.equalsIgnoreCase("  ") || campo.equalsIgnoreCase("   ") || campo.equalsIgnoreCase("    ")
                    || campo.equalsIgnoreCase("     ") || campo.equalsIgnoreCase("      ") || campo.equalsIgnoreCase("       ") || campo.equalsIgnoreCase("        ")
                    || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("          ") || campo.equalsIgnoreCase("           ")
                    || campo.equalsIgnoreCase("            ") || campo.equalsIgnoreCase("             ") || campo.equalsIgnoreCase("              ") || campo.equalsIgnoreCase("               ")
                    || campo.equalsIgnoreCase("                ") || campo.equalsIgnoreCase("                 ") || campo.equalsIgnoreCase("                  ") || campo.equalsIgnoreCase("                   ")
                    || campo.equalsIgnoreCase("                    ") || campo.equalsIgnoreCase("                     ") || campo.equalsIgnoreCase("                      ") || campo.equalsIgnoreCase("                       ")
                    || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                         ") || campo.equalsIgnoreCase("                          ")
                    || campo.equalsIgnoreCase("                           ") || campo.equalsIgnoreCase("                            ") || campo.equalsIgnoreCase("                             ") || campo.equalsIgnoreCase("                              ")) {
                resultado = true;
            } else {
                resultado = false;
            }

        }

        return resultado;
    }

    public boolean campo_null(String campo) {

        boolean resultado = false;

        if (campo == null) {

            resultado = true;
        }
        return resultado;
    }

    public boolean longitud_campoCedula(String cedula) {

        if (cedula.length() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean espacioBlanco(String campo) {
        if (campo.equalsIgnoreCase(" ") || campo.equalsIgnoreCase("  ") || campo.equalsIgnoreCase("   ") || campo.equalsIgnoreCase("    ")
                || campo.equalsIgnoreCase("     ") || campo.equalsIgnoreCase("      ") || campo.equalsIgnoreCase("       ") || campo.equalsIgnoreCase("        ")
                || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("          ") || campo.equalsIgnoreCase("           ")
                || campo.equalsIgnoreCase("            ") || campo.equalsIgnoreCase("             ") || campo.equalsIgnoreCase("              ") || campo.equalsIgnoreCase("               ")
                || campo.equalsIgnoreCase("                ") || campo.equalsIgnoreCase("                 ") || campo.equalsIgnoreCase("                  ") || campo.equalsIgnoreCase("                   ")
                || campo.equalsIgnoreCase("                    ") || campo.equalsIgnoreCase("                     ") || campo.equalsIgnoreCase("                      ") || campo.equalsIgnoreCase("                       ")
                || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                         ") || campo.equalsIgnoreCase("                          ")
                || campo.equalsIgnoreCase("                           ") || campo.equalsIgnoreCase("                            ") || campo.equalsIgnoreCase("                             ") || campo.equalsIgnoreCase("                              ")) {

            return true;
        }
        return false;
    }

    public boolean es_letras(String cedula) {

        boolean resultado;

        try {
            Double.parseDouble(cedula);
            resultado = false;
        } catch (NumberFormatException exception) {
            resultado = true;
        }

        return resultado;
    }

    public boolean es_numero(String cedula) {

        boolean resultado;

        try {
            Double.parseDouble(cedula);
            resultado = true;
        } catch (NumberFormatException exception) {
            resultado = false;
        }

        return resultado;
    }

    //true si solo tiene letras
    //si esta dentro del rango de las letras
    public boolean SoloLetras(char[] palabra, int i) {

        if (i == palabra.length) {

            return true;
        } else {

            if ((int) palabra[i] >= 65 && (int) palabra[i] <= 90 && (int) palabra[i] >= 97 && (int) palabra[i] <= 121 && (int) palabra[i] == 164 && (int) palabra[i] == 165) {
                i++;
                return SoloLetras(palabra, i);
            } else {
                return false;
            }

        }

    }
        public boolean negativos(String dato) {

        int longi = Integer.parseInt(dato);
        if (longi > 1 ) {
            return true;
        } else {
            return false;
        }
    }
    public boolean longitud_edad(String edad){
        if (edad.length() == 2) {
            return true;
        } else {
            return false;
        }
    }


    public boolean caracteresRarosEceptocedula(char[] palabra, int i) {

        if (i == palabra.length) {
            return false;
        } else if ((int) palabra[i] >= 33 && (int) palabra[i] <= 63) {

            return true;

        } else if ((int) palabra[i] >= 91 && (int) palabra[i] <= 96) {

            return true;

        } else if ((int) palabra[i] >= 123) {

            return true;

        } else {
            return caracteresRaros(palabra, i += 1);
        }

    }

    public boolean caracteresRarosEceptoEmail(char[] palabra, int i) {

        if (i == palabra.length) {
            return false;
        } else if ((int) palabra[i] >= 33 && (int) palabra[i] <= 63) {

            return true;

        } else if ((int) palabra[i] >= 91 && (int) palabra[i] <= 96) {

            return true;

        } else if ((int) palabra[i] >= 123) {

            return true;

        } else {
            return caracteresRaros(palabra, i += 1);
        }

    }

    public boolean caracteresRaros(char[] palabra, int i) {

        if (i == palabra.length) {
            return false;
        } else if ((int) palabra[i] >= 33 && (int) palabra[i] <= 47) {

            return true;

        } else if ((int) palabra[i] >= 58 && (int) palabra[i] <= 64 || (int) palabra[i] >= 91 && (int) palabra[i] <= 96) {

            return true;

        } else if ((int) palabra[i] >= 123 && (int) palabra[i] <= 163) {

            return true;

        } else if ((int) palabra[i] >= 166) {
            return true;
        } else {
            return caracteresRaros(palabra, i += 1);
        }

    }
        
    public boolean valorVacio(String campo){
         if (campo.equalsIgnoreCase("")){
             return true;
         }
         return false;
    }

     public boolean longitud_telefono(String telefono){
        if (telefono.length() == 7) {
            return true;
        } else {
            return false;
        }
    }
}
