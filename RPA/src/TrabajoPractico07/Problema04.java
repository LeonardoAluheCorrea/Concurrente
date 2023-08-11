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
public class Problema04 {
    public static void main(String[]args){
        int promedio,edad;
        double distancia;
        System.out.println("Ingrese su edad");
        edad=TecladoIn.readLineInt();
        System.out.println("Ingrese su promedio de la secundaria");
        promedio=TecladoIn.readLineInt();
        System.out.println("Ingrese a cuantos kilometro vive de la ciudad de Neuquen");
        distancia=TecladoIn.readLineDouble();
        if((promedio>=7&&edad<25)||(distancia>30)){
        System.out.println("Puede acceder a la beca");
    }
        else{
            System.out.println("No puede acceder a la beca");
        }
        
    }
    
}
