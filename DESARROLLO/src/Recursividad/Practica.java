/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Practica {
    public static void main(String[]args){
        String cadena;
        System.out.println("Ingrese una cadena");
        cadena = TecladoIn.readLine();
        System.out.println(cambiarInvertir(cadena));
    }
    
    
    public static String cambiarInvertir(String cad){
        //Devuelve la cadena invertida y reemplaza las vocales por asteriscos
        String resultante;
        if (cad.length() == 1){
            if (cad.equals("a") || cad.equals("e") || cad.equals("i") || cad.equals("o") || cad.equals("u"))
                resultante = "*";
            else
                resultante = cad;
        }
        else{
            if(cad.charAt(0) == 'a' || cad.charAt(0) == 'e' || cad.charAt(0) == 'i' || cad.charAt(0) == 'o' || cad.charAt(0) == 'u')
                resultante = cambiarInvertir(cad.substring(1)) + '*';
            else
                resultante = cambiarInvertir(cad.substring(1)) + cad.charAt(0);
        }
        return resultante;
    }
}
