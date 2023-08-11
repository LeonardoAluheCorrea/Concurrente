/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author leonardo.correa
 */
public class Problema04 {
    public static double costoEnvio (double kg) {
    double resultado;
    resultado=kg*50+30;
    return resultado;
    }
    
    
    public static void main (String[]args){
        double kg,costoTotal,costo;
        int cantEnvios;
        costoTotal=0;
        cantEnvios=0;
        kg=1;
        while(kg!=0){
            System.out.println("Ingrese el peso del envio");
                kg=TecladoIn.readLineInt();
            if(kg!=0){                
                cantEnvios++;
                costo=costoEnvio(kg);
                System.out.println("El costo del envio es: "+costo);
                costoTotal=costoTotal+costo;
            }                                       
        }
        System.out.println("La cantidad de envios procesados es: "+cantEnvios);
        System.out.println("El costo total de todos los envios es: "+costoTotal);
    }
}
