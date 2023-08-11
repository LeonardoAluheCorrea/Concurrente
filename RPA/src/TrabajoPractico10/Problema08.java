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
public class Problema08 {    
    public static void main(String[]args){
        double tiempoTotal=0,acuTiempoTotal=0,tiempo,ganador=0;
        int equipo,corredores;
        String nomEquipo,nomGanador="e";
        System.out.println("Ingrese cuantos equipos hay en la competencia");
        equipo=TecladoIn.readLineInt();
        for(int i=0;i<equipo;i++){
            System.out.println("Ingrese el nombre del equipo");
            nomEquipo=TecladoIn.readLine();
            System.out.println("Ingrese la cantidad de corredores del equipo");
            corredores=TecladoIn.readLineInt();
            for(int j=0;j<corredores;j++){
                System.out.println("Ingrese el tiempo del corredor");
                tiempo=TecladoIn.readLineDouble();
                tiempoTotal=tiempoTotal+tiempo;
            }
                    System.out.println("El tiempo total del equipo es "+tiempoTotal);
                    System.out.println("El tiempo promedio del equipo "+tiempoTotal/corredores);
                    if(tiempoTotal<=acuTiempoTotal){
                    ganador=tiempoTotal;
                    nomGanador=nomEquipo;
                    }
                    acuTiempoTotal=tiempoTotal;
                    tiempoTotal=0;

                    
                
           
            
        }
        System.out.println("El equipo ganador es "+nomGanador);
        System.out.println("Su tiempo fue de "+ganador);
    }
}
