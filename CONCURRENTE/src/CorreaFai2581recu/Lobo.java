/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Lobo implements Runnable{
    private Rio rio;

    public Lobo(Rio rio) {
        this.rio = rio;
    }
    
    @Override
    public void run() {
        Random r = new Random();
        while(true){
            try {
                rio.llegaLobo();
                Thread.sleep((r.nextInt(5) + 1) * 1000); //Tarda 1-5 seg en beber agua
                rio.saleLobo();
                Thread.sleep((r.nextInt(10) + 1) * 1000); //Tarda 1-10 seg en regresar al rio
            } catch (InterruptedException ex) {
                Logger.getLogger(Lobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
