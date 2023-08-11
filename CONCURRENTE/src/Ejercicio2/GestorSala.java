/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class GestorSala {
    private int capacidadMaxima;
    private int ocupacion;
    private int temperatura;
    private int colaJubilados;

    public GestorSala() {
        capacidadMaxima = 50;
        ocupacion = 0;
        temperatura = 20;
        colaJubilados = 0;
    }
    
    public synchronized void entrarSala(){
        while ((ocupacion >= capacidadMaxima) || (colaJubilados > 0)){
            System.out.println("La sala esta llena o hay jubilados esperando entrar");
            //La persona debe esperar a que alguien salga y que los jubilados hayan entrado para poder entrar
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando salga del while significa que entro a la sala, incrementamos la ocupacion
        ocupacion++;
    }
    
    public synchronized void entrarSalaJubilado(){
        while (ocupacion >= capacidadMaxima){
            try {
                System.out.println("La sala esta llena");
                //Como la persona es un jubilado incrementamos la cola de jubilados
                colaJubilados++;
                //La persona debe esperar a que alguien salga para poder entrar
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando salga del while significa que entro a la sala, incrementamos la ocupacion y reducimos la cola de jubilados
        ocupacion++;
        colaJubilados++;
    }
    
    public synchronized void notificarTemperatura(){
        Random r;
        r = new Random();
        //Usamos un random para simular los cambios de temperatura
        temperatura = r.nextInt(40) + 1;
        System.out.println("La temperatura actual es: " + temperatura);
        if (temperatura >= 30){
            if (capacidadMaxima == 50){
                System.out.println("\n Debido a la alta temperatura se reducira la capacidad maxima de la sala a 35 personas\n");
            }
            capacidadMaxima = 35;
        }
        else{
            if (capacidadMaxima == 35){
                System.out.println("\n Debido a la baja temperatura se aumentara la capacidad maxima de la sala a 50 personas\n");
            }
            capacidadMaxima = 50;
        }
    }
    
    public synchronized void salirSala(){
        //Reducimos la ocupacion cuando alguien sale de la sala
        ocupacion--;
        //Indicamos a otro hilo que puede entrar a la sala
        notifyAll();
    }
    
}
