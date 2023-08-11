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
public class Problem03 {
    public static void main(String[]args){
        int fila, columna,n;
        System.out.println("Ingrese n");
        n=TecladoIn.readLineInt();
        for(fila=0;fila<=n;fila++){
            for(columna=1;columna<=fila;columna++){
                System.out.print(fila*columna+"  ");
            }
            System.out.println("");
        }
    }

}
