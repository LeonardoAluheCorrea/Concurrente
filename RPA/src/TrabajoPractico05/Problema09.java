/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){
        int num1,digit1,digit2,digit3, resSuma;
        System.out.println("Ingrese un numero natural de 3 cifras");
        num1=TecladoIn.readLineInt();
        digit1=(int)num1/100;
        digit2=num1/10-digit1*10;
        digit3=num1%10;
        resSuma=digit1+digit2+digit3;
        System.out.println("El resultado de la suma de los digitos del numeros es: "+resSuma);
        System.out.println("El numero invertido es:"+digit3+digit2+digit1);
                
    }
    
}
