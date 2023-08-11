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
public class Problema08 {
    public static void main(String[]args){
        int plan;
        double descuento = 0, monto, pago = 0;
        System.out.println("Ingrese el numero del plan de pago");
        plan=TecladoIn.readLineInt();
        System.out.println("Ingrese el monto a pagar");
        monto=TecladoIn.readLineDouble();
        switch(plan){
            case 1:
                descuento=monto*25/100;
                pago=monto-descuento;
                break;
            case 2:
                descuento=monto*10/100;
                pago=monto-descuento;
                break;
            case 3: 
                descuento=0;
                pago=monto;
                break;
            default: 
                System.out.println("Seleccione un plan de pago nuevamente");
        }
        System.out.println("El monto a pagar es "+pago);
        System.out.println("El descuento aplicado es "+descuento);
    
    }
    
}
