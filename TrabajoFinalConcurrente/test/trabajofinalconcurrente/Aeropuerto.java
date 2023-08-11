/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Aeropuerto {
    private Terminal[] terminal;
    private Tren tren;
    private PuestoCheckIn[] puestoCheckIn;
    private Vuelo[] vuelo;
    private boolean abierto;
    private Hall hallEspera;

    public Aeropuerto() {
    }

    public Aeropuerto(Terminal[] terminal, Tren tren, PuestoCheckIn[] puestoCheckIn, Vuelo[] vuelo, Hall hallEspera) {
        this.terminal = terminal;
        this.tren = tren;
        this.puestoCheckIn = puestoCheckIn;
        this.vuelo = vuelo;
        this.abierto = false;
        this.hallEspera = hallEspera;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public Hall getHallEspera() {
        return hallEspera;
    }

    public void setHallEspera(Hall hallEspera) {
        this.hallEspera = hallEspera;
    }

    
    public Terminal[] getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal[] terminal) {
        this.terminal = terminal;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public PuestoCheckIn getPuestoCheckIn(String aerolinea) {
        //Retorna el puesto de check-in de una determinada aerolinea
        PuestoCheckIn p;
        int i = 0;
        //Mientras el puesto no sea de la aerolinea correspondiente seguimos buscando
        while (!puestoCheckIn[i].getAerolinea().equals(aerolinea)){
            i++;
        }
        p = puestoCheckIn[i];
        return p;
    }

    public void setPuestoCheckIn(PuestoCheckIn[] puestoCheckIn) {
        this.puestoCheckIn = puestoCheckIn;
    }

    public Vuelo[] getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo[] vuelo) {
        this.vuelo = vuelo;
    }
    
    public synchronized void abrirAeropuerto(){
        //Notificamos a todos los hilos en espera que pueden entrar al aeropuerto
        System.out.println("El aeropuerto abre sus puertas");
        abierto = true;
        notifyAll();
    }
    
    public synchronized Vuelo entrarPuestoInf(){
        //Le damos al cliente un vuelo al azar, pero solo indicando 
        int n = vuelo.length;
        int i = (int) (Math.random()*(0 - n + 1) + n);
        //Elegimos un vuelo al azar de los que tenemos en nuestro arreglo
        Vuelo v = vuelo[i];
        return v;
    }
    
    public synchronized void entrar(){
        //Permite la entrada al aeropuerto cuando este abierto
        //Mientras el aeropuerto no esta abierto
        do {
            try {
                //Esperamos
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Aeropuerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while(!abierto);
    }
}
