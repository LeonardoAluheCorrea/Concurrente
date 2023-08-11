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
public class Problema02 {
    public static void main (String[]args){
        //Crea una matriz del tamaño que pida el usuario y luego presenta un menu de opciones para el usuario
        int[][]matriz;
        int filas, columnas, opcion, proEscalar, filaDeseada, columnaDeseada;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        filas = TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        columnas = TecladoIn.readLineInt();
        matriz = new int[filas][columnas];
        Matrix.loadMatrix(matriz);
        do{
            menu();
            opcion = TecladoIn.readLineInt();
            switch (opcion){
                case 1:
                    Matrix.showMatrix(matriz);
                    break;
                case 2:
                    if (Matrix.triangularSup(matriz))
                        System.out.println("La matriz es triangular superior");
                    else
                        System.out.println("La matriz no es triangular superior");
                    break;
                case 3:
                    if (Matrix.diagonal(matriz))
                        System.out.println("La matriz es diagonal");
                    else
                        System.out.println("La matriz no es diagonal");
                    break;
                case 4:
                    System.out.println("Ingrese el escalar por el cual desea multiplicar a la matriz");
                    proEscalar = TecladoIn.readLineInt();
                    System.out.println("La matriz resultante es");
                    Matrix.showMatrix(Matrix.productoEscalar(matriz,proEscalar));
                    break;
                case 5:
                    System.out.println("La matriz transpuesta seria");
                    Matrix.showMatrix(Matrix.transpuesta(matriz));
                    break;
                case 6:
                    System.out.println("Ingrese la fila cuyos elementos desea sumar");
                    filaDeseada = TecladoIn.readLineInt();
                    System.out.println("La sumatoria de la fila es "+Matrix.sumaFila(matriz, filaDeseada));
                    break;
                case 7: 
                    System.out.println("Ingrese la columna cuyos elementos desea sumar");
                    columnaDeseada = TecladoIn.readLineInt();
                    System.out.println("La sumatoria de la columna es "+Matrix.sumaColumna(matriz, columnaDeseada));
                    break;
            }
        }
        while (opcion > 0 || opcion < 8);
    }
    
    public static void menu(){
        //Presenta un menu de opciones
        System.out.println("");
        System.out.println("");
        System.out.println("1. Mostrar todos los elementos de una matriz");
        System.out.println("2. Verificar si la matriz es Triangular Superior");
        System.out.println("3. Verificar si la matriz es Matriz Diagonal");
        System.out.println("4. Producto por un escalar, se debe ingresar el valor correspondiente.");
        System.out.println("5. Transponer la matriz");
        System.out.println("6. Sumar los elementos de una fila determinada");
        System.out.println("7. Sumar los elementos de una columna");
        System.out.println("8. Salir");
        System.out.println("");
        System.out.println("");
    }
    
}
