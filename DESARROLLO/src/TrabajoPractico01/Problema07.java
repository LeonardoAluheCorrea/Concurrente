/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico01;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema07 {
    public static void main(String[]args){
        //Este algoritmo sera capaz de calcular las raices de ecuaciones cuadraticas
        double a, b, c, x1, x2;
        System.out.println("Ingrese el coeficientes del termino cuadratico, luego del termino lineal y por ultimo del independiente");
        a = TecladoIn.readLineDouble();
        b = TecladoIn.readLineDouble();
        c = TecladoIn.readLineDouble();
        if(Math.pow(b,2)-4*a*c < 0)
            System.out.println("No tiene raices reales");
        else{
            //Realizamos la formula de Bhaskara para x1 y luego para x2
            x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
            x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
            System.out.println("Las raices del polinomio son: "+x1+", "+x2);
        }
    }
}

