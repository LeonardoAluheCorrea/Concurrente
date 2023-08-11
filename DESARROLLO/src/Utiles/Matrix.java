/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Matrix {
    
    
    public static int sumaDiagSec(int[][]matriz){
        //Suma los elementos de la diagonal secundaria
        int sumatoria, cantFilas, cantColumnas;
        cantFilas = matriz.length;
        cantColumnas = matriz[0].length;
        sumatoria = 0;
        for (int i = 0; i < cantFilas; i++){
            sumatoria = sumatoria + matriz[i][cantColumnas];
            cantColumnas--;
        }
        return sumatoria;
    }
    
    public static int sumaDiagPrin(int[][]matriz){
        //Suma los elementos de la diagonal pricipal;
        int sumatoria, cantColumnas, cantFilas;
        cantColumnas = matriz[0].length;
        cantFilas = matriz.length;
        sumatoria = 0;
        for (int i = 0; i < cantFilas; i++){
            for (int j = 0; j < cantColumnas; j++){
                if (j == i)
                    sumatoria = sumatoria + matriz[i][j];
            }
        }
        return sumatoria;
    }
    
    
    public static int[][]productoMatricial (int[][]matriz1, int[][]matriz2){
        //Multiplica 2 matrices si es posible
        int[][]resultante;
        int cantFilas1, cantFilas2, cantColumnas1, cantColumnas2, i, j, k, suma;
        cantFilas1 = matriz1.length;
        cantFilas2 = matriz1.length;
        cantColumnas1 = matriz1[0].length;
        cantColumnas2 = matriz2[0].length;
        if (cantFilas2 != cantColumnas1){
            System.out.println("El producto matricial no existe");
            resultante = new int[0][0];
        }
        else{
            resultante = new int[cantFilas1][cantColumnas2];
            for (i = 0; i < cantFilas1; i++){
                for (j = 0; j < cantColumnas2; j++){
                    for (k = 0, suma = 0; k < cantColumnas1; k++){
                        suma = suma + matriz1[i][k]*matriz2[k][j];
                    }
                    resultante[i][j] = suma;
                }
            }
        }
        return resultante;
    }
    
    public static int[][] sumaMatricial(int[][]matriz1, int[][]matriz2){
        //Suma 2 matrices
        int[][]resultante;
        if (matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length){
            resultante = new int [matriz1.length][matriz1[0].length];
            for (int i = 0; i < matriz1.length; i++){
                for (int j = 0; j < matriz1[0].length; j++){
                    resultante[i][j] = matriz1[i][j]+matriz2[i][j]; 
                }
            }
        }
        else{
            System.out.println("No existe la suma entre estas matrices");
            resultante = new int[0][0];
        }
        return resultante;
    }
    
    public static int sumaColumna (int[][]matriz, int columna){
        //Suma todos los elementos de una columna
        int sumatoria;
        sumatoria = 0;
        for (int i = 0; i < matriz.length; i++){
            sumatoria = sumatoria + matriz[i][columna-1];
        }
        return sumatoria;
    }
    
    public static int sumaFila(int[][]matriz,int fila){
        //Suma todos los elementos de una determinada fila
        int sumatoria;
        sumatoria = 0;
        for (int i = 0; i < matriz[0].length; i++){
            sumatoria = sumatoria + matriz[fila-1][i];
        }
        return sumatoria;
    }
    
    
    public static int[][] transpuesta(int[][]matriz){
        //Transpone una matriz
        int[][]transpuesta;
        int cantFilas, cantColumnas;
        cantFilas = matriz.length;
        cantColumnas = matriz[0].length;
        transpuesta = new int[cantColumnas][cantFilas];
        for (int i = 0; i < cantFilas; i++){
            for (int j = 0; j < cantColumnas; j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
    
    public static int[][] productoEscalar(int[][]matriz, int numero){
        //Realiza el producto por un escalar de la matriz
        //numero: Es el escalar por el cual multiplicamos a la matriz
        int[][]resultante;
        resultante = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++){
                resultante[i][j] = numero*matriz[i][j];
            }
        }
        return resultante;
    }
    
    public static boolean cuadrada(int[][]matriz){
        //Verifica si una matriz es cuadrada
        boolean v;
        v = matriz[0].length == matriz.length;
        return v;
    }
    
    public static boolean diagonal(int[][]matriz){
        //Verfica si una matriz es diagonal
        boolean v;
        v = true;
        int fila, columna, cantFilas, cantColumnas;
        fila = 0;
        cantFilas = matriz.length;
        cantColumnas = matriz[0].length;
        if (cuadrada(matriz)){
            while (fila < cantFilas && v){
                columna = 0;
                while (columna < cantColumnas){
                    if (fila != columna)
                        v = matriz[fila][columna] == 0;
                    columna++;
                }
                fila++;
            }
        }
        else
            System.out.println("La matriz no es cuadrada");
        return v;
    }
    
    public static boolean triangularSup(int[][]matriz){
        //Verifica si una matriz es triangular superior
        boolean continuar;
        continuar = true;
        int filas, columnas, cantFilas, cantColumnas;
        filas = 0;
        cantFilas = matriz.length;
        cantColumnas = matriz[0].length;
        if (cuadrada(matriz)){
            while (filas < cantFilas && continuar){
                columnas = 0;
                while (columnas < cantColumnas){
                    if (filas > columnas){
                        continuar = matriz[filas][columnas] == 0;
                    }
                    columnas++;
                }
                filas++;
            }
        }
        else
            System.out.println("La matriz no es cuadrada");
        return continuar;
    }
    
    public static void showMatrix (int[][]matriz){
        //Muestra el contenido de una matriz escribiendolo como tal
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j]+"  ");
            }
            System.out.println("");
        }
    }
    
    public static void showContent(int[][]matriz){
        //Muestra el contenido de una matriz
        for (int i = 1; i <= matriz.length; i++){
            showRow(matriz,i);
        }
    }
    
    public static void showRow(int[][]matriz, int fila){
        //Muestra la fila solicitada de una matriz
        for (int i = 0; i < matriz[0].length; i++){
            System.out.println(matriz[fila-1][i]);
        }
    }
    
    public static void loadMatrix(int[][]matriz){
        //Hace uso del modulo loadRow para cargar una matriz completa
        for (int i = 0; i < matriz.length; i++){
           for (int j = 0; j < matriz[0].length; j++){
               System.out.println("Ingrese numero entero");
               matriz[i][j] = TecladoIn.readLineInt();
           }
        }
    }
    
    public static void loadRow(int[][]matriz, int fila){
        //Carga la fila i-esima de un arreglo bidimensional
            for (int j = 0; j < matriz[0].length; j++){
                System.out.println("Ingrese el numero entero a guardar en la matriz");
                matriz[fila-1][j] = TecladoIn.readLineInt();
            }
        }
    
    
    }
    

