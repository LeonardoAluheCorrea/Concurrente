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
public class Persona implements Runnable{
    private Auto taxi;
    private String rol;

    public Persona(Auto taxi, String rol) {
        this.taxi = taxi;
        this.rol = rol;
    }
    
    public void run() {
        if (rol.equalsIgnoreCase("cliente")) {
            System.out.println("Llega el cliente");
            taxi.llegaCliente();
            System.out.println("Taxista vuelve a dormir");
        }
    }
    
}
