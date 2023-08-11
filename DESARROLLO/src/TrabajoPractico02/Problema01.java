/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico02;
import Utiles.TecladoIn;
import Utiles.Strings;
/**
 *
 * @author Leo
 */
public class Problema01 {
    public static void main (String[]args){
        //Este algoritmo recibira una cadena de caracteres y contara la cantidad de apariciones de cierta vocal
        int result;
        char letter;
        String cadena;
        System.out.println("Ingrese una frase");
        cadena = TecladoIn.readLine();
        cadena.toLowerCase();
        System.out.println("Ingrese la letra que desea contar dentro de la frase");
        letter = TecladoIn.readNonwhiteChar();
        //Invocamos a un modulo que realiza el analisis
        result = Strings.contLetra(cadena, letter);
        System.out.println("La letra "+letter+" aparece "+result+" veces");
        
    }
}
