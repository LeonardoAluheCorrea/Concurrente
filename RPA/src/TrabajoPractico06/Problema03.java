/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico06;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema03 {
    public static void main(String[]args){
        int prom, curso;
        System.out.println("Ingrese el promedio del alumno");
        prom=TecladoIn.readLineInt();
        System.out.println("Ingrese el numero del curso del alumno");
        curso=TecladoIn.readLineInt();
        if(prom<=8){
            System.out.println("No puede participar del certamen");
        }
        else{
            if(curso==7||curso==6){
           System.out.println("Puede participar del certamen"); 
        }
            else{
                System.out.println("No puede participar del certamen");
            }
        }
        
    }
    
}
