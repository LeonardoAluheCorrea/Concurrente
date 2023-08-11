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
public class Problema02 {
    public static void main (String[]args){
        //Dada una frase u oración y una palabra, cuenta la cantidad de veces que aparece esa palabra en la frase 
        String oracion, palabra;
        int result;
        //Usamos una estructura repetitiva para forzar al usuario a ingresar los datos con la precondicion requerida
        do{
        System.out.println("Ingrese una oracion que solo cuente con letras y espacios en blanco");
        oracion = TecladoIn.readLine();
        }
        while (Strings.letrasBlanks(oracion) == false);            
        //invocamos un modulo para verificar que la cadena cuente solo con letras y espacios en blanco
        System.out.println("Ingrese una palabra");
        palabra = TecladoIn.readLine();
        //Invocamos otro modulo para contar la cantidad de veces que aparece "palabra" en "oracion"
        result = Strings.contPalabra(oracion, palabra);
        System.out.println("La palabra "+palabra+" aparece "+result+" veces");
    }
}
