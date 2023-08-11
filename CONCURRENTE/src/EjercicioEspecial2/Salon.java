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
public class Salon {
    private int[] vino;
    private final int maxMiembros;
    private int cantMiembros;
    private ReentrantLock lockVino;
    private Condition esperaVino;

    public Salon(int maxMiembros) {
        this.maxMiembros = maxMiembros;
        vino = new int [100]; 
        cantMiembros = 0;
        lockVino = new ReentrantLock();
        esperaVino = lockVino.newCondition();
    }
    
    public int guardarVino(String n){
        //Retorna la posicion donde guardo su vino
        boolean continuar = true;
        int i = 0;
        while (continuar) {//Busca el primer lugar vacio para guardar su vino
            synchronized (this) {//Sincronizamos el acceso al arrelgo de vinos
                if (vino[i] == 0) {
                    vino[i]++;
                    System.out.println(n + " guarda su vino, el " + i);
                    continuar = false;
                }
            }
            i++;
        }
        return i-1;
    }
    
    public void salirSalon(String n){
        System.out.println(n + " se va del salon de degustacion");
        cantMiembros--;
    }
    
    public void esperarFinalizacion(String n, int propio){
        //propio: Es la posicion del arreglo donde esta guardado el vino que hizo este miembro
        lockVino.lock();//Obtenemos el lock 
        try {
            while (vino[propio] != 0) {//Mientras todavia quede de su vino
                try {
                    esperaVino.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            lockVino.unlock();
        }
        System.out.println("Todos probaron el vino de " + n);      
    }

    public void entrarSalon(String n) {
        lockVino.lock();
        try {
            //Obtenemos el lock
            cantMiembros++;
            System.out.println(n + " entro al salon de degustacion");
            if (cantMiembros == maxMiembros) {//Si es el ultimo en entrar notifica
                esperaVino.signalAll();
            }
            while (cantMiembros < maxMiembros) {
                //Mientras no esten todos los miembros en el salon espera
                try {
                    esperaVino.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            lockVino.unlock();
        }
        //Cuando todos hayan llegado al salon de degustacion probaran todos los vinos
        int i = 0;
        boolean continuar = true;
        while (continuar) {//Recorremos el arreglo de vinos

            if (vino[i] > 0) {//Si hay vino guardado aqui lo prueba
                System.out.println(n + " prueba el vino " + i);
                vino[i]++;
                if (vino[i] == maxMiembros + 1) {//Si es el ultimo miembro en probarlo entonces el vino se acaba, avisa a su creador
                    vino[i] = 0;
                    lockVino.lock();
                    try {
                        esperaVino.signalAll();
                    } finally {
                        lockVino.unlock();
                    }
                }
            } else {//Si no habia vino guardado no continua
                System.out.println(n + " ha probado todos los vinos");
                continuar = false;
            }

            i++;
        }
    }

}
