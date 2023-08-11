/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema11 {
    public static double tarifaEstacionamiento(double horas,String dia){
        double resultado;
        if( "domingo".equalsIgnoreCase(dia) || "sabado".equalsIgnoreCase(dia) ){
            resultado=horas*50;
        }
        else{
            resultado=horas*30;
        }
        return resultado;
    }
    
    
    public static void main(String[]args){
        double montoCobrar;
        String dia,continuar;
        int horas,patente,patenteMayorEstadia,mayorEstadiaHoras,contador;
        patenteMayorEstadia=0;
        contador=0;
        mayorEstadiaHoras=0;
        do{
            contador++;
            System.out.println("Ingrese el dia de la semana");
            dia=TecladoIn.readLine();
            System.out.println("Ingrese los numeros de la patente del vehiculo");
            patente=TecladoIn.readLineInt();
            System.out.println("Ingrese cuantas horas permanecio el vehiculo en el estacionamiento");
            horas=TecladoIn.readLineInt();
            montoCobrar=tarifaEstacionamiento(horas,dia);
            if(contador==1){
                patenteMayorEstadia=patente;
                mayorEstadiaHoras=horas;
            }
            else{
                if(horas>mayorEstadiaHoras){
                  mayorEstadiaHoras=horas;
                  patenteMayorEstadia=patente;
                }
            }
            System.out.println("El monto a cobrar por la estadia de este vehiculo es: "+montoCobrar);
            System.out.println("Desea ingresar otro vehiculo? Si/No");
            continuar=TecladoIn.readLine();
        }
        while("si".equalsIgnoreCase(continuar));
        System.out.println("La patente que registra mayor estadia es: "+patenteMayorEstadia);
    }
}
