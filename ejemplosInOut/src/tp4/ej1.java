/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

/**
 *
 * @author Leo
 */
public class ej1 {
    public static void main(String[]args){
        int n = fibonacciIterativo(15);
        int f = fibonacci(15);
        System.out.println(n);
        System.out.println(f);
    }

    public static int fibonacciIterativo(int n) {
        int res;
        if (n <= 0) {
            res = 0;
        } else if (n == 1) {
            res = 1;
        } else {
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
