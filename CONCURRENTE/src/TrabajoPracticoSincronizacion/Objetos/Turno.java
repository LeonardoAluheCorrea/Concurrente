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
    private int turno = 0;
    private int repeticiones;

    public Turno(int rondas) {
        repeticiones = rondas;
    }

    public synchronized int getRepeticiones() {
        return repeticiones;
    }
    
    public synchronized int getTurno() {
        return turno;
    }
    
    public synchronized void pasarTurno(int cantidad){
        turno = turno + cantidad;
        if (turno >= 6){
            turno = 0;
            repeticiones--;
        }
    }
}
