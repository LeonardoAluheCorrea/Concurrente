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
public class Problema02 {
    public static void main(String[]args){
        String nombre;
        int inasistencias,monto,montoFin;
        System.out.println("Ingrese el nombre del trabajador ");
        nombre=TecladoIn.readWord();
        System.out.println("Ingrese la cantidad de inasistencias");
        inasistencias=TecladoIn.readLineInt();
        
        if(inasistencias>=6){
            System.out.println("A "+nombre+" no le corresponde cobrar el bono por buena asistencia");
            
        }
        else{
            System.out.println("A "+nombre+" le corresponde cobrar el bono por buena asistencia");
            monto=inasistencias*500;
            montoFin=3000-monto;
            System.out.println("El monto a percibir es "+montoFin);
        }
        
    }
    
}
