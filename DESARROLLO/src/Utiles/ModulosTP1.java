/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Leo
 */
public class ModulosTP1 {
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
       
       
       
           public static double promedio(int suma, int cant){
        //Calcula promedios
        double prom;
        prom = suma/cant;
        return prom;
    }
    
}
