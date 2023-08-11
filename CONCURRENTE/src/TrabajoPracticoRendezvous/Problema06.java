/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.CadenaLetras;
import TrabajoPracticoRendezvous.Objetos.Turno;

/**
 *
 * @author Leo
 */
public class Problema06 {
        public static void main(String[]args){
        Turno arbitro;
        CadenaLetras a,b,c;
        arbitro = new Turno();
        a = new CadenaLetras(arbitro, 'A', 1);
        b = new CadenaLetras(arbitro, 'B', 2);
        c = new CadenaLetras(arbitro, 'C', 3);
        Thread t1,t2,t3;
        t1 = new Thread(a);
        t2 = new Thread(b);
        t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}
