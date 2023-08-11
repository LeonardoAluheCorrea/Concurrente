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
public class Chofer implements Runnable{
    private Tren tren;
    private Terminal[] terminal;

    public Chofer(Tren tren, Terminal[] terminal) {
        this.tren = tren;
        this.terminal = terminal;
    }

    @Override
    public void run() {
        while (true) {
            //El chofer comenzara el recorrido cuando el tren este lleno
            tren.comenzarRecorrido();
            int i;
            int n = terminal.length;
            Terminal t;
            for (i = 0; i < n; i++) {try {
                //Para todas las terminales
                //Viajamos hasta la proxima terminal
                t = terminal[i];
                tren.viajar(t);
                Thread.sleep(1000); //Tiempo que dura el viaje
                System.out.println("El tren esta pasando frente a la terminal " + t.getNombre());
                //Detenemos el tren si es necesario
                tren.frenarTren();
                tren.continuarRecorrido();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(Chofer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Cuando ya paso por todas las terminales el tren regresa al comienzo terminando el recorrido
            tren.terminarRecorrido();
        }
    }
}
