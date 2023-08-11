/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico4;
import Utiles.TecladoIn;

/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){
    double segundos,minutos,horas,aux,segOriginal;
    System.out.println("Ingrese cantidad de segundos");
    segundos=TecladoIn.readLineDouble();
    segOriginal=segundos;
    horas=(int)segundos/3600;
    aux=segundos%3600;
    minutos=(int)aux/60;
    segundos=aux%60;
    System.out.println(segOriginal+" seg equivalen a "+horas+"hs "+minutos+"min "+segundos+"seg ");
    
   
            
    
        
       
    
          
}}
