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
public class Cocina {
    private Semaphore cocinando;
    private Semaphore retirarPlato;

    public Cocina() {
        this.cocinando = new Semaphore(0);
        this.retirarPlato = new Semaphore(0);
    }
    
    public void darPedido(){
        cocinando.release();
    }
    
    public void retirarPlato(){
        try {
            retirarPlato.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cocinar(){
        try {
            cocinando.acquire();
            System.out.println("Cocinando");
            Thread.sleep(8000);
            System.out.println("Plato listo");
            retirarPlato.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
