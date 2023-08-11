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
public class Problema4B {
    public static int ultPos (String palabra, char letra, int i ,int res){
        int n;
        n = palabra.length();
        if (i <= n){
            if (palabra.charAt(i-1) == letra)
                res = ultPos(palabra,letra,i+1,i-1);
            else
                res = ultPos(palabra,letra,i+1,res);
        }
        return res;
    }
    public static void main (String[]args){
        String palabra;
        char letra;
        int result;
        System.out.println("Ingrese la palabra");
        palabra = TecladoIn.readLineWord();
        System.out.println("Ingrese la letra a buscar");
        letra = TecladoIn.readNonwhiteChar();
        result = ultPos(palabra,letra,1,-1);
        if (result != -1)
            System.out.println("La ultima aparicion de la letra es en la posision "+result);
        else 
            System.out.println("La letra no se encuentra");
    }
}
