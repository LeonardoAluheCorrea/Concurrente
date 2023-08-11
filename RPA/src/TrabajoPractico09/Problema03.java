/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema03 {
    public static void main(String[]args){
        int contra=0,acumIntentos=0;
        while(contra!=690105){
           System.out.println("Ingrese la contraseña");
           contra=TecladoIn.readLineInt();
           acumIntentos++;
           if(contra==690105){
              System.out.println("Alarma desactivada");
            }
           else{
               System.out.println("Contraseña Incorrecta!!");
               
           }
        }
       System.out.println("Cantidad de intentos "+acumIntentos);
               System.out.println("Se recomienda no olvidar la contraseña");
    }
    
}
