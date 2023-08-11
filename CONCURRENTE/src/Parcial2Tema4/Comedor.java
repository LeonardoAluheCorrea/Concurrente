/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2Tema4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Comedor {
    private Semaphore comer; //Indica los platos llenos, un perro debera tomar un permiso para poder comer
    private Semaphore llenarPlatos; //Cuando se active el cuidador llenara los platos
    private Semaphore pedido; //Nos indica si algun perro pidio que se llenen los platos
    private final int cantPlatos;

    public Comedor(int cantPlatos) {
        //Comenzaremos con todos los platos vacios
        pedido = new Semaphore(0);
        this.cantPlatos = cantPlatos;
        comer = new Semaphore(0);
        llenarPlatos = new Semaphore(1);
    }
    
    public void llenarPlatos(){
        try {
            llenarPlatos.acquire();
            //Llena todos los platos
            //Tomara 5 seg en hacerlo
            Thread.sleep(5000);
            System.out.println("Se llenaron todos los platos");
            comer.release(cantPlatos);
            //Indicamos que se atendio el pedido de llenar los platos
            pedido.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void comer(){
        try {
            System.out.println("Un perro empezo a comer");
            Thread.sleep(3000);
            System.out.println("Un perro termino de comer");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void intentarComer(){
        //Intenta obtener un plato, si lo obtiene come y se va
        if (comer.tryAcquire()){
            comer();
        }
        else{
            //Si todos los platos estan ocupados entonces se fija si algun perro pidio que los llenaran
                if (pedido.tryAcquire()){
                    //Si ningun otro perro hizo el pedido entonces lo hace el
                    System.out.println("Un perro pide que llenen los platos");
                    llenarPlatos.release();
            }
        }
    }
}
