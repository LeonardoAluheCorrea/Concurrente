/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepasoRecursion;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema4C {
    public static String palInvert(String palabra, int i){
        int n;
        String res;
        n = palabra.length();
        if (i < n)
            res = palabra.charAt(i) + palInvert(palabra,i+1);
        else {
            if (i < 2*n - 1)
                res = palInvert(palabra,i+1) + palabra.charAt(i-n);
            else
                res = "" + palabra.charAt(i-n);
        } 
        return  res;
    }
    
    public static void main (String[]args){
        String palabra;
        int n, i;
        System.out.println("Ingrese la palabra");
        palabra = TecladoIn.readLineWord();
        System.out.println(palInvert(palabra, 0));
    }
}
