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
public class Mozo extends Persona implements Runnable {
    private MesaConfiteria mesa;
    private Cocina cocina;
    
    public Mozo(String nombreApellido, MesaConfiteria mesa, Cocina cocina) {
        super(nombreApellido);
        this.mesa = mesa;
        this.cocina = cocina;
    }

    @Override
    public void run() {
        mesa.buscarBebida();
        System.out.println("El mozo busca la bebida para el empleado");
        System.out.println("El mozo sirve la bebida");
        mesa.servirBebida();
        System.out.println("Ahora el mozo va a la cocina y entrega el pedido al cocinero");
        cocina.darPedido();
        cocina.retirarPlato();
        System.out.println("El mozo retira el plato de la cocina y se lo lleva al empleado");
        mesa.servirComida();
        System.out.println("El mozo vuelve a su hobby");
    }
    
}
