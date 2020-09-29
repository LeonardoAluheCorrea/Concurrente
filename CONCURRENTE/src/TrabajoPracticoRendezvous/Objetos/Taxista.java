/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

/**
 *
 * @author Leo
 */
public class Taxista extends Persona implements Runnable {
    private Taxi taxi;

    public Taxista(Taxi taxi, String nombreApellido) {
        super(nombreApellido);
        this.taxi = taxi;
    }
    
    @Override
    public void run(){
        System.out.println("El taxista duerme mientras espera un cliente...");
        taxi.llevarCliente();
        System.out.println("El taxista notifica al cliente que se llego a destino");
        taxi.notificarCliente();
        
    }
}
