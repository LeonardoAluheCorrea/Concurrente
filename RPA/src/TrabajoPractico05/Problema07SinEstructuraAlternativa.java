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
public class Problema07SinEstructuraAlternativa {
    public static void main(String[]args){
        boolean levantarse;
        int hora,dia;
        System.out.println("Ingrese la hora");
        hora=TecladoIn.readLineInt();
        System.out.println("Ingrese el dia de la semana con numeros del 1 al 7");
        dia=TecladoIn.readLineInt();
        levantarse=(hora==7&&dia==2)||(hora==7&&dia==4);
        System.out.println("Tendrias que levantarte: "+levantarse);
      
    }
    
}
