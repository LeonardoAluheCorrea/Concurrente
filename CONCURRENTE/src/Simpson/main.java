/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simpson;

/**
 *
 * @author Leo
 */
public class main {
    public static void main(String []args){
        double x, y, f, suma, n, m;
        n = 4;
        m = 4;
        x = 0;
        y = 0;
        suma = 0;
        for(int i = 0; i < n; i++){
            x = x + 0.25;
            for (int j = 0; j < m; j++){
                y = y + 0.25;
                f = 1 - (1/2 * x * x) - (1/2 * y * y);
                System.out.println("f(" + x + ", " + y + ") = " + f * 0.25);
                suma = suma + (f * 0.25);
            }
        }
        System.out.println(suma);
    }
}
