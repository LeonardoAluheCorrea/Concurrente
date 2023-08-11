/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Leo
 */
public class Strings {
    
    public static int  contarPalabras(String texto){
        //Nos devuelve cuantas palabras hay en un texto, solo funciona si el texto tiene unicamente letras y espacios en blanco
        //texto: Es la variable que almacena el texto cuyas palabras vamos a contar
        int cont;
        String acuPal;
        acuPal = ""; 
        cont = 0;
        for (int i = 0; i < texto.length(); i++){
            if (Character.isLetter(texto.charAt(i))){
                acuPal = acuPal +  texto.charAt(i);
            }
            else{
                cont++;
                acuPal = "";
            }
        }
        return cont;
    }
    
    public static int contLetra (String texto, char letra){
         //Recibe una cadena y una letra y cuenta las ocurrencias de la letra en la cadena de caracteres
         int cont;
         cont = 0;
         for (int i = 0; i < texto.length(); i++){
             if (texto.charAt(i) == letra)
                 cont++;
         }
         return cont;
    }
    
    
    
     public static boolean letrasBlanks(String cadena){
        //Este modulo recibe una cadena de caracteres y determina si esta compuesta unicamente por letras y espacios en blanco
        //cadena: Es la cadena de caracteres que analizaremos
        boolean v = true;
        int i;
        i = 0;
        while (v && i < cadena.length()-1){
            i++;
            v = (Character.isLetter(cadena.charAt(i))) || (cadena.charAt(i) == ' ' );
        }
        return v;
    }
     
     
     
     public static int conOcurrPalabra(String texto, String palabra){
         //Recibe dos cadenas de caracteres y cuenta las ocurrencias de la segunda en la primera
         int cont;
         String acu;
         acu = "";
         cont = 0;
         for (int i = 0; i < texto.length(); i++){
             if (Character.isLetter(texto.charAt(i))){
                 acu = acu + texto.charAt(i);
                 if (acu.equalsIgnoreCase(palabra))
                     cont++;
             }
             else{
                 acu = "";
             }
         }
         return cont;
     }
}
