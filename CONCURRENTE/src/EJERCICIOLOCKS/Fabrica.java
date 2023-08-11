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
public class Fabrica {
    private Caja cajaVino; 
    private Caja cajaAgua;
    private ReentrantLock mutex;
    private Condition esperarCajaLlena; //Para esperar a que alguna de las 2 cajas este llena
    private Condition esperarCajaVino;
    private Condition esperarCajaAgua;
    private boolean vinoLlena;
    private boolean aguaLlena;

    public Fabrica(Caja cajaVino, Caja cajaAgua) {
        mutex = new ReentrantLock();
        esperarCajaLlena = mutex.newCondition();
        esperarCajaAgua = mutex.newCondition();
        esperarCajaVino = mutex.newCondition();
        this.cajaVino = cajaVino;
        this.cajaAgua = cajaAgua;
        vinoLlena = false;
        aguaLlena = false;
    }
    
    public void guardarAgua(int nro){
        //Este metodo sera utilizado por los embotelladores para guardar botellas de vino
        while (!cajaAgua.guardarBotella(nro)){ //Mientras no haya sido posible guardar la botella
            mutex.lock();//Obtenemos lock
            try {
                System.out.println("La caja de agua esta llena asi que el embotellador " + nro + " espera...");
                aguaLlena = true;
                esperarCajaLlena.signal();//Avisamos que la caja esta agua llena
                esperarCajaAgua.await(); //Esperamos una nueva caja de vino y volvemos a intentar
            } catch (InterruptedException ex) {
                Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                mutex.unlock(); //Liberamos lock 
            }
        }
    }
    
    public void guardarVino(int nro){
        //Este metodo sera utilizado por los embotelladores para guardar botellas de vino
        while (!cajaVino.guardarBotella(nro)){ //Mientras no haya sido posible guardar la botella
            mutex.lock();//Obtenemos lock
            try {
                System.out.println("La caja de vino esta llena asi que el embotellador " + nro + " espera...");
                vinoLlena = true;
                esperarCajaLlena.signal(); //Avisamos que la caja de vino esta llena
                esperarCajaVino.await(); //Esperamos una nueva caja de vino y volvemos a intentar
            } catch (InterruptedException ex) {
                Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                mutex.unlock(); //Liberamos lock 
            }
        }
    }
 
    public Caja esperarCajaLlena(){
        //Este metodo sera utilizado por el empaquetador para esperar a que una caja se llene y reemplazarla cuando eso pase
        //retornamos cual es la caja que se lleno y debe ser reemplazada
        Caja res = new Caja();
        try {
            if (!aguaLlena && !vinoLlena) { //Si ninguna caja se ha llenado mientras el empaquetador hacia otras cosas, debera esperar
                mutex.lock();//Obtenemos lock
                try {
                    esperarCajaLlena.await(); //Esperamos que una caja se llene
                } finally {
                    mutex.unlock();//Liberamos lock
                }
            }//Cuando hayamos terminado de esperar o si habia una caja llena
            //Retornamos la caja que se haya llenado
            if (cajaVino.estaLlena()){
                cajaVino.sellarCaja();
                System.out.println("El empaquetador sello la caja de vino y se la lleva");
                res = cajaVino;
            }
            else{
                cajaAgua.sellarCaja();
                System.out.println("El empaquetador sello la caja de agua y se la lleva");
                res = cajaAgua;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void reemplazarCajaAgua(){
        //Este metodo sera utilizado por el empaquetador para colocar una nueva caja de agua
        mutex.lock();//Obtenemos lock
        try {
            cajaAgua = new Caja(false,0); //Colocamos una nueva caja de agua
            System.out.println("Hay una nueva caja de agua para los embotelladores");
            aguaLlena = false;
            esperarCajaAgua.signalAll(); //Avisame que hay una caja de agua nueva
        } finally {
            mutex.unlock();//Liberamos lock
        }
    }
    
    public void reemplazarCajaVino(){
        //Este metodo sera utilizado por el empaquetador para colocar una nueva caja de vino
        mutex.lock(); //Obtenemos lock 
        try {
            cajaVino = new Caja(true, 2000); //Colocamos una caja de vino nueva
            System.out.println("Hay una nueva caja de vino para los embotelladores");
            vinoLlena = false;
            esperarCajaVino.signalAll(); //Avisamos que hay una caja de vino nueva
        } finally {
            mutex.unlock(); //Liberamos lock
        }
    }
}
