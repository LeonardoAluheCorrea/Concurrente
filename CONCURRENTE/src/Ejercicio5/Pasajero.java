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
public class Pasajero implements Runnable {
    
    private Taxi taxi;
    
    public Pasajero(Taxi taxi){
        this.taxi = taxi;
    }
    
    @Override
    public void run(){
        taxi.subirseTaxi(); // Paso 1
        System.out.println(Thread.currentThread().getName() + " se subio al taxi");
        taxi.empezarViaje();    // Paso 2
        System.out.println(Thread.currentThread().getName() + " empezo el viaje...");
        taxi.bajarseTaxi(); // Paso 5
        System.out.println(Thread.currentThread().getName() + " se bajo del taxi");
        taxi.liberarAsiento();  // Paso 6
    }
    
}
