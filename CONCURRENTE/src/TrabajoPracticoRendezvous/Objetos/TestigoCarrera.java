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
public class TestigoCarrera {
    private Semaphore sem1;

    public TestigoCarrera() {
        this.sem1 = new Semaphore(1);
    }
    
    public void recibeTestigo(){
        try {
            sem1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestigoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void corre(){
        try {
            Thread.sleep((long) (Math.random() * (11 - 9) + 9) * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestigoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void entregaTestigo(){
        sem1.release();
    }
    
}
