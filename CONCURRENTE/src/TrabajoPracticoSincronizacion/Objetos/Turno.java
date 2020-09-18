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
public class Turno {
    private int turno = 1;
    private int rondas;

    public Turno(int rondas) {
        this.rondas = rondas;
    }

    public synchronized int getRonda() {
        return rondas;
    }
    
    public synchronized int getTurno() {
        return turno;
    }
    
    public synchronized void pasarTurno(){
        turno++;
        if (turno > 3){
            turno = 1;
        }
    }
}
