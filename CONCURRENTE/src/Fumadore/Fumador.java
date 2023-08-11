/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fumadore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Fumador implements Runnable{
    private int ingrediente;
    private int id;
    private Mesa mesa;

    public Fumador(int ingrediente, int id, Mesa mesa) {
        this.ingrediente = ingrediente;
        this.id = id;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while(true){
            try {
                mesa.tomarIngredientes(ingrediente);
                System.out.println(id + " esta fumando");
                Thread.sleep(5000);
                System.out.println(id + " termino de fumar, espera ingredientes para otro cigarrillo");
            } catch (InterruptedException ex) {
                Logger.getLogger(Fumador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}
