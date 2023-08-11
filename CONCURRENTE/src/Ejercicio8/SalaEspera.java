/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class SalaEspera {
    private int revistasTomadas;
    private Semaphore camillas;
    private final Lock mutex = new ReentrantLock();
    private final Condition revistas;

    public SalaEspera() {
        revistas = mutex.newCondition(); //La cantidad de revistas libre;
        camillas = new Semaphore(4); //La cantidad de camillas que se tienen
        revistasTomadas = 0;
    }

    public void extraerSangre(int id) {
        try {
            //La extraccion tomara como minimo 5 segundos
            System.out.println(id + " esta extrayendo sangre");
            Thread.sleep(new Random().nextInt(10) * 1000 + 5000);
            //Ahora liberamos la camilla
            System.out.println(id + " termino la extraccion de sangre");
            camillas.release(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaEspera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void esperarExtraccion(int id){
        //Espera a que se libere alguna camilla
        try {
            camillas.acquire();
            //Cuando se libera una camilla deja la revista y luego se dirije a hacer la extraccion de sangre
            mutex.lock();
            System.out.println(id + " deja la revista y va hacia la camilla");
            revistasTomadas--;
            revistas.signalAll();
            extraerSangre(id);
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaEspera.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mutex.unlock();
        }
    }
    
    public void esperarRevista(){
        //Mientras espera la persona intentara tomar una revista
        mutex.lock();
        while(revistasTomadas == 9){
            try {
                //Si no hay revistas disponibles entonces esperara a que se libere alguna
                //No podra acceder a las camillas en caso de que se libere alguna porque la gente que tomo las revistas llego antes y sera atendida primero
                revistas.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalaEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si hay una revista disponible entonces la toma
        revistasTomadas++;
        mutex.unlock();
    }

    public boolean entrarSala(int id) {
        //Cuando llega alguien se fija si hay camillas disponibles
        boolean obtuvoCamilla;
        obtuvoCamilla = camillas.tryAcquire();
        if (obtuvoCamilla) {
            extraerSangre(id);
        }
        //Si no hay camillas disponibles la persona debera ir a la sala de espera
        return obtuvoCamilla;
    }
    
}
