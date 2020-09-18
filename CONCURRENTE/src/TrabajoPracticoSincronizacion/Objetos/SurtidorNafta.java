/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion.Objetos;

/**
 *
 * @author Leo
 */
public class SurtidorNafta {
    private boolean disponibilidad;
    
    public SurtidorNafta(){
        disponibilidad = true;
    }

    public synchronized boolean tieneDisponibilidad() {
        return disponibilidad;
    }
    
    public synchronized void usarSurtidor(Auto auto)throws InterruptedException{
        System.out.println("El auto: " + auto.getModelo() + " esta llenando el tanque");
        Thread.sleep((long)((auto.getCapacidadCombustible() - auto.getCombustibleRestante()) * 100));
        auto.llenarTanque();
        System.out.println("El auto: " + auto.getModelo() + " ha llenado el tanque, libera el surtidor y se va");
    }
    
}
