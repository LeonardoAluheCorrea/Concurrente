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
public class Vuelo{
    private Terminal terminalEmbarque;
    private int puestoEmbarque;
    private String aerolinea;
    private int nro;
    private int hora; 
    private boolean abordar;
    private int pedidoAbordaje;
    private boolean salio;

    public Vuelo(Terminal terminal, String aerolinea, int puesto, int nro, int hora) {
        this.terminalEmbarque = terminal;
        this.aerolinea = aerolinea;
        this.puestoEmbarque = puesto;
        this.nro = nro;
        this.hora = hora;
        abordar = false;
        salio = false;
        
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Terminal getTerminalEmbarque() {
        return terminalEmbarque;
    }

    public void setTerminalEmbarque(Terminal terminal) {
        this.terminalEmbarque = terminal;
    }

    public int getPuestoEmbarque() {
        return puestoEmbarque;
    }

    public void setPuestoEmbarque(int puesto) {
        this.puestoEmbarque = puesto;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
    
    public synchronized void abilitarAbordaje() {
        //El avion abilita el abordaje y notifica a los pasajeros
        abordar = true;
        System.out.println("El vuelo " + nro + " llama a los pasajeros a abordar");
        notifyAll();
        while(pedidoAbordaje != 0){//Mientras los pasajeros esten abordando
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando los pasajeros hayan abordado el vuelo sale
        salio = true;
        System.out.println("El vuelo " + nro + " de " + aerolinea + " ha despegado");
    }

    public synchronized boolean yaDespego() {
        return salio;
    }

    public synchronized void abordar() {
        //El pasajero coloca su pedido de abordaje
        pedidoAbordaje++;
        while(!abordar){//Mientras no este habilitado el abordaje espera 
            try {
            wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando se habilita el abordaje el pasajero se sube
        pedidoAbordaje--;
        if (pedidoAbordaje == 0){ //Si es el ultimo en subir avisa que puede despegar
            notifyAll();
        }
    }
}
