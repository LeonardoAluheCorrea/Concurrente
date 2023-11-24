/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Leo
 */

public class ej2_1 {
    
    public static void main(String[]args) throws FileNotFoundException, IOException{
        //Usaremos una lista filas
        ArrayList<int[]> piramide = new ArrayList<int[]>();
        String filePath = System.getProperty("user.dir") + "/src/tp4/Piramide.txt";
        BufferedWriter escritor;
        int i = 1;
        int j = 0;
        int cantFilas = 15;
        int[] fila, filaAnterior;
        Scanner scan = new Scanner(new File(filePath));
        for(i = 0; i < cantFilas; i++){ //Cargamos la piramide
            fila = new int[i];
            for(j = 0; j < i; j++){
                fila[j] = scan.nextInt();
            }
            piramide.add(fila);
        }
        scan.close();
        
        for(i = 1; i < cantFilas; i++){ //Ahora calculamos la suma del camino maximo hasta todos los nro, el mayor nro de la ultima fila sera la suma del camino maximo
            fila = piramide.get(i);
            filaAnterior = piramide.get(i-1);
            for (j = i; j < i; j++){
                sumaCaminoMaximo(filaAnterior, fila, j);
            }
        }
        filePath = System.getProperty("user.dir") + "/src/tp4/PiramideFinal";
        escritor = new BufferedWriter(new FileWriter(filePath));
        for(i = 0; i < cantFilas; i++){ //Escribimos la piramide en un archivo
            fila = piramide.get(i);
            for (int k = 0; k < cantFilas-i; k++){ //Imprimimos 15-i espacios en blanco
                escritor.write(" ");
            }
            for(j = 0; j < i; j++){
                escritor.write(fila[j] + " ");
            }
            escritor.newLine();
        }
        escritor.close();
    }

    public static void sumaCaminoMaximo(int[]filaAnterior, int[] fila, int indiceNro){
        int adySupIzq, adySupDer;
        int n = filaAnterior.length;
        if (indiceNro == 0) { //Si estamos en el primer nro de una fila entonces no tiene adyacente superior izquierdo
            adySupIzq = 0;
            adySupDer = filaAnterior[0];
        } else {
            if (indiceNro == n){ //Si estamos en el ultimo nro de una fila entonces no tiene adyacente superior derecho
                adySupIzq = filaAnterior[n-1];
                adySupDer = 0;
            } else{ //Si no los adyacentes tienen indice igual e igual-1 en la anterior en la fila superior
                adySupIzq = filaAnterior[indiceNro-1];
                adySupDer = filaAnterior[indiceNro];
            }
        }
        fila[indiceNro] = fila[indiceNro] + maximo(adySupIzq, adySupDer);
    }
    
    private static int maximo(int i, int j){
        int res = i;
        if (i < j)
            res = j;
        return res;
    }
    
}
