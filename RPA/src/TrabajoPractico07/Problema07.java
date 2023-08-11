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
public class Problema07 {
    public static void main(String[]args){
        double descuento, pagoFin, kgQueso;
        int tipoPago;
        System.out.println("Ingrese 1 para pago al contado u otro numero para otra forma de pago");
        tipoPago=TecladoIn.readLineInt();
        System.out.println("Ingrese cuantos kg de queso comprara");
        kgQueso=TecladoIn.readLineDouble();
        if(kgQueso>5){
            pagoFin=kgQueso*80;
        }
        else{
            pagoFin=kgQueso*100;
        }
        if(kgQueso>5&&tipoPago==1){
            descuento=(kgQueso*80)*10/100;
            pagoFin=kgQueso*80-descuento;
            System.out.println("El descuento aplicado es "+descuento);
        }
        System.out.println("El monto a pagar es "+pagoFin);
    }
    
}
