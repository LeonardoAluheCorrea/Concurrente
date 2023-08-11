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
public class Problema07 {
    public static void main(String[]args){
  int num1, resultado1, resultado2, resultado3;
  System.out.println("Ingrese un entero de 3 cifras");
  num1=TecladoIn.readLineInt();
  resultado1=num1/100;
  resultado2=num1/10-resultado1*10;
  resultado3=num1-resultado1*100-resultado2*10;
  System.out.println("El valor de las centenas es:"+resultado1);
  System.out.println("El valor de las decenas es:"+resultado2);
  System.out.println("El valor de las unidades es:"+resultado3);
          
 
}}
