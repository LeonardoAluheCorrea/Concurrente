/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.Corredor;
import TrabajoPracticoRendezvous.Objetos.TestigoCarrera;

/**
 *
 * @author Leo
 */
public class Problema08 {
    public static void main (String[]args){
        Corredor a,b,c,d;
        Thread t1, t2, t3, t4;
        TestigoCarrera testigo;
        testigo = new TestigoCarrera();
        a = new Corredor("A", testigo, 2, System.currentTimeMillis());
        b = new Corredor("B", testigo, 2, System.currentTimeMillis());
        c = new Corredor("C", testigo, 1, System.currentTimeMillis());
        d = new Corredor("D", testigo, 1, System.currentTimeMillis());
        t1 = new Thread(a);
        t2 = new Thread(b);
        t3 = new Thread(c);
        t4 = new Thread(d);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
