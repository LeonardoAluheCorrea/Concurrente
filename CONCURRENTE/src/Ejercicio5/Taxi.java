/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.fierro
 */
public class Taxi {
    // Clase que trabaja la exclusion mutua por lo que debo crear semaforos en la misma
    private Semaphore semAsiento = new Semaphore(1);
    private Semaphore semConducir = new Semaphore(0);
    private Semaphore semBajarse = new Semaphore(0);
    
    public void conducir(){
        try {
            semConducir.acquire(); // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarViaje(){
        semBajarse.release();   // Libera el permiso 0 --> 1
    }
    
    public void subirseTaxi(){
        try {
            semAsiento.acquire();   // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void empezarViaje(){
        semConducir.release();  // Libera el permiso 0 --> 1
    }
    
    public void bajarseTaxi(){
        try {
            semBajarse.acquire();   // Toma el permiso 1 --> 0
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void liberarAsiento(){
        semAsiento.release();   // Libera el permiso 0 --> 1
    }
    
}
