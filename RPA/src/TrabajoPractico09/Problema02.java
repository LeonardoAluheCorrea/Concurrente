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
public class Problema02 {
    public static void CuentaRegresiva(int numero){
        
      for(int i=numero;i>0;i--){
          System.out.print(i);
      }  
    }
    public static void main(String[]args){
        int num1,num2,num3,num4;
        System.out.println("Ingrese 4 valores enteros positivos");
        num1=TecladoIn.readLineInt();
        num2=TecladoIn.readLineInt();
        num3=TecladoIn.readLineInt();
        num4=TecladoIn.readLineInt();
        System.out.println("Las cuentas regresivas para son:");
       
        CuentaRegresiva(num1);
        System.out.println("");
        CuentaRegresiva(num2);
        System.out.println("");
        CuentaRegresiva(num3);
        System.out.println("");
        CuentaRegresiva(num4);
        
        
    }
    
}
