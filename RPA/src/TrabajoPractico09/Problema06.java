/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author leonardo.correa
 */
public class Problema06 {
    public static int calificacion (int resCorrectas, int resIncorrectas){
        int calificacion;
        calificacion=resCorrectas*2-resIncorrectas;
        if(calificacion<0){
            calificacion=0;
        }
        return calificacion;
    }
    public static void main(String[]args){
        int examenes,promedio,resCorrectas,resIncorrectas,totalCalf;
        String continuar;
        continuar="si";
        examenes=0;
        while (continuar=="si"){
            System.out.println("Ingrese la cantidad respuestas correctas");
            resCorrectas=TecladoIn.readLineInt();
            resIncorrectas=TecladoIn.readLineInt();
            System.out.println("La calificacion del examen es: "+calificacion(resCorrectas,resIncorrectas));
            examenes++;
            totalCalf=totalCalf+calificacion(resCorrectas,resIncorrectas);
        }
    }    
}
