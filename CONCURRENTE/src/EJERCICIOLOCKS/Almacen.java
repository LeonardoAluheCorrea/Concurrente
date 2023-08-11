/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Almacen {
    private Caja[] caja;
    private ReentrantLock mutex;
    private ReentrantLock esperar;
    private Condition esperarEspacio;
    private Condition esperarLleno;

    public Almacen() {
        this.caja = new Caja[10];
        esperar = new ReentrantLock();
        mutex = new ReentrantLock();
        esperarEspacio = esperar.newCondition();
        esperarLleno = esperar.newCondition();
    }
    
    public void aniadirCaja(Caja c){
        //Este metodo añade una caja al almacen
        boolean exito = false, continuar;
        int i;
        while (!exito) { //Hasta poder guardar una caja seguimos intentando
            continuar = true;
            i = 0;
            while (continuar) { //Recorremos el arrelgo buscando un lugar libre para la caja
                try {
                    mutex.lock(); //Obtenemos lock de mutex
                    if (caja[i] == null) { //Si encuentra un espacio vacio para la caja
                        caja[i] = c; //Guarda la caja
                        c.setNro(i); //Le da un numero a la caja, correspondiente con el lugar donde se guardo
                        System.out.println("Se guardo la caja de " + c.esVino() + " en la posicion " + i + " del almacen");
                        exito = true;
                    }
                } finally {
                    mutex.unlock(); //Liberamos lock de mutex
                }
                i++;
                continuar = (i < 10) && !exito;
            }
            if (!exito) { //Si no queda espacio en el almacen
                System.out.println("El almacen esta lleno");
                try {
                    esperar.lock(); //Obtenemos lock de espera
                    esperarLleno.signal(); //Notificamos al camion que el almacen esta lleno
                    esperarEspacio.await(); //Esperamos que se libere un espacio
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                } finally{
                    esperar.unlock();//Liberamos lock de espera
                }
            }
        }
    }
   
    public void vaciarAlmacen(){
        try {
            //Este metodo sera utilizado por el camion para llevarse las cajas para repartir
            esperar.lock(); //Obtenemos lock de espera
            esperarLleno.await();//Esperamos que el almacen este lleno
            mutex.lock();//Obtenemos lock de mutex
            for (int i = 0; i < 10; i++){ //Vaciamos el arreglo de cajas del almacen
                caja[i] = null;
            }
            System.out.println("El camion carga todas las cajas del almacen de reparto");
            Thread.sleep(5000);
            System.out.println("El camion se va y deja libre el almacen de reparto");
            esperarEspacio.signal();
        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            esperar.unlock(); //Liberamos lock de espera
            mutex.unlock(); //liberamos lock de mutex
        }
    }


    public void quitarVino(int nro) {
        //Este metodo sera utilizado por el controlador de vinos para quitar la caja del almacen de maduracion
        esperar.lock();
        try {
            mutex.lock();
            caja[nro] = null;
            esperarEspacio.signalAll();
        } finally {
            mutex.unlock();
            esperar.unlock();
        }
    }
    
}
