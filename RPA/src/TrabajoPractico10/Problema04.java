/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico10;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema04 {
    public static void main(String[]args){
        int inciso1,inciso2,inciso3,inciso4,inciso5,n,calificacion,aprobados,desaprobados;
        System.out.println("Ingrese la cantidad de alumnos");
        n=TecladoIn.readLineInt();
        aprobados=0;
        desaprobados=0;
        for(int i=0;i<=n;i++){
            System.out.println("Ingrese el puntaje en los 5 incisos de manera ordenada");
            inciso1=TecladoIn.readLineInt();
            inciso2=TecladoIn.readLineInt();
            inciso3=TecladoIn.readLineInt();
            inciso4=TecladoIn.readLineInt();
            inciso5=TecladoIn.readLineInt();
            calificacion=inciso1+inciso2+inciso3+inciso4+inciso5;
            if(calificacion>=60){
                System.out.println("El alumno esta aprobado");
                aprobados++;
            }
            else{
                System.out.println("El alumno esta desaprobado");
                desaprobados++;
            }
            System.out.println("La calificacion de este alumno es: "+calificacion);
            System.out.println("Pasamos al proximo alumno");
        }
        System.out.println("La cantidad de aprobados es: "+aprobados);
        System.out.println("La cantidad de desaprobados es: "+desaprobados);
    }
}
