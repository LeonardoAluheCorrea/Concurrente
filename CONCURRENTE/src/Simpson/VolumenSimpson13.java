/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simpson;

import Utiles.TecladoIn;

/**
 *
 * @author Leo
 */
public class VolumenSimpson13 {

    public static void main(String[] args) {
        System.out.println("Ingrese el valor de a en x: ");
        double a = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor de b en x: ");
        double b = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor de c en y: ");
        double c = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor de d en y: ");
        double d = TecladoIn.readLineDouble();
        System.out.println("Ingrese el valor de m en x: ");
        int m = TecladoIn.readLineInt();
        System.out.println("Ingrese el valor de n en y: ");
        int n = TecladoIn.readLineInt();
        try {
            double vol = volSimpson13(a, b, c, d, m, n);
            System.out.println("Volumen aproximado en [" + a + "," + b + "],[" + c + "," + d + "] = " + vol);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static double f(double x, double y) {
        double res = (x * x) + (y * y);
        System.out.println("f(" + x + ", " + y + ") = " + res);
        return res; 
    }


    public static double volSimpson13(double a, double b, double c, double d, int m, int n) throws Exception {
        if (m >= 2 && (m % 2) == 0 && n >= 2 && (n % 2) == 0) {
            double h = (b - a) / m;
            double k = (d - c) / n;
            double iImpar = 0;
            double iPar = 0;
            double y = c;
            double I0 = volSimpson13Aux(a, b, h, m, c);
            for (int i = 1; i < n; i++) {
                y = y + k;
                if (i % 2 == 1) {
                    iImpar = iImpar + volSimpson13Aux(a, b, h, m, y);
                } else {
                    iPar = iPar + volSimpson13Aux(a, b, h, m, y);
                }
            }
            double In = volSimpson13Aux(a, b, h, m, d);

            return k * h / 9 * (I0 + (4 * iImpar) + (2 * iPar) + In);
        } else {
            throw new Exception("Se necesita que n y m sean mayor a dos y par para que la cantidad de volumenes sea impar, m = " + m + ", n = " + n);
        }
    }

    public static double volSimpson13Aux(double a, double b, double h, int m, double y) {
        double areaImpar = 0;
        double areaPar = 0;
        double x = a;
        for (int i = 1; i < m; i++) {
            x += h;
            if (i % 2 == 1) {
                areaImpar += f(x, y);
            } else {
                areaPar += f(x, y);
            }
        }
        return f(a, y) + f(b, y) + (4 * areaImpar) + (2 * areaPar);
    }
}

