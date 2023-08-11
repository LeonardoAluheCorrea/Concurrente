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
public class Problema4A {
    public static int primeraPos(String palabra, char letra, int i){
        int n, pos;
        pos = -1;
        n = palabra.length();
        if (i <= n){
            if(palabra.charAt(i-1) == letra)
                pos = i-1;
            else 
                pos = primeraPos(palabra,letra,i+1);
        }
        return pos;
    }
    
    public static void main(String[]args){
        char letra;
        int res;
        String palabra;
        System.out.println("Ingrese la palabra deseada");
        palabra = TecladoIn.readLineWord();
        System.out.println("Ingrese la letra a buscar");
        letra = TecladoIn.readNonwhiteChar();
        res = primeraPos(palabra,letra,1); 
        if(res == -1)
            System.out.println("La letra buscada no se encuentra");
        else
            System.out.println("La letra se encuentra en la posicion "+res);
    }
}
