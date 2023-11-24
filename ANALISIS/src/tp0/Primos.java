package tp0;




import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leo
 */
public class Primos {
    public static void main(String[]args){
        int n, cont = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un numero entero");
        n = s.nextInt();
        for (int i = 1; i < n; i++){
            if (esPrimo(i)){
                cont++;
                System.out.println(i);
            }
        }
        System.out.println("Hay " + cont + " numeros primos entre 1 y " + n);
    }
    
    public static boolean esPrimo(int n){
        //Determina si el numero n es primo
        boolean esPrimo = true;
        int i = 2;
        while (esPrimo && i < n){
            esPrimo = n%i != 0;
            i++;
        }
        return esPrimo;
    }
    
}
