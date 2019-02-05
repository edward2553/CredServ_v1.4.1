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
public class camposIngresarServicioDebug {

    /**
     * False si el campo contiene numeros False si el campo contiene espacios en
     * blanco mayoría contiene espacio en blanco
     *
     * @return
     */
    public static boolean campo_espacioEnBlancoOnumero(String campo) {

        boolean resultado;

        try {
            Integer.parseInt(campo);
            resultado = true;
        } catch (NumberFormatException exception) {
            if (campo.equalsIgnoreCase(" ") || campo.equalsIgnoreCase("  ") || campo.equalsIgnoreCase("   ") || campo.equalsIgnoreCase("    ")
                    || campo.equalsIgnoreCase("     ") || campo.equalsIgnoreCase("      ") || campo.equalsIgnoreCase("       ") || campo.equalsIgnoreCase("        ")
                    || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("         ") || campo.equalsIgnoreCase("          ") || campo.equalsIgnoreCase("           ")
                    || campo.equalsIgnoreCase("            ") || campo.equalsIgnoreCase("             ") || campo.equalsIgnoreCase("              ") || campo.equalsIgnoreCase("               ")
                    || campo.equalsIgnoreCase("                ") || campo.equalsIgnoreCase("                 ") || campo.equalsIgnoreCase("                  ") || campo.equalsIgnoreCase("                   ")
                    || campo.equalsIgnoreCase("                    ") || campo.equalsIgnoreCase("                     ") || campo.equalsIgnoreCase("                      ") || campo.equalsIgnoreCase("                       ")
                    || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                        ") || campo.equalsIgnoreCase("                         ") || campo.equalsIgnoreCase("                          ")
                    || campo.equalsIgnoreCase("                           ") || campo.equalsIgnoreCase("                            ") || campo.equalsIgnoreCase("                             ") || campo.equalsIgnoreCase("                              ")) 
            {
                resultado = true;
            } else {
                resultado = false;
            }

        }

        return resultado;
    }
    
    /**
     * Retorna true si el campo es null
     *
     * @return
     */
    public static boolean campo_null(String campo) {

        boolean resultado = false;

        if (campo == null) {

            resultado = true;
        }
        return resultado;
    }

}
