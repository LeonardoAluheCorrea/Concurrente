/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico04;
import Utiles.TecladoIn;
import Utiles.Matrix;
/**
 *
 * @author Leo
 */
public class Problema07 {
    public static void main(String[]args){
        //Verifica si una matriz es un cuadrado magico
        int[][]matriz;
        int suma, orden, i, j;
        boolean continuar;
        i = 0;
        j = 0;
        System.out.println("Ingrese el orden de la matriz");
        orden = TecladoIn.readLineInt();
        matriz = new int[orden][orden];
        suma = Matrix.sumaDiagPrin(matriz);
        continuar = Matrix.sumaDiagSec(matriz) == suma;
        while(continuar && i < orden){
            while(continuar && j < orden){
                continuar = suma == Matrix.sumaColumna(matriz,j);
                j++;
            }
            continuar = suma == Matrix.sumaFila(matriz, i);
            i++;
        }
        if (continuar){
            System.out.println("La matriz es un cuadrado magico");
        }
        else{
            System.out.println("La matriz no es un cuadrado magico");
        }
    }
}
