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
public class Problema08 {
    public static void main(String[]args){
        //Este algoritmo procesa los datos de una escuesta y nos da:
        /*Promedio de edad*/
        /*Nombre y apellido de la persona que visito mas paises*/
        /*Indica si puede participar en sorteo*/
        double promedio;
        String name, estCiv, namePaises;
        namePaises = "";
        estCiv = "";
        int n, paises, edad, acuEdad, masPaises;
        masPaises = 0;
        acuEdad = 0;
        System.out.println("Ingrese el numero de personas entrevistadas");
        n = TecladoIn.readLineInt();
        for (int i = 0; i < n; i++){
            System.out.println("Nombre y apellido");
            name = TecladoIn.readLineWord();
            System.out.println("Cantidad de paises visitados");
            paises = TecladoIn.readLineInt();
            if (paises > masPaises){
                masPaises = paises;
                namePaises = name;
                }
            System.out.println("Edad");
            edad = TecladoIn.readLineInt();
            acuEdad = acuEdad + edad;
            System.out.println("Estado Civil");
            estCiv = TecladoIn.readLineWord();;
            if (sorteo(edad, estCiv))
                System.out.println("Puede participar del sorteo");
            else 
                System.out.println("No puede participar del sorteo");
        }
        System.out.println("El promedio de edad de los entrevistados es: "+promedio(acuEdad, n));
        System.out.println("La persona que mas paises visito es: "+namePaises);
    }
    
    public static double promedio(int suma, int cant){
        //Calcula promedios
        double prom;
        prom = suma/cant;
        return prom;
    }
    
    public static boolean sorteo(int edad, String estadoCiv){
        boolean sorteo;
        sorteo = edad >45 && edad < 62 && "soltero".equals(estadoCiv);
        return sorteo;
    }
}
