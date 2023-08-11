/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico07;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema06 {
    public static void main(String[]args){
        int socio,cuota;
        double descuento, montoPag;
        System.out.println("Ingrese 1 si es socio pleno u otro numero si no lo es ");
        socio=TecladoIn.readLineInt();
        System.out.println("Ingrese cuantos meses de cuota debe pagar");
        cuota=TecladoIn.readLineInt();
        if(socio==1){
            montoPag=cuota*420;
        }
        else{
            if(cuota==1){
                montoPag=310-(310*15/100);
                descuento =310*15/100;
                System.out.println("El descuento aplicado es "+descuento);
            }
            else{
                montoPag=310*cuota;
            }
            
        }
        
        System.out.println("El monto a pagar es "+montoPag);
        
        
    }
    
}
