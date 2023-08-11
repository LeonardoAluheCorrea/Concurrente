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
public class Problema03 {
    public static void main(String[]args){
        //Declara dos matrices y luego realiza ciertas operaciones mediante modulos
        int[][]matriz, arreglo;
        int cantFilas,cantColumnas, opcion;
        System.out.println("Ingrese las filas y luego columnas de la primer matriz");
        cantFilas = TecladoIn.readLineInt(); 
        cantColumnas = TecladoIn.readLineInt();
        matriz = new int[cantFilas][cantColumnas];
        Matrix.loadMatrix(matriz);
        System.out.println("Ingrese las filas y luego columnas de la segunda matriz");
        cantFilas = TecladoIn.readLineInt();
        cantColumnas = TecladoIn.readLineInt();
        arreglo = new int[cantFilas][cantColumnas];
        do{
            menu();
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1:
                    System.out.println("La matriz resultante es");
                    Matrix.showMatrix(Matrix.sumaMatricial(matriz, arreglo));
                case 2:
                    System.out.println("El resultado es");
                    Matrix.showMatrix(Matrix.productoMatricial(matriz, arreglo));
            }
        }
        while (opcion == 1 || opcion == 2);
    }
    
    public static void menu(){
        System.out.println("");
        System.out.println("");
        System.out.println("1. Sumar las matrices");
        System.out.println("2. Multiplicar las matrices");
        System.out.println("");
        System.out.println("");
    }
    
}
