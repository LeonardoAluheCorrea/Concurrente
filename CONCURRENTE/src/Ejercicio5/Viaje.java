/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author gabriel.fierro
 */
public class Viaje {
    
    public static void main(String[] args){
        Taxi taxi = new Taxi(); // Recurso compartido
        Taxista taxista = new Taxista(taxi);    // Hilo
        Pasajero pasajero = new Pasajero(taxi); // Hilo
        Thread hiloTaxista = new Thread(taxista);
        Thread hiloPasajero[] = new Thread[3];
        
        for(int i=0; i < hiloPasajero.length; i++){
            hiloPasajero[i] = new Thread(pasajero, "Pasajero: " + (i+1));
        }
        
        for(int i=0; i < hiloPasajero.length; i++){
            hiloPasajero[i].start();
        }
        
        hiloTaxista.start();
        
    }
    
}
