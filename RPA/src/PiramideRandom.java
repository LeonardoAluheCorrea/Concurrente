/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class PiramideRandom {
    public static void main(String[]args){
        int fila,columna,n;
        System.out.println("Ingrese un numero");
        n=TecladoIn.readLineInt();
        for(fila=1;fila<=n-fila+1;fila++){
            for(columna=1;columna<=fila;columna++){
                System.out.print(columna);
            }
            System.out.println("");
        }
    }
}
