/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable{
    private MontaniaRusa montania;

    public Persona(MontaniaRusa montania) {
        this.montania = montania;
    }
    
    @Override
    public void run() {
        try {
            while(montania.estaAbierta()){ //Mientras la montaña esta abierta
                montania.subirse();
                montania.bajarse();
                System.out.println("Una persona va a dar vuelta por el parque");
                Thread.sleep(5000);
                System.out.println("Una persona regresa a la montaña rusa");
            }
            System.out.println("Al ver que la montaña ha cerrado la persona se va");
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
