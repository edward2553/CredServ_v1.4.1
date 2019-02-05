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
public class placaDebug {

    /**
     * Retorna true si es un numero
     *
     * @return
     */
    public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException exception) {
            resultado = false;
        }

        return resultado;
    }

    public int numeroEnOrden(int ultimoNumero) {
        return ultimoNumero + 1;
    }

    public static boolean longitudPlaca(String placa) {
        return placa.length() != 7;
    }

    public boolean letras(char[] placa, int i) {

        if (i == 2) {
            return true;
        } else if ((int) placa[i] >= 65 && (int) placa[i] <= 90) {
            i++;
            return letras(placa, i);
        } else if ((int) placa[i] >= 97 && (int) placa[i] <= 122) {
            i++;
            return letras(placa, i);
        } else if ((int) placa[i] == 164 || (int) placa[i] == 165) {
            i++;
            return letras(placa, i);
        } else {
            return false;
        }
    }

    public boolean guion(String guionPLaca, int i) {

        return guionPLaca.equalsIgnoreCase("-");
    }

    public boolean caracteresRaros(char[] palabra, int i) {

        if (i == palabra.length) {
            return false;
        } else if ((int) palabra[i] >= 33 && (int) palabra[i] <= 44) {

            return true;

        } else if ((int) palabra[i] >= 46 && (int) palabra[i] <= 47 || (int) palabra[i] >= 58 && (int) palabra[i] <= 64) {

            return true;

        } else if ((int) palabra[i] >= 91 && (int) palabra[i] <= 96 || (int) palabra[i] >= 123 && (int) palabra[i] <= 163) {

            return true;

        } else if ((int) palabra[i] >= 166) {
            return true;
        } else {
            return caracteresRaros(palabra, i += 1);
        }

    }

}
