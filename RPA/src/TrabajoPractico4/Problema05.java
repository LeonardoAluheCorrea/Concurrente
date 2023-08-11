/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico4;

import Utiles.TecladoIn;

/**
 *
 * @author Leo
 */
public class Problema05 {
    public static void main(String[]args){
        //calcula el combustible necesario para viajar determinadas distancias
        System.out.println("Este programa caclulara cuanto combustible necesita para su viaje");
        //Declaramos las variables
        double distanciaViaje, combustible;
        final int consumoDistancia, consumoLitros;
        consumoDistancia=100;
                consumoLitros=8;
        System.out.println("Ingrese la distancia a recorrer en kilometros:");
        distanciaViaje=TecladoIn.readLineInt();
        combustible=distanciaViaje/consumoDistancia*consumoLitros;
        System.out.print("Necesitara: ");
        System.out.print(combustible);
        System.out.print("litros para viajar ");
        System.out.print(distanciaViaje);
        System.out.println("kilometros");
        
                
    
}}
