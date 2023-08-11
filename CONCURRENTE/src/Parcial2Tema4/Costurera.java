/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2Tema4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Costurera {
    private int cantMangas;
    private int cantCuerpos;
    private int maxMangas;
    private int maxCuerpos;
    private int totalSueters;
    private final Lock mutex = new ReentrantLock();
    private Condition mangas;
    private Condition cuerpos;

    public Costurera(int maxMangas, int maxCuerpos) {
        this.maxMangas = maxMangas;
        this.maxCuerpos = maxCuerpos;
        this.cantMangas = 0;
        this.cantCuerpos = 0;
        this.totalSueters = 0;
        this.mangas = mutex.newCondition();
        this.cuerpos = mutex.newCondition();
    }
    
    public void cuerpo(){
         try {
            mutex.lock();
            while(cantCuerpos == maxCuerpos){
                cuerpos.await();
            }
            mutex.unlock();
            Thread.sleep(6000);
            mutex.lock();
             System.out.println("Añade un cuerpo al cesto");
            cantCuerpos++;
            cuerpos.signal();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Costurera.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            mutex.unlock();
        }
    }
    
    public void sueter(){
        try {
            mutex.lock();
            while(cantMangas < 2){
                mangas.await();
            }
            System.out.println("Saca un par de mangas del cesto");
            cantMangas = cantMangas - 2;
            mangas.signal();
            while(cantCuerpos < 1){
                cuerpos.await();
            }
            System.out.println("Saca un cuerpo del cesto.");
            cantCuerpos--;
            cuerpos.signal();
            mutex.unlock();
            Thread.sleep(8000);
            System.out.println("Se completo un sueter");
            totalSueters++;
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Costurera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mangas(){
        try {
            mutex.lock();
            while(cantMangas == maxMangas){
                mangas.await();
            }
            mutex.unlock();
            Thread.sleep(6000);
            mutex.lock();
            System.out.println("Añade un par de mangas al cesto");
            cantMangas = cantMangas + 2;
            mangas.signal();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Costurera.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            mutex.unlock();
        }
    }
    
}
