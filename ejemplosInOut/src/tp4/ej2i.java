/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;
//75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class ej2i {

    public static void main(String[] args) {
        int n = 120;
        Scanner sc = new Scanner(System.in);
        Scanner scan;
        int triangulo[] = new int[120];
        int j = 0;
        String tri;
        System.out.println("Ingrese el triangulo");
        tri = sc.nextLine();
        scan = new Scanner(tri);
        for (int i = 0; i < n; i++) {
            if (scan.hasNextInt()) {
                triangulo[i] = scan.nextInt();
            }
        }    
    }
    
    public static int sumarCaminoMaximo(int[]triangulo){
        int res = 0;
        int j = 5;
        int n = triangulo.length;
        for (int i = 1; i <= n; i++){
            if (i == (j + j/4)){ //El numero solo tiene un adyacente superior
                
            }
            else{ //El numero tiene dos adyacentes 
                
            }
        }
        return res;
    }
    public static int max(int n, int i){
        int res = 0;
        if (n < i)
            res = i;
        else{
            res = n;
        }
        return res;
    }
}
