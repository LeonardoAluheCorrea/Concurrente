/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelojAlarma;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable{
    private Semaphore despertar;
    private int nombre;
    private Persona[] barrio;
    private int pos;
    private int hora;
    private Reloj r;

    public Persona(int nombre, int pos, int hora, Reloj r) {
        this.nombre = nombre;
        this.pos = pos;
        this.hora = hora;
        this.r = r;
        despertar = new Semaphore(0);
    }

    public void setBarrio(Persona[] barrio) {
        this.barrio = barrio;
    }

    public void despertar(){
        despertar.release();
    }    

    public int getHora() {
        return hora;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                despertar.acquire();//Dormimos
                barrio[pos + 1].despertar();//Despertamos al vecino, la posicion que sigue en el arreglo de Personas
                if (r.getHora() == hora) { //Si es hora de trabajar entonces
                    System.out.println(nombre + " se pone trabajar");
                    Thread.sleep(2000);
                }
                System.out.println(nombre + " vuelve a dormir");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
