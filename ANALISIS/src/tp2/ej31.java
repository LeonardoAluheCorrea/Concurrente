/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

import java.util.Random;

/**
 *
 * @author Leo
 */
public class ej31 {
    public static void main (String[]args){
        int[] v = new int[10000];
        double t;
        Random r = new Random();
        for (int i = 0; i < 10000;i++){
            v[i] = r.nextInt(1000000000);
        }
        t = System.currentTimeMillis();
        int f = distMin(v,10000);
        t = System.currentTimeMillis() - t;
        System.out.println(f);
        System.out.println("Tiempo del algoritmo sin mejora: " + t);
        t = System.currentTimeMillis(); 
        f = distMinMejorada(v,10000);
        t = System.currentTimeMillis() - t;
        System.out.println(f);
        System.out.println("Tiempo del algoritmo con mejora: " + t);
    }
    
    public static int distMin(int[]a, int n){ //Corregimos
        int dmin = 5000;
        for (int i = 0; i <= n-1; i++){
            for (int j = 0; j <= n-1; j++){
                if (i != j && Math.abs(a[i] - a[j]) < dmin)
                    dmin = Math.abs(a[i] - a[j]);
            }
        }
        return dmin;
    }
     
    public static int distMinMejorada(int[]a, int n){
        int dmin = 50000;
        int i = 0 ,j;
        boolean continuar = true;
        while (continuar && i <= n-1){
            j = i + 1;
            while (continuar && j <= n-1){
                if (Math.abs(a[i] - a[j]) < dmin)
                    dmin = Math.abs(a[i] - a[j]);
                continuar = dmin != 0;
                j++;
            }
            i++;
        }
        return dmin;
    }
    
}
