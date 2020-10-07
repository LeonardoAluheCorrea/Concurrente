/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ObjetoHamster {
    private Lock lock = new ReentrantLock();
    private String tipo;

    public ObjetoHamster(String tipo){
        this.tipo = tipo;
    }
    
    public void usar(int segundos){
        try {
            lock.lock();
            System.out.println(tipo + " en uso");
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ObjetoHamster.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            System.out.println(tipo + " fue liberado");
            lock.unlock();
        }
    }
    
        public boolean estaOcupada(){
            return !lock.tryLock();
    }
}
