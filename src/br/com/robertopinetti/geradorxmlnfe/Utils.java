/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.robertopinetti.geradorxmlnfe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author asus
 */
public final class Utils {

    /**
     * Retorna a data e hora atual no formato "yyyy-MM-dd'T'HH:mm:ss'Z'"
     *
     * @return data, hora e fuso horário
     */
    public static String getTimeStamp() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        return sdf.format(new Date()).trim();

    }   // String getTimeStamp

    /**
     * Retorna o ano com dois dígitos
     *
     * @return ano
     */
    public static String getAno2() {

        SimpleDateFormat sdf = new SimpleDateFormat("yy");

        return sdf.format(new Date());

    }   // String getAno2

    /**
     * Retorna o ano com quatro dígitos
     *
     * @return ano
     */
    public static String getAno4() {

        SimpleDateFormat sdf = new SimpleDateFormat("yy");

        return sdf.format(new Date());

    }   // String getAno4

    public static String getMes() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM");

        return sdf.format(new Date());

    }   // String getMes

    public static String alphaInput(String in, int size) {

        String sOut = "";
        int length = in.length();
        int qtd = size - length;

        while (qtd > 0) {

            sOut += "0";
            qtd--;

        }   // while (qtd > 0)

        sOut += in;

        return sOut;

    }   // String alphaInput

    public static String alphaOutput(String in) {

        StringBuilder sb = new StringBuilder(in);

        for (int i = 0; i <= sb.length(); i++) {

            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, ' ');
            } else {
                i = sb.length();
            }

        }   // for (int i = 0; i <= sb.length(); i++)
        
        return sb.toString().trim();

    }   // String alphaOutput

    /**
     * Converte a String em double
     * @param v String
     * @return retorna o valor em double
     */
    public static double toDouble(String v) {
        
        if ( v == null || v.trim().isEmpty()) {
            return 0.0;
        } else {
            return Double.parseDouble(v);
        }
                
    }   // double toDouble
    
}   // class Utils
