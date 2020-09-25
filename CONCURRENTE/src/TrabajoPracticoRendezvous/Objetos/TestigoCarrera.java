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
    private Semaphore sem2;

    public TestigoCarrera() {
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
    }
    
    public void saleCorredor(String nombre){
        try {
            sem1.acquire();
            System.out.println("El corredor " + nombre +" comienza su turno");
            Thread.sleep(((long) Math.random() * (11 - 9) + 9) * 1000);
            System.out.println("El corredor " + nombre +" finaliza su turno");
        } catch (InterruptedException ex) {
            Logger.getLogger(TestigoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            sem2.release();
        }
    }
    
    public void vuelveCorredor(String nombre){
        try {
            sem2.acquire(); 
            System.out.println("El corredor " + nombre + " comienza su turno");
            Thread.sleep(((long) (Math.random() * (11 - 9) + 9) * 1000));
            System.out.println("El corredor " + nombre + " finaliza su turno");
        } catch (InterruptedException ex) {
            Logger.getLogger(TestigoCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            sem1.release();
        }
    }
    
}
