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
    private Condition condition;

    public Hall(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
        puestoAbrir = new LinkedList<>();
    }

    public void esperarPuesto(PuestoCheckIn puesto, int nombre) {
        //puesto: es el puesto al que debe ir el pasajero
        //nombre: es el nombre del pasajero
        lock.lock();
        try {
            //El pasajero entra al hall central y comienza a esperar
            System.out.println(nombre + " se dirije al puesto de " + puesto.getAerolinea() + " si no logra entrar espera en el hall");
            while (!puesto.accederPuesto(nombre)) {//Mientras no pueda acceder a su puesto espera
                    condition.await();
            }
            //Si puedo acceder entonces no regresa al hall y realiza el check in
            System.out.println(nombre + " accedio al puesto de " + puesto.getAerolinea());
        } catch (InterruptedException ex) {
            Logger.getLogger(Hall.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
        puesto.realizarCheckIn(nombre);
    }
    
    public void manejarPuestos() {
        lock.lock();
        try {
            while (puestoAbrir.isEmpty()) {//Mientras no sea necesario notificar la apertura de algun puesto espera
                condition.await();
            }
            //Cuando haya puestos que notificado la salida de alguien abre un espacio en ellos
            for (PuestoCheckIn p: puestoAbrir){
                System.out.println("El guardia llama gente al puesto de " + p.getAerolinea());
                p.abrirPuesto();
            }
            //Vaciamos la lista de puestos
            puestoAbrir.clear();
            //Notificamos a los pasajeros de los puestos con nuevos espacios
            condition.signalAll();
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
            condition.signalAll();//Notifica a todos
        } finally {
            lock.unlock();
        }
    }
}
