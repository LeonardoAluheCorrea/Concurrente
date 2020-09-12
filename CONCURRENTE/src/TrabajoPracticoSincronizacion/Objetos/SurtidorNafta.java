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
    
    public synchronized void usarSurtidor(){
        disponibilidad = false;
    }
    
    public synchronized void liberarSurtidor(){
        disponibilidad = true;
    }
    
}
