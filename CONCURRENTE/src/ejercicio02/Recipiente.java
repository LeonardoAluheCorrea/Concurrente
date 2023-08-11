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
public class Recipiente {

    //  Recurso compartido
    
    private int maximo; //Tope maximo de un recipiente para ser lleno
    private int contador; //Contador de hacerAgua
    
    private Semaphore mutex; //Semaforo binario, controla acceso de HListo y OListo
    private Semaphore HListo; //Semaforos que pondran en espera los hilos de H
    private Semaphore OListo; //Semaforo que pondra en espera los hilos de O

    private int contHListo; //Contador de HListos
    private int contOListo; //Contador de OListos

    public Recipiente(int cant) {
        this.maximo = cant;
        this.contador = 0;
        this.contOListo = 0;
        this.contHListo = 0;
        this.mutex = new Semaphore(1);
        HListo = new Semaphore(2);
        OListo = new Semaphore(1);
    }
    
    public void OListo(Oxigeno O) throws InterruptedException {
        // Llega el oxigeno y es retenido hasta que se convierte en agua.
        mutex.acquire();
        System.out.println("El atomo de " + O.getNombre() + " entro al proceso OListo");
        this.contOListo++;
        // Si no hay el suficiente hidrogeno, espero. No pregunto por oxigeno porque solo necesito uno.
        if (this.contHListo <= 1) {
            O.adquirirOxigeno(); //Adquiere semListo de Oxigeno
            //OListo.acquire();
        } else {
            if (this.contHListo >= 2 && this.contOListo >= 1) {
                hacerAgua();
                avisarAtomos();
            }
        }
        mutex.release();
    }
    
    public void HListo(Hidrogeno H) throws InterruptedException {
        // Llega el hidrogeno y es retenido hasta que se convierte en agua.
        mutex.acquire();
        System.out.println("El atomo de " + H.getNombre() + " entro al proceso HListo");
        this.contHListo++;
        // Si no hay el suficiente oxigeno e hidrogeno, espero.
        if (this.contOListo <= 0 || this.contHListo <= 1) {
            H.adquirirHidrogeno(); //Adquiere semListo de Hidrogeno
            //HListo.acquire();
        } else {
            // Si tengo lo necesario, hago agua y aviso a los otros atomos.
            if (this.contHListo >=2 && this.contOListo >=1) {
                hacerAgua();
                avisarAtomos();
            }
        }
        mutex.release();
    }
    
    public void hacerAgua() {
        System.out.println("Se encontraron dos atomos de H y un atomo de O");
        System.out.println("Se formo Agua");
        contador++;
        envasar();
    }
    
    public void envasar() {
        // Si el recipiente está lleno, envaso el agua para la distribucion y reinicio el contador
        if (this.contador == this.maximo) {
            System.out.println("El recipiente se lleno. El agua se envasa para la distribucion");
            this.contador = 0;
            System.out.println("Se vacio el recipiente");
            /*
            this.contHListo = 0;
            this.contOListo = 0;
*/
        }
    }
    
    public void avisarAtomos() {
        // Libero a los 2 de hidrogeno y al de oxigeno que son agua.
        this.HListo.release();
        this.OListo.release();
        
        // Resto lo que acabo de consumir.
        this.contHListo = this.contHListo - 2;
        this.contOListo = (this.contOListo - 1);        
    }
    
}
