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
public class Arreglos {
    
    
    
    public static int[] todosNegativos(double[]vector){
        //Recorre un arreglo de numeros y guarda en otro arreglo todas las posiciones que contienen numeros menores a cero
        int[] posicion;
        int j;
        j = 0;
        posicion = new int[j];
        for(int i = 0; i < vector.length; i++){
            if (vector[i] < 0){
                j++;
                posicion = new int[j];
                posicion[j] = i;
            }
        }
        return posicion;
    }
    
    public static int promedioMitades(int[]vector){
        //Calcula el promedio de la primera mitad de un arreglo de enteros y luego de la segunda. Devuelve true si el promedio de la primera es mayor y false si el de la segunda lo es
        int cont1, cont2, v;
        double prom1, prom2;
        v = 0;
        cont1 = 0;
        cont2 = 0;
        prom1 = 0;
        prom2 = 0;
        for (int i = 0; i < vector.length; i++){
            if (i <= (int)(vector.length)/2){
                prom1 = prom1 + vector[i];
                cont1++;
            }
            else{
                prom2 = prom2 + vector [i];
                cont2++;
            }
        }
        prom1 = prom1/cont1;
        prom2 = prom2/cont2;
        if (prom1 == prom2)
            v = 3;
        else
            if (prom1 < prom2)
                v = 1;
            else
                v = 2;
        return v;
    }
    
    public static double promedioArray(double[]vector){
        //Calcula y devuelve el promedio de los valores de un arreglo de numeros
        double prom;
        prom = 0;
        for (int i = 0; i < vector.length; i++){
            prom = prom + vector[i];
        }
        prom = prom/vector.length;
        return prom;
    }
    
    public static int mayorValor(int[]vector){
        //Devuelve el mayor valor de un arreglo de enteros
        int mayor;
        mayor = 0;
        for (int i = 0; i < vector.length; i++){
            if (vector[i] > mayor)
                mayor = vector[i];
        }
        return mayor;
    }
    
    public static int posicionMenor(double[]vector){
        //Nos devuelve la posicion del numero menor en un arreglo de numeros
        int posicion, acu;
        acu = 0;
        for (int i = 0; i < vector.length; i++){
            if (vector[i] < acu)
                acu = i;
        }
        return acu;
    }
    
    public static boolean verificarValor(int[]vector, int valor){
        //Nos dice si un numero entero dado por el usuario se encuentra en un arreglo de enteros
        //valor: Es el numero que debemos verificar si existe en el arreglo
        boolean v;
        int i;
        v = false;
        i = 0;
        while (!v || i < vector.length){
            v = vector[i] == valor;
            i++;
        }
        return v;
    }
    
    public static double sumatoria(double[]arreglo){
        //Realiza la sumatoria de los valores de un arreglo de numeros enteros
        double sumatoria;
        sumatoria = 0;
        for (int i = 0; i < arreglo.length; i++){
            sumatoria = (sumatoria + arreglo[i]);
        }
        return sumatoria;
    }
    
    
    public static int contarPares(int[]vector){
        //Cuenta cuantos numeros pares hay dentro de un arreglo de enteros
        int contador;
        contador = 0;
        for (int i = 0; i < vector.length; i++){
            if (vector[i] % 2 == 0){
                contador++;
            }
        }
        return contador;
    }
    
    
    public static int ocurrencias(char[]letra, char caracter){
        //Devuelve las ocurrencias de un caracter dado por el usuario en un arreglo de caracteres
        //caracter: Es el caracter que nos da el usuario. Debemos contar sus ocurrencias dentro de un arreglo de caracteres
        int contador;
        contador = 0;
        for (int i = 0; i < letra.length; i++){
            if (letra[i] == caracter)
                contador++;
        }
        return contador;
    }
    
    public static void invertir(char[]letra){
        //Muestra el contenido de un arreglo de forma ordenada empezando por la ultima posicion
        for (int i = letra.length-1; i >= 0; i--){
            System.out.println(letra[i]);
        }
    }
    
    public static void paresArrays(char[]letra){
        //Muestra el contenido de las posiciones pares de un arreglo
        for (int i = 0; i < letra.length; i = i+2){
            System.out.println(letra[i]);
        }
    }    
    
}
