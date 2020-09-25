/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.Persona;
import TrabajoPracticoRendezvous.Objetos.Auto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){
        Auto taxi;
        Persona taxista, cliente1, cliente2;
        Thread t1, t2, t3;
        taxi = new Auto();
        taxista = new Persona(taxi, "taxista");
        cliente1 = new Persona(taxi,"cliente");
        cliente2 = new Persona(taxi, "cliente");
        t1 = new Thread(taxista);
        t2 = new Thread(cliente1);
        t3 = new Thread(cliente2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Problema09.class.getName()).log(Level.SEVERE, null, ex);
        }
        t3.start();
    }
}
