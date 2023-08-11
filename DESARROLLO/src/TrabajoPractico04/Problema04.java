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
public class Problema04 {
    
    public static int[][]show(int [][]matriz){
        int[][]resultante;
        int cantFilas, cantColumnas, k;
        cantFilas = matriz.length;
        cantColumnas = matriz[0].length;
        resultante = new int [cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++){
            if (i%2 != 0){
                k = 0;
                for (int j = cantColumnas-1; j >= 0; j--){
                    resultante [i][k] = matriz[i][j];
                    k++;
                }
            }
            else{
                for (int j = 0; j < cantColumnas; j++){
                    resultante [i][j] = matriz [i][j];
                }
            }
        }
        return resultante;
    }
    
    public static void main(String[]args){
        int[][]matriz;
        int filas, columnas;
        System.out.println("Ingrese la cantidad de filas");
        filas = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de columnas");
        columnas = TecladoIn.readLineInt();
        matriz = new int[filas][columnas];
        Matrix.loadMatrix(matriz);
        Matrix.showMatrix(show(matriz));
    }
}
