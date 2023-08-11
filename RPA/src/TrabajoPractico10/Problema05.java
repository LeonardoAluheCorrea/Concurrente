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
public class Problema05 {
    

    public static String diaSemana(int dia){
        String diaLetras;
        diaLetras = "Lunes";
        switch(dia){
            case 1: 
                diaLetras="Lunes";
                break;
            case 2: 
                diaLetras="Martes";
                break;
            case 3:
                diaLetras="Miercoles";
                break;
            case 4:
                diaLetras="Jueves";
                break;
            case 5:
                diaLetras="Viernes";
                break;
            case 6:
                diaLetras="Sabado";
                break;
            case 7:
                diaLetras="Domingo";
                break;
        }
        return diaLetras;
    }
    
    
    
    
    public static void main(String[]args){
        double tempMaxima,temp;
        int dia=0;
        tempMaxima=0;
        for(int x=0;x<=7;x++){
        for(int i=0;i<=6;i++){
            System.out.println("Ingrese la temperatura");
            temp=TecladoIn.readLineInt();
            if(i==0 && x==0){
                tempMaxima=temp;
                dia=x;
            }
            else{
                if(temp>tempMaxima){
                    tempMaxima=temp;
                    dia=x;
                }
            }
        }
        }
        System.out.println("La temperatura maxima de la semana es "+tempMaxima);
        System.out.println("Esa temperatura fue registrada el dia "+diaSemana(dia));
    }
}
