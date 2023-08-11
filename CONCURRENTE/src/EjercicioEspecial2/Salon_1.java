/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial2;

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

    public Salon(int maxMiembros) {
        this.maxMiembros = maxMiembros;
        vino = new int [100]; 
        cantMiembros = 0;
    }
    
    public synchronized int guardarVino(String n){
        //Retorna la posicion donde guardo su vino
        boolean continuar = true;
        int i = 0;
        while (continuar){//Busca el primer lugar vacio para guardar su vino
            if (vino[i] == 0){
                vino[i]++;
                System.out.println(n + " guarda su vino, el " + i);
                continuar = false;
            }
            i++;
        }
        return i-1;
    }
    
    public synchronized void salirSalon(String n){
        System.out.println(n + " se va del salon de degustacion");
        cantMiembros--;
    }
    
    public synchronized void esperarFinalizacion(String n, int propio){
        //propio: Es la posicion del arreglo donde esta guardado el vino que hizo este miembro
        while(vino[propio] != 0){//Mientras todavia quede de su vino
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Todos probaron el vino de " + n);      
    }
    
    public synchronized void entrarSalon(String n){
        cantMiembros++;
        System.out.println(n + " entro al salon de degustacion");
        if (cantMiembros == maxMiembros) {//Si es el ultimo en entrar notifica
            notifyAll();
        }
        while (cantMiembros < maxMiembros) {//Mientras no esten todos los miembros en el salon espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando todos hayan llegado al salon de degustacion probaran todos los vinos
        System.out.println(n + " prueba todos los vinos");
        int i = 0;
        while(vino[i] >= 1){
            vino[i]++;
            if (vino[i] == maxMiembros){//Si es el ultimo miembro en probarlo entonces el vino se acaba
                vino[i] = 0;
                notifyAll();
            }
            i++;
        }
    }
    
}
