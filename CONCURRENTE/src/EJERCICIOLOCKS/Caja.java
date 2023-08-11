/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Caja {
    private int nro;
    private boolean tipo; //true para vino, false para agua
    private int cantBotellas;
    private ReentrantLock mutex;
    private int tiempoMaduracion; //El tiempo de maduracion para los vinos
    private boolean madurado; //Para saber si el vino ya ha madurado o no

    public Caja(boolean tipo, int tiempoMaduracion) {
        this.tipo = tipo;
        this.tiempoMaduracion = tiempoMaduracion;
        mutex = new ReentrantLock();
        madurado = false;
        cantBotellas = 0;
    }

    public Caja() {
    }


    public boolean esVino() {
        mutex.lock();
        try {
            return tipo;
        } finally {
            mutex.unlock();
        }
    }
    
    public boolean estaLlena(){
        boolean llena;
        mutex.lock();
        try {
            llena = cantBotellas == 10;
        } finally {
            mutex.unlock();
        }
        return llena;
    }
    
    public boolean guardarBotella(int nro){
        //Este metodo sera utilizado por los embotelladores para guardar botellas en la caja
        //Retorna true si puede colocar la botella en la caja, false si la caja esta llena
        boolean exito = false;
        mutex.lock();//Obtenemos lock de mutex
        try {
            if (cantBotellas < 10){//Si la caja aun no esta llena
                cantBotellas++; //Añadimos una botella
                if (tipo){
                    System.out.println(+ nro + " guardo una botella en la caja de vino, que ahora tiene " + cantBotellas);
                }
                else{
                    System.out.println(+ nro + " guardo una botella en la caja de agua, que ahora tiene " + cantBotellas);
                }
                exito = true;
            }
        } finally {
            mutex.unlock();//Liberamos lock de mutex
        }
        return exito;
    }

    public void sellarCaja() {
        try {
            //Este metodo sera usado por el empaquetador cuando la caja este llena
            mutex.lock();//Obtenemos lock de mutex
            Thread.sleep(1000); //El tiempo que toma sellar la caja
        } catch (InterruptedException ex) {
            Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
        //No liberamos el lock porque la caja debe ser guardada para reparto o maduracion primero
    }
    
    public void cajaLista(){
        //Este metodo sera utilizado por el empaquetador cuando la caja haya sido movida al almaacen de reparto o maduracion
        mutex.unlock();
    }
    
    public void madurarVino(Almacen almacenReparto, Almacen almacenMaduracion){
        //Este metodo sera utilizado por el empaquetador al guardar el vino
        //Crearemos un hilo que esperara que el vino madure y luego al movera al almacen de reparto
        Thread controlador = new Thread(new ControladorVino(almacenReparto, almacenMaduracion, this, tiempoMaduracion, nro));
        controlador.start();
    }

    public void setNro(int i) {
        mutex.lock();
        try {
            nro = i;
        } finally {
            mutex.unlock();
        }
    }

    public void vinoListo() {
        mutex.lock();
        try {
            madurado = true;
        } finally {
            mutex.unlock();
        }
    }
    
}
