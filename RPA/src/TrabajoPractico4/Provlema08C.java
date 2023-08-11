/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico4;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Provlema08C {
    public static void main(String[]args){
  int a,b,c;
  System.out.print("Ingrese el valor de a");
  a=TecladoIn.readLineInt();
  System.out.println("Ingrese el valor de b");
  b=TecladoIn.readLineInt();
  System.out.println("Ingrese el valor de c");
  c=TecladoIn.readLineInt();
  a=a+b;
  b=a-b;
  a=a-b;
  a=a+c;
  c=a-c;
  a=a-c;
  System.out.println("El nuevo valor de a es:"+a);
  System.out.println("El nuevo valor de b es;"+b);
        System.out.println("El nuevo valor de c es:"+c);
          
          
  
  
         
        
}}
    
