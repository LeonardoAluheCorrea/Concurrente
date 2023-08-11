/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;

import Utiles.TecladoIn;

/**
 *
 * @author Leo
 */
public class Problema08 {

    public static void main(String[] args) {
        int ang1, ang2, ang3;
        
        System.out.println("Ingrese el valor de los tres angulos del triangulo");
        ang1 = TecladoIn.readLineInt();
        ang2 = TecladoIn.readLineInt();
        ang3 = TecladoIn.readLineInt();
        if(ang1==90){
            System.out.println("Es un triangulo rectangulo");
        }
        else{
            if(ang2==90){
                System.out.println("Es un triangulo rectangulo");
            }
            else{
                if(ang3==90){
                    System.out.println("Es un triangulo rectangulo");
                }
                else{
                    System.out.println("No es un triangulo rectangulo");
                }
            }
        }
    }

}
