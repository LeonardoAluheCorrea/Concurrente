/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Leo
 */
public class BibliotecaIOElegante {
   
    public static void recuadroGuiones(String texto){
        System.out.println("-----------");
        System.out.println(texto);
        System.out.println("-----------");
    }
    
    public static void recuadroPuntos(String texto){
        System.out.println("............");
        System.out.println(texto);
        System.out.println("............");
    }
    
    public static void recuadroCombinado(String texto){
        System.out.println(">-<->-<");
        System.out.println(texto);
        System.out.println(">-<->-<");
    }
  
}
