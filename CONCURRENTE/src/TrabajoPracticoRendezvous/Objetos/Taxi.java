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
    
    public void transportaCliente(){
        try {
            sem2.acquire();
            Thread.sleep(7000);
            sem1.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void notificarCliente(){
        try {
            sem1.acquire();
            sem2.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void descansa(){
        sem1.release();
        try {
            sem2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llegaCliente(){
        try {
            sem1.acquire();
            sem2.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
