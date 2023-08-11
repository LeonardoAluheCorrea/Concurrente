/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fumadore;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Agente implements Runnable{
    private Mesa mesa;

    public Agente(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        Random r = new Random();
        int i;
        while(true){
            try {
                i = r.nextInt(3) + 1;
                System.out.println("El agente rellena los ingredientes");
                mesa.dejarIngrediente(i);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
