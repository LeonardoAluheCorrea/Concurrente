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
public class Persona implements Runnable{
    private Taxi taxi;
    private String rol;

    public Persona(Taxi taxi, String rol) {
        this.taxi = taxi;
        this.rol = rol;
    }
    
    public void run() { 
        if (rol.equalsIgnoreCase("taxista")){
            System.out.println("El taxista duerme esperando un cliente");
            taxi.descansa();
            taxi.transportaCliente();
            System.out.println("El taxi llega a destino");
            taxi.notificarCliente();
            System.out.println("El taxista informa al cliente que llegaron");
            taxi.descansa();
            System.out.println("El taxista continua durmiendo");
        }
        if (rol.equalsIgnoreCase("Cliente")){
            System.out.println("El cliente va camino al taxi...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("El cliente llega, despierta al taxista y salen");
            taxi.llegaCliente();
        }
    }
    
}
