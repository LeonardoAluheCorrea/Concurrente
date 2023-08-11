
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
public class Problema07 {
    public static void main (String[]args){
    double hora;
    int dia;
    boolean levantarse;
    System.out.println("Ingrese la hora");
    hora=TecladoIn.readLineDouble();
    System.out.println("Ingrese el dia de la semana en numeros, Ej:lunes es 1, martes es 2, etc");
    dia=TecladoIn.readLineInt();
    levantarse=hora==7;
    if(hora!=7){
        System.out.println("Tendrias que levantarte: "+levantarse);
    }
    else{
        if(dia==1){
            System.out.println("Tendrias que levantarte:"+levantarse);
        }
            else{
                 if(dia==5){
                     System.out.println("Tendrias que levantarte:"+levantarse);
                 }
                
            
        }
        }
    }
    }
    

