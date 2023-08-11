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
public class Turno {
    private Semaphore mutex1;
    private Semaphore mutex2;
    private Semaphore mutex3;

    public Turno() {
        mutex1 = new Semaphore(1);
        mutex2 = new Semaphore(0);
        mutex3 = new Semaphore(0);
    }
    
    public void primerTurno(){
        try {
            mutex1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void finalizarPrimerTurno(){
        mutex2.release();
    }
    
    public void segundoTurno(){
        try {
            mutex2.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void finalizarSegundoTurno(){
        mutex3.release();
    }
    
    public void tercerTurno(){
        try {
            mutex3.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
