/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico10;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){ 
       for(int fila=1;fila<=9;fila++){
           for(int columna=1;columna<=9;columna++){
               System.out.print("  |  "+fila*columna+"  |  ");
           }
           System.out.println("");
       }
}
}
