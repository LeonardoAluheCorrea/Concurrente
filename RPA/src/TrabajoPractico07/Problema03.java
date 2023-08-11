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
public class Problema03 {
    public static void main(String[]args){
        int num,digit1,digit3;
        System.out.println("Ingrese un entero de 3 cifras");
        num=TecladoIn.readLineInt();
        if(num<1000&&num>99){
            digit1=num/100;
            digit3=num%10;        
            if(digit3==digit1){
                System.out.println("La primer cifra es igual a la tercera");
                System.out.println("El numero es "+digit3);
            }
            else{
                System.out.println("La primer cifra y la ultima no son iguales");
            }
           
        }
        else{
            System.out.println("El numero ingresado no es un entero de 3 cifras");
        }
}
}