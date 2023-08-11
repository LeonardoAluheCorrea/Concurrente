/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Termometro implements Runnable{
    private GestorSala gestor;

    public Termometro(GestorSala gestor) {
        this.gestor = gestor;
    }
    
    @Override
    public void run() {
        while (true){
            gestor.notificarTemperatura();
            try {
                //Mediremos la temperatura cada 5 segundos
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Termometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
