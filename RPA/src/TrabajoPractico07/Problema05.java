/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico07;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema05 {
    public static void main(String[]args){
        String nombre;
        int nota1,nota2,promedio;
        System.out.println("Ingrese nombre y apellido del alumno");
        nombre=TecladoIn.readLineWord();
        System.out.println("Ingrese la notas del primer y segundo parcial");
        nota1=TecladoIn.readLineInt();
        nota2=TecladoIn.readLineInt();
        if(nota1>8&&nota2>8){
            System.out.println("El alumno promociona");
        }
        else{
            System.out.println("El alumno no promociona");
        }
        promedio=(nota1+nota2)/2;
        System.out.println("El promedio del alumno es "+promedio);        
    }
    
}
