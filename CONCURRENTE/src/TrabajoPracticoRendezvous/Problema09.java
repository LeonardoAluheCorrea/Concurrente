/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.Cliente;
import TrabajoPracticoRendezvous.Objetos.Persona;
import TrabajoPracticoRendezvous.Objetos.Taxi;
import TrabajoPracticoRendezvous.Objetos.Taxista;

/**
 *
 * @author Leo
 */
public class Problema09 {
    public static void main(String[]args){
        Taxi taxi;
        Taxista taxista;
        Cliente cliente;
        Thread t1, t2;
        taxi = new Taxi();
        taxista = new Taxista(taxi,"taxista");
        cliente = new Cliente(taxi, "cliente");
        t1 = new Thread(taxista);
        t2 = new Thread(cliente);
        t1.start();
        t2.start();
    }
}
