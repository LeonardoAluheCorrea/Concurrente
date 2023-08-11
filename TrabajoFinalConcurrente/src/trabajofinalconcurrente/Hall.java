/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leo
 */
public class Hall {
    private LinkedList <PuestoCheckIn> puestoAbrir;
    private ReentrantLock lock;
    private Condition esperarPuesto;
    private Condition manejarPuesto;

    public Hall(){
        lock = new ReentrantLock();
        esperarPuesto = lock.newCondition();
        manejarPuesto = lock.newCondition();
        puestoAbrir = new LinkedList<>();
    }

    public void esperarPuesto(PuestoCheckIn puesto, int nombre) {
        //puesto: es el puesto al que debe ir el pasajero
        //nombre: es el nombre del pasajero
        lock.lock();
        try {
            //El pasajero entra al hall central y comienza a esperar
            System.out.println(nombre + " espera en el hall que haya espacio en el puesto de " + puesto.getAerolinea());
            esperarPuesto.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }
    
    public void manejarPuestos() {
        lock.lock();
        try {
            while (puestoAbrir.isEmpty()) {//Mientras no sea necesario notificar la apertura de algun puesto espera
                manejarPuesto.await();
            }
            //Cuando haya puestos que hayan notificado la salida de alguien abre un espacio en ellos
            for (PuestoCheckIn p: puestoAbrir){
                System.out.println("El guardia llama gente al puesto de " + p.getAerolinea());
                p.abrirPuesto();
            }
            //Vaciamos la lista de puestos
            puestoAbrir.clear();
            //Notificamos a los pasajeros de los puestos con nuevos espacios
            esperarPuesto.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    public void notificarPuestoLibre(PuestoCheckIn p) {
        //El puesto p avisa que tiene espacio libre para mas gente
        lock.lock();
        try {
            //Añadimos el puesto a la lista de puestos a abrir
            System.out.println("El puesto de " + p.getAerolinea() + " avisa al guardia que tiene mas espacio");
            puestoAbrir.add(p);
            manejarPuesto.signal();//Notifica al guardia
        } finally {
            lock.unlock();
        }
    }
}
