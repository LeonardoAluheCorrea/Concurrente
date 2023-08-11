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
public class Cocinero extends Persona implements Runnable{
    private Cocina cocina;
    
    public Cocinero(String nombreApellido, Cocina cocina) {
        super(nombreApellido);
        this.cocina = cocina;
    }

    @Override
    public void run() {
        System.out.println("El cocinero espera que el mozo le entregue un pedido");
        cocina.cocinar();
        System.out.println("El cocinero continua esperando");
    }
    
}
