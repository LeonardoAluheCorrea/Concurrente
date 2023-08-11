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
public class Problema02 {
    public static void main(String[]args){
        int antiguedad,numEmba;
        System.out.println("Ingrese '1' si esta embarazada. Si no lo esta ingrese '2'");
        numEmba=TecladoIn.readLineInt();
        System.out.println("Ingrese su antiguedad en la empresa");
        antiguedad=TecladoIn.readLineInt();
        if(antiguedad<30){
            System.out.println("No tiene el dia libre");
        }
        else{
            if(numEmba==2){
              System.out.println("No tiene el dia libre");  
            }
            else{
                System.out.println("Tiene el dia libre");
            }
        }
        
    }
    
}
