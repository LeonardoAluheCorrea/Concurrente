/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fumadore;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String[]args){
        Mesa mesa = new Mesa();
        Thread t1, t2, t3, t4;
        t1 = new Thread(new Fumador(1, 1, mesa));
        t2 = new Thread(new Fumador(2, 2, mesa));
        t3 = new Thread(new Fumador(3, 3, mesa));
        t4 = new Thread(new Agente(mesa));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
