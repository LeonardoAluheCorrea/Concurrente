/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Cliente extends Persona implements Runnable {
    private Taxi taxi;

    public Cliente(Taxi taxi, String nombreApellido) {
        super(nombreApellido);
        this.taxi = taxi;
    }

    @Override
    public void run(){
        System.out.println("El cliente camina hacia el taxi...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El cliente llega, despierta al taxista y pide que lo lleve");
        taxi.despertarTaxista();
        System.out.println("El cliente espera la notificacion para bajarse del taxi");
        taxi.bajarse();
        System.out.println("El cliente se baja del taxi");
    }
    
}
