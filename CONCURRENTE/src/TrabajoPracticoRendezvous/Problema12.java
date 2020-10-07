/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.ObjetoHamster;
import TrabajoPracticoRendezvous.Objetos.Hamster;

/**
 *
 * @author Leo
 */
public class Problema12 {
    public static void main (String[]args){
        ObjetoHamster hamaca, rueda, plato;
        Hamster hamster1, hamster2, hamster3;
        Thread t1, t2, t3;
        hamaca = new ObjetoHamster("hamaca");
        rueda = new ObjetoHamster("rueda");
        plato = new ObjetoHamster("plato");
        hamster1 = new Hamster(plato,rueda,hamaca, "Bola de nieve");
        hamster2 = new Hamster(plato,rueda,hamaca, "Capablanca");
        hamster3 = new Hamster(plato,rueda,hamaca, "Peluza");
        t1 = new Thread(hamster1);
        t2 = new Thread(hamster2);
        t3 = new Thread(hamster3);
        t1.start();
        t2.start();
        t3.start();
    }
}
