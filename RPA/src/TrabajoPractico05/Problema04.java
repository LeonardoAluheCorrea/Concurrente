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
public class Problema04 {
    public static void main(String[]args){
     char letra,v1,v2,v3,v4,v5;
     
     System.out.println("Ingrese una letra");
     letra=TecladoIn.readChar();
     v1='a';
     v2='e';
     v3='i';
     v4='o';
     v5='u';
     if(letra==v1){
         System.out.println(letra+" es una vocal");
     }
     else{
         if(letra==v2){
             System.out.println(letra+" es una vocal");
         }
         else{
             if(letra==v3){
                 System.out.println(letra+" es una vocal");
             }
             else{
                 if(letra==v4){
                     System.out.println(letra+" es una vocal");
                 }
                 else{
                     if(letra==v5){
                         System.out.println(letra+" es una vocal");
                     }
                     else{
                         System.out.println(letra+" no es una vocal");
                     }
                 }
             }
         }
     }
        
        
     
     
    
   
}}
