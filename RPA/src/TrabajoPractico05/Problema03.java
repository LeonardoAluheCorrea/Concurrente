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
public class Problema03 {
    public static void main(String[]args){
  int num1, num2, num3;
  boolean verdad;
  num1=32;
  num2=1;
  num3=555;
  verdad=num1>num2;
  System.out.println("num1>num2 ?"+verdad);
  verdad=num1>num3;
  System.out.println("num1>num3"+verdad);
  verdad=(num1>num2)&&(num1>num3);
  System.out.println("num1>num2 y num1>num3?"+verdad);
  verdad=(num1>num2)||(num1>num3);
  System.out.println("num1>num2 o num1>num3"+verdad);
  verdad=!(num1>num3);
  System.out.println("NO(num1>num2)?"+verdad);
  System.out.println("NO(verdad)? "+!verdad);
  
          
         
        
        
}}
