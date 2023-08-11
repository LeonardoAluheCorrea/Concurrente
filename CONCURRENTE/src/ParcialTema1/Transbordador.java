/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Transbordador {
    private int autosBarco;
    private boolean orilla; //Nos indicara en que orilla esta el barco. t: Los autos puede subirse. f: Los autos no pueden subirse
    private boolean enRecorrido;

    public Transbordador() {
        this.autosBarco = 0;
        this.orilla = true;
        this.enRecorrido = false;
    }
    
    public synchronized void subir(){
        while(!orilla || !enRecorrido){ 
            try {
                //Si el barco esta lleno o esta en la orilla opuesta esperamos
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si el barco esta en la orilla este y tiene espacio subimos
        autosBarco++;
        System.out.println("Un auto se subio al barco");
        if (autosBarco == 10){
            notifyAll(); //Indicamos que un auto se subio
        }
    }
    
    public synchronized void ir(){
        try {
            boolean espero = false;
            while(!espero && autosBarco < 10){ //Mientras haya espacio para mas autos esperamos
                wait(3000);
                espero = true;
            }
            //Si el barco esta lleno entonces hace el viaje
            System.out.println("El barco sale de viaje con " + autosBarco + " autos");
            enRecorrido = true;
            Thread.sleep(5000);
            System.out.println("El barco llego a la orilla oeste");
            enRecorrido = false;
            orilla = false; //Avisamos que se llego a la orilla oeste
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void bajar(){
        while(orilla || !enRecorrido){ 
            try {
                //Esperamos que el barco llegue a la orilla oeste
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si estamos en la orilla oeste bajamos
        autosBarco--;
        System.out.println("Se baja un auto");
        if (autosBarco == 0) {
            notifyAll(); //Notificamos que nos bajamos del barco
        }
    }
    
    public synchronized void volver(){
        try {
            while(autosBarco > 0){ //Mientas queden autos en el transbordador esperamos
                wait();
            }
            //Si el transbordador esta vacio entonces volvemos
            System.out.println("El barco esta vacio, vuelve");
            Thread.sleep(5000);
            System.out.println("El barco llego a la orilla este");
            orilla = true; //Avisamos que se volvio a la orilla este
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Transbordador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
