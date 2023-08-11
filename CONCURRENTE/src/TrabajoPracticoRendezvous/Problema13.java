/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous;

import TrabajoPracticoRendezvous.Objetos.Cocina;
import TrabajoPracticoRendezvous.Objetos.Cocinero;
import TrabajoPracticoRendezvous.Objetos.Empleado;
import TrabajoPracticoRendezvous.Objetos.MesaConfiteria;
import TrabajoPracticoRendezvous.Objetos.Mozo;

/**
 *
 * @author Leo
 */
public class Problema13 {
    
    public static void main (String[]args){
        Cocina cocina = new Cocina();
        MesaConfiteria mesa = new MesaConfiteria();
        Mozo mozo = new Mozo("",mesa,cocina);
        Cocinero cocinero = new Cocinero("",cocina);
        Empleado empleado = new Empleado("",mesa);
        Thread t1,t2,t3;
        t1 = new Thread(empleado);
        t2 = new Thread(cocinero);
        t3 = new Thread(mozo);
        t1.start();
        t2.start();
        t3.start();
    }
}
