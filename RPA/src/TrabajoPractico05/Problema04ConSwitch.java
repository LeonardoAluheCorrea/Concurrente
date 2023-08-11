/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema04ConSwitch {
    public static void main(String[]args){
        char letra;
        System.out.println("Ingrese una letra");
        letra=TecladoIn.readChar();
        
        switch(letra){
            case 'a': System.out.println("La letra es una vocal");break;
            case'e' : System.out.println("La letra es una vocal");break;
            case'i': System.out.println("La letra es una vocal");break;
            case'o':System.out.println("La letra es una vocal");break;
            case'u':System.out.println("La letra es una vocal");break;
            
            default:System.out.println("la letra NO es una vocal");break;
        }
    }
}
