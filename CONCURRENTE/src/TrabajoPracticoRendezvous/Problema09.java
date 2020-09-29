/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.Persona;
import TrabajoPracticoRendezvous.Objetos.Taxi;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){
        Taxi taxi;
        Persona taxista, cliente1, cliente2;
        Thread t1, t2, t3;
        taxi = new Taxi();
        taxista = new Persona(taxi,"taxista");
        cliente1 = new Persona(taxi, "cliente");
        t1 = new Thread(taxista);
        t2 = new Thread(cliente1);
        t1.start();
        t2.start();
    }
}
