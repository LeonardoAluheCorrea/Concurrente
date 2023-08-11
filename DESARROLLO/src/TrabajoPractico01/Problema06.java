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
public class Problema06 {
    public static void main(String[]args){
        //Este algoritmo relaciona los numeros del 1 al 7 con los dias de la sumana, del lunes al domingo
        int num;
        do{
            System.out.println("Ingrese un numero del 1 al 7");
            num = TecladoIn.readLineInt();
            if(num < 1 || num > 7)
                System.out.println("El numero ingresado no esta entre el 1 y el 7");
        }
        while(num < 1 || num > 7);
        System.out.println("El dia que corresponde al numero ingresado es: "+fecha(num));
        }
    
    
    public static String fecha (int number){
        //Este modulo recibe un numero y devuelve el dia de la semana correspondiente
        String dia;
        switch(number){
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miercoles";
                break;
            case 4: 
                dia = "Jueves";  
                break;
            case 5:
                dia = "Viernes";
                break;
            case 6:
                dia = "Sabado";
                break;
            case 7:
                dia = "Domingo";
                break;
            default: 
                dia = "";
                break;
        }
        return dia;
    }
}

