/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Tren{
    private CyclicBarrier barrera;
    private boolean lleno;
    private Terminal terminalActual;
    private int pedidoFreno;
    private boolean movimiento;
    private boolean enRecorrido;

    public Tren(int maxPersonas) {
        Runnable barrierAction = () -> {//La ultima persona en subir avisara que puede salir el tren mediante la barrier action
            iniciar();
        };
        barrera = new CyclicBarrier(maxPersonas, barrierAction);
        pedidoFreno = 0;
        movimiento = false;
        enRecorrido = false;
        lleno = false;
    }
    
    public synchronized void esperarTren(){
        try {
            while(enRecorrido){ //Mientras el tren esta haciendo el recorrido espera
                wait();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean subirse(){
        boolean subio = false;
        if (!enRecorrido){// Si el tren no salio todavia intentara subir
            try {
                barrera.await();
                subio = true;
            } catch (InterruptedException | BrokenBarrierException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si no llego a subir al tren entonces volvera a esperar que termine el recorrido
        return subio;
    }
    
    public synchronized void comenzarRecorrido(){
        while(!enRecorrido){ //Mientras el tren no este lleno espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Al llenarse el tren comienza el recorrido
        movimiento = true;
        System.out.println("El tren comienza el recorrido");
    }
    
    public synchronized void terminarRecorrido(){
        try {
            //Ya no quedan mas terminales por lo que el tren se dirige al principio del recorrido
            System.out.println("El tren paso por todas las terminales y ahora se encuentra regresando al comienzo del recorrido");
            Thread.sleep(2000);
            terminalActual = null;
            System.out.println("El tren termino el recorrido y se detiene para que suban nuevos pasajeros");
            enRecorrido = false;
            movimiento = false;
            lleno = false;
            //Avisamos a la gente que puede subirse al tren
            notifyAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void usar(Terminal t){
        //t: es la terminal donde debe bajar el pasajero
        //Espera que el tren salga y llegue a la terminal donde debe bajar
        while(terminalActual == null || !terminalActual.equals(t)){ 
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Hace un pedido de freno para poder bajarse del tren
        pedidoFreno++;
        //Ahora espera que el tren frene para bajarse
        while(movimiento){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Se baja del tren
        pedidoFreno--;
        if (pedidoFreno == 0)//Si es el ultimo en bajarse
            //Avisa al tren que puede seguir
            notifyAll();
    }
    
    public synchronized void viajar(Terminal t){
        //Notificamos a que terminal nos dirijimos
        terminalActual = t;
        notifyAll();
    }
    
    public synchronized void continuarRecorrido(){
        while (pedidoFreno > 0) //Mientras quede gente que quiera bajar del tren
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        //Cuando todos hayan bajado puede continuar
        movimiento = true;
        System.out.println("El tren continua su recorrido");
    }
    
    public synchronized void frenarTren(){
        if (pedidoFreno > 0){
            //Si hay pedidos de frenar frenamos, si no, continuamos
            movimiento = false;
            //Avisamos a los pasajeros que pueden bajarse
            System.out.println("El tren se detiene para que se bajen los pasajeros que lo pidieron");
            notifyAll();
        }
    }

    private synchronized void iniciar() {
        //Cuando el colectivo se llena comenzara el recorrido
        lleno = true;
        enRecorrido = true;
        notifyAll();
    }
}

