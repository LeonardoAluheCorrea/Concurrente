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
public class MesaConfiteria {
    private Semaphore comida;
    private Semaphore atender;
    private Semaphore bebida;
    private Semaphore lugarLibre;

    public MesaConfiteria() {
        this.lugarLibre = new Semaphore(1);
        this.atender = new Semaphore(0);
        this.comida = new Semaphore(0);
        this.bebida = new Semaphore(0);
    }
    
    public void llegaEmpleado(){
        try {
            lugarLibre.acquire();
            atender.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(MesaConfiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void servirComida(){
        comida.release();
    }
    
    public void comer(){
        try {
            bebida.acquire();
            comida.acquire();
            System.out.println("Comiendo");
            Thread.sleep(10000);
            System.out.println("Termina de comer y se va");
            lugarLibre.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(MesaConfiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarBebida(){
        try {
            atender.acquire();
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MesaConfiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void servirBebida(){
        bebida.release();
    }

}
