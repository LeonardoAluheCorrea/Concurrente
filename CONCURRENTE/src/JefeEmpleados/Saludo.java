/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeEmpleados;

/**
 *
 * @author Leo
 */
public class Saludo {

    public synchronized void esperarJefe(String empleado) {
        try {
            wait();
            System.out.println(empleado + "> Buenos dias jefe!");
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    
    public synchronized void saludoJefe() {
        System.out.println("JEFE> Buenos dias!");
        notifyAll();
    }
}
