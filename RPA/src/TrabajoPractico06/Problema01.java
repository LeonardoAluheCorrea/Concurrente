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
public class Problema01 {
    public static void main(String[]args){
        int numIngre;
        System.out.println("Ingrese un numero del 1 al 10");
        numIngre=TecladoIn.readLineInt();
        if(numIngre==7){
            System.out.println("Adivinaste!");
        }
        else{
            System.out.println("Has perdido tu oportunidad");
        }
    }
   
    
}
