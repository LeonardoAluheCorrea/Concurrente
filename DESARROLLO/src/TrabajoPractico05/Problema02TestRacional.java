/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
import ClasesTP5.Racional;
/**
 *
 * @author Leo
 */
public class Problema02TestRacional {
    public static void main(String[]args){
        //Prueba la clase racional
        Racional f1, f2;
        int opcion;
        f1 = new Racional();
        f2 = new Racional();
        System.out.println("Ingrese el numerador y denominador de la primera fraccion");
        f1.setNumerador(TecladoIn.readLineInt());
        f1.setDenominador(TecladoIn.readLineInt());
        System.out.println("Ingrese el numerador y denominador de la segunda fraccion");
        f2.setNumerador(TecladoIn.readLineInt());
        f2.setDenominador(TecladoIn.readLineInt());
        do {
            menu();
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1: 
                    System.out.println(f1.sumar(f2).toString());
                    break;
                case 2:
                    System.out.println(f1.restar(f2).toString());
                    break;
                case 3: 
                    System.out.println(f1.multiplicar(f2).toString());
                    break;
                case 4:
                    System.out.println(f1.dividir(f2).toString());
                    break;
            }
        }
        while (opcion != 5);
    }
    
    public static void menu(){
        System.out.println("1. Sumar las fracciones");
        System.out.println("2. Restar las fracciones");
        System.out.println("3. Multiplicar las fracciones");
        System.out.println("4. Dividir las fracciones");
        System.out.println("5. Salir");
    }
}
