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
public class Empleado extends Persona implements Runnable {
    private MesaConfiteria mesa;
    
    public Empleado(String nombreApellido, MesaConfiteria mesa) {
        super(nombreApellido);
        this.mesa = mesa;
    }

    @Override
    public void run() {
        System.out.println("Llega el empleado");
        mesa.llegaEmpleado();
        System.out.println("El empleado hace su pedido y espera que llegue");
        mesa.comer();
    }
    
}
