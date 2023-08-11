/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Taxi {
    private Semaphore sem1;
    private Semaphore sem2;

    public Taxi(){
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
    }
    
    public void descansar(){
        sem2.release();
    }
    
    public void despertarTaxista(){
        sem1.release();
    }
    
    public void bajarse(){
        try {
            sem2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llevarCliente(){
        try {
            sem1.acquire();
            System.out.println("El taxi sale");
            Thread.sleep(10000);
            System.out.println("El taxi llega");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void notificarCliente(){
        sem2.release();
    }
    
}
