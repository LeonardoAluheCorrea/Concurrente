/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Taxista implements Runnable{
    
    private Taxi taxi;
    
    public Taxista(Taxi taxi){
        this.taxi = taxi;
    }
    
    @Override
    public void run(){
        while(true){
            taxi.conducir();    // Paso 3
            viajar();   // Paso 3.1
            taxi.terminarViaje();   // Paso 4
        }
    }
    
    private void viajar(){
        System.out.println("Viajando...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
