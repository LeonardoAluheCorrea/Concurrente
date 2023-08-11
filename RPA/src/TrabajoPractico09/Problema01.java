/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema01 {
    public static void main(String[]args){
        int numero, resultado;
        System.out.println("Ingrese un numero entero");
        numero=TecladoIn.readLineInt();
        
        for(int i=0;i<=10;i++){
            resultado=numero*i;
            System.out.println(numero+"x"+i+"="+resultado);
        }
    }
    
}
