/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Reloj implements Runnable {
    private int hora;
    private Aeropuerto aeropuerto;
    private Vuelo[] vuelo;

    public Reloj(Aeropuerto aeropuerto, Vuelo[] vuelo) {
        this.hora = 5; //comenzamos a las 5 am para saltar el horario en el que el aeropuerto esta cerrado
        this.aeropuerto = aeropuerto;
        this.vuelo = vuelo;
    }

    public double getHora() {
        return hora;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Son las " + hora);
            if (hora == 6) {
                //Abrimos el aeropuerto a las 6 am
                aeropuerto.abrirAeropuerto();
            }
            //Buscamos en el arrelgo de vuelos si a alguno le corresponde salir
            activarVuelo();
            if (hora == 24) { //Si son las 12am saltamos a las 5 am
                hora = 5;
            }
            try {
                //Esperamos 10 segundos, esto sera 1 hora
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
            hora++;
        }
    }
    
    public void activarVuelo(){
        int n = vuelo.length;
        for (int i = 0; i < n; i++){//Para todos los vuelos 
            Vuelo v = vuelo[i];
            if (v.getHora() == hora){//Si el vuelo debe salir a esta hora, permitimos que los pasajeros comienzen a abordar
                v.abilitarAbordaje();
            }
        }
    }

}
