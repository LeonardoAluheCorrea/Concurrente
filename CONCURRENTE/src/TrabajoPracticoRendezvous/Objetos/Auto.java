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
public class Auto {
    private Semaphore sem2;
    private Semaphore sem1;

    public Auto(){
        sem1 = new Semaphore(1);
    }

    private void llevarCliente() throws InterruptedException {
        System.out.println("Sale el taxi");
        Thread.sleep(5000);
        System.out.println("Taxista notifica llegada a destino");
    }
    
    public void llegaCliente() {
        try {
            sem1.acquire();
            System.out.println("Despierta al taxista");
            llevarCliente();
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            sem1.release();
        }
    }
    
    
}
