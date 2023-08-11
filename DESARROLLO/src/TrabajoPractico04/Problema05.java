/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico04;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema05 {
    public static void main(String[]args){
        char[]vector;
        char[][]matriz;
        int k;
        matriz = new char[10][15];
        vector = new char[150];
        k = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 15; j++){
                matriz[i][j] = vector [k];
                k++;
            }
        }
    }
}
