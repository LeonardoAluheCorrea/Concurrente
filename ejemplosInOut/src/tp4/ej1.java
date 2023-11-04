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

/**
 *
 * @author Leo
 */
public class ej1 {
    public static void main(String[]args) throws FileNotFoundException, IOException{
        File output = new File("DatosEjercicio.txt");
        BufferedWriter escritor = new BufferedWriter(new FileWriter(output));
        output.createNewFile();
        int f;
        int n = 30;
        double aux;
        double promIt = 0, promRecu = 0;
        escritor.write("Fibonacci recursivo             Fibonacci iterativo             Tiempo Teorico");
        escritor.newLine();
        escritor.newLine();
        for (int i = 1; i <= 30; i++){
            aux = System.nanoTime(); //Obtenemos el tiempo hasta ahora
            f = fibonacci(i);
            aux = System.nanoTime() - aux; //Restamos al tiempo total el tiempo anterior a ejecutar f
            promRecu = promRecu + aux;
            escritor.write("f(" + i + ") = " + f + " T = " + aux + "ns          "); //escribimos en el archivo
            //Repetimos para el f iterativo
            aux = System.nanoTime(); 
            f = fibonacciIterativo(i);
            aux = System.nanoTime() - aux;
            promIt = promIt + aux;
            escritor.write("f(" + i + ") = " + f + " T = " + aux + "ns.               " + (8*i+16));
            escritor.newLine();
        }
        escritor.write("Tiempo recursivo promedio en ns: " + promRecu/n);
        escritor.newLine();
        escritor.write("Tiempo iterativo promedio en ns: " + promIt/n);
        escritor.close();
    }

    public static int fibonacciIterativo(int n) {
        int res = 1;
        if (n > 1) {
            int a = 0;
            res = 1;
            for (int i = 2; i <= n+1; i++) {
                int temp = a;
                a = res;
                res = temp + res;
            }
        }
        return res;
    }


    
    public static int fibonacci(int n){
        int res;
        if (n < 2){
            res = 1;
        }
        else{
            res = fibonacci(n-1) + fibonacci(n-2);
        }
        return res;
    }
}
