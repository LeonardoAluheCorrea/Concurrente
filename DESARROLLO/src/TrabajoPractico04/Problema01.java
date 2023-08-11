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
public class Problema01 {
    public static void main (String[]args){
        //Crea una matriz y luego realiza diversas operaciones con ella
        int[][]matriz;
        int cantFilas, cantColumnas, continuar, cargar;
        System.out.println("Ingrese la cantidad de filas");
        cantFilas = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de columnas");
        cantColumnas = TecladoIn.readLineInt();
        matriz = new int[cantFilas][cantColumnas];
        do{
            menu();
            continuar = TecladoIn.readLineInt();
            switch(continuar){
                case 1:
                    System.out.println("Ingrese que fila de la matriz desea cargar");
                    cargar = TecladoIn.readLineInt();
                    Matrix.loadRow(matriz,cargar);
                    break;
                case 2:
                    Matrix.loadMatrix(matriz);
                    break;
                case 3:
                    System.out.println("Ingrese que fila desea ver");
                    cargar = TecladoIn.readLineInt();
                    Matrix.showRow(matriz, cargar);
                    break;
                case 4:
                    Matrix.showContent(matriz);
            }
        }
        while(continuar != 5);
    }
    
    
    
    public static void menu(){
        //Presenta un menu de opciones 
        System.out.println("1. Cargar la fila i-esima de la matriz");
        System.out.println("2. Cargar la matriz completa haciendo uso del módulo anterior");
        System.out.println("3. Mostrar la columna i-ésima de la matriz");
        System.out.println("4. Mostrar la matriz entera haciendo uso del módulo anterior");
        System.out.println("5. Terminar");
    }
}
