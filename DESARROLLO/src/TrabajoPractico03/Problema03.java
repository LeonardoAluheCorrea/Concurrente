/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico03;
import Utiles.Strings;
import Utiles.TecladoIn;
/**
 *
 * @author rauzer
 */
public class Problema03 {
    public static void main(String[]args){
        //Lee un arreglo de palabras y luego busca la palabra que este en la posicion del arreglo que indique el usuario
        String[]texto;
        int posicion;
        String cadena, palabra;
        palabra = "";
        System.out.println("Ingrese un texto que solo cuente con letras y espacios en blanco");
        cadena = TecladoIn.readLine();
        texto = new String[Strings.contarPalabras(cadena)];
        for (int i = 0; i < cadena.length(); i++){
            if (Character.isLetter(cadena.charAt(i))){
                palabra = palabra + cadena.charAt(i);
            }
            else{
             texto[i] = palabra;
             palabra = "";
            }            
        }
        System.out.println("Ingrese la posicion del arreglo que desea ver");
        posicion = TecladoIn.readLineInt();
        if (posicion >= texto.length)
            System.out.println("Es posicion es invalida");
        else
            System.out.println("Contenido de esa posicion: "+texto[posicion]);
    }
}
