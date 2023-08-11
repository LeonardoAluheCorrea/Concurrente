/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeEmpleadosModificado;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Saludo{
    Semaphore mutex;

    public Saludo() {
        this.mutex = new Semaphore(0);
    }
    
    public void esperarEmpleados(){
        System.out.println("Esperando...");
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    synchronized void esperarJefe(String empleado, boolean ultimoEnLlegar){
        try{
            if(ultimoEnLlegar) mutex.release();
            wait();
            System.out.println(empleado + "> Buenos dias jefe!");
        }
        catch (InterruptedException e){
            System.out.println(e.toString());
        }
    }

    synchronized void saludoJefe(){
        System.out.println("JEFE> Buenos dias!");
        notifyAll();
    }
    
}