/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Almacen {
    private int levadura;
    private int jugo;
    private int jarra;
    private int unidadF;
    private int estacionMezcla;
    //Tenemos 1 lock por recurso para que varios miembros puedan acceder a recursos distintos al mismo tiempo 
    //Tenemos un lock para reponer para que el administrador este esperando la falta de cualquiera de los recursos
    private ReentrantLock entrada;
    private ReentrantLock lockLevadura;
    private ReentrantLock lockJugo;
    private ReentrantLock lockEstacion;
    private ReentrantLock lockJarra;
    private ReentrantLock reponer;
    private Condition esperaLevadura;
    private Condition esperaJugo;
    private Condition esperaJarra;
    private Condition esperaEstacion;
    private Condition esperaReponer;
    private boolean reponerJugo;
    private boolean reponerLevadura;

    public Almacen() {
        jugo = 15;
        levadura = 20;
        jarra = 6;
        unidadF = 7; 
        estacionMezcla = 2;
        entrada = new ReentrantLock();
        lockLevadura = new ReentrantLock();
        lockJugo = new ReentrantLock();
        lockJarra = new ReentrantLock();
        lockEstacion = new ReentrantLock();
        reponer = new ReentrantLock();
        esperaLevadura = lockLevadura.newCondition();
        esperaJarra = lockJarra.newCondition();
        esperaEstacion = lockEstacion.newCondition();
        esperaJugo = lockJugo.newCondition();
        esperaReponer = reponer.newCondition();
        reponerJugo = false;
        reponerLevadura = false;
    }
    
    public boolean entrarAlmacen(String n) {
        boolean entro = false;
        entrada.lock();
        try {
            if (unidadF > 0) {//Si quedan unidades de fermentacion entonces entrara a hacer mas vino, si no, no entrara
                System.out.println(n + " entro al almacen para hacer su vino");
                entro = true;
                unidadF--;
            }
            else{
                System.out.println(n + " no entra al almacen porque no quedan unidades de fermentacion");
            }
        } finally {
            entrada.unlock();
        }
        return entro;
    }
    
    public void tomarJarra(String n){
        System.out.println(n + " busca una jarra, si no hay ninguna disponible espera");
        lockJarra.lock(); //Obtenemos el lock para las jarras
        try {
            while(jarra == 0){//Mientras no haya jarras disponibles espera
                try {
                    esperaJarra.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jarra--;
        } finally {
            lockJarra.unlock();
        }
    }
    
    public void tomarEstacionMezcla(String n){
        System.out.println(n + " se dirije a una estacion de mezcla, si no hay ninguna disponible espera");
        lockEstacion.lock();//Obtenemos el lock de la estacion de mezcla
        try {
            while(estacionMezcla == 0){ //Mientras no haya estaciones de mezcla libres
                try {
                    esperaEstacion.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            estacionMezcla--;
        } finally {
            lockEstacion.unlock();
        }
    }
    
    public void terminarVino(String n){
        System.out.println(n + " termino de fermentar su vino ahora lo decanta con una jarra");
        tomarJarra(n);
            unidadF++;
            lockJarra.lock();//Obtenemos el lock de las jarras
        try {
            jarra++; //Luego de decantar su vino devuelve la jarra y avisa
            esperaJarra.signalAll();
        } finally {
            lockJarra.unlock();
        }
    }
    
    public void fermentarVino(String n){
        System.out.println(n + " termino de trabajar su mezcla y la pone a fermentar, libera una jarra y estacion de mezcla");
        //Obtenemos el lock de las estaciones de mezcla, devolvemos una y avisamos
        lockEstacion.lock();
        try {
            estacionMezcla++;
            esperaEstacion.signalAll();
        } finally {
            lockEstacion.unlock();
        }
        //Obtenemos el lock de las jarras, devolvemos una y avisamos
        lockJarra.lock();
        try {
            jarra++;
            esperaJarra.signalAll();
        } finally {
            lockJarra.unlock();
        }
        
    }
    
    public void tomarLevadura(String n){
        System.out.println(n + " busca un paquete de levadura");
        //Obtenemos el lock de la levadura
        lockLevadura.lock();
        try {
            if (levadura == 0){//Si no hay paquetes de levadura
                System.out.println(n + " le avisa al administrador que reponga paquetes de levadura y espera");
                reponer.lock();
                try {
                    reponerLevadura = true;
                    esperaReponer.signalAll(); //Avisamos al administrador
                } finally {
                    reponer.unlock();
                }
            }
            while (levadura == 0) {//Mientras no haya levadura espera
                try {
                    esperaLevadura.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            levadura--;
        } finally {
            lockLevadura.unlock();
        }
        System.out.println("Quedan " + levadura + " paquetes de levadura");
    }
    
    public void tomarJugo(String n){
        System.out.println(n + " busca 2 envases de jugo");
        lockJugo.lock();//Obtenemos el lock del jugo
        try {
            if (jugo < 2){//Si no hay jugo suficiente avisa al administrador
                System.out.println(n + " le avisa al administrador que reponga envases de jugo y espera");
                reponer.lock();
                try {
                    reponerJugo = true;
                    esperaReponer.signalAll();
                } finally {
                    reponer.unlock();
                }
            }
            while (jugo < 2){//Mientras no hay a jugo espera
                try {
                    esperaJugo.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jugo = jugo - 2;
        } finally {
            lockJugo.unlock();
        }
        System.out.println("Quedan " + jugo + " envases de jugo");
    }
    
    public void reponerIngredientes(){
        reponer.lock();//Obtenemos el lock para reponer objetos
        try {
            while (reponerJugo && reponerLevadura){ //Mientras no haya nada que reponer espera
                try {
                    esperaReponer.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            reponer.unlock();
        }
        lockJugo.lock();//Obtenemos lock del jugo
        try {
            if (reponerJugo){//Reponer el jugo si es necesario
                System.out.println("El administrador repuso el jugo");
                jugo = 15;
                reponerJugo = false;
                esperaJugo.signalAll();
            }
        } finally {
            lockJugo.unlock();
        }
        lockLevadura.lock();//Obtenemos lock de la levadura
        try {
            if (reponerLevadura){//Reponer la levadura si es necesario
                System.out.println("El administrador repuso la levadura");
                levadura = 20;
                reponerLevadura = false;
                esperaLevadura.signalAll();
            }
        } finally {
            lockLevadura.unlock();
        }
    }
    
}
