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
public class Problema08 {
    public static void main(String[]args){
        //Este algoritmo realiza un intercambio de valores entre las varibles "a" y "b"
        int a=10, b=15;
       
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("Ahora el valor para a es:"+a);
        System.out.println("Ahora el valor para b es:"+b);
        
                
    
}}
