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
public class Problema05 {
    public static void main(String[]args){
        int horas,minutos,segundos,res1,res2,res3;
        System.out.println("Ingrese las horas");
        horas=TecladoIn.readLineInt();
        System.out.println("Ingrese los minutos");
        minutos=TecladoIn.readLineInt();
        System.out.println("Ingrese los segundos");
        segundos=TecladoIn.readLineInt();
        res1=horas*3600;
        res2=minutos*60;
        res3=res1+res2+segundos;
        System.out.println(horas+minutos+segundos+" equivalen a "+res3+" segundos");
        
        
    }
    
}
