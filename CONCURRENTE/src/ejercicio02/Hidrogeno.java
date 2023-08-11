/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02;

import java.util.concurrent.Semaphore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casa
 */
public class Hidrogeno implements Runnable {

    private Recipiente r;
    private Semaphore semListo; //Semaforo binario: comunicacion entre Hidrogeno y Recipiente

    public Hidrogeno(Recipiente recip) {
        this.r = recip;
        this.semListo = new Semaphore(1);
    }

    public String getNombre() {
        return Thread.currentThread().getName();
    }

    public void adquirirHidrogeno() {
        try {
            this.semListo.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hidrogeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        vagarPorElEspacio();
        //Libera semListo de Hidrogeno
        //this.semListo.release();
        try {
            //Entra en el proceso HListo de Recipiente
            r.HListo(this);
            //Adquiere HListo de Recipiente
            //r.avisoHidrogeno();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hidrogeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vagarPorElEspacio() {
        System.out.println("El atomo " + Thread.currentThread().getName() + " esta vagando por el espacio");
        try {
            Thread.sleep((long) (Math.random() * 1500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Hidrogeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
