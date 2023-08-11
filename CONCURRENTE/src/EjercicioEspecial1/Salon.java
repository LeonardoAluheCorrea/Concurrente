/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Salon {
    private Actividad[] actividad;
    private int cantActividadLlenas;
    private Semaphore entrada;
    private Semaphore iniciarAct;
    private Semaphore abrirAct;
    

    public Salon() {
        cantActividadLlenas = 0;
        entrada = new Semaphore (12);
        iniciarAct = new Semaphore(0);
        abrirAct = new Semaphore(0);
    }

    public void setActividad(Actividad[] actividad) {
        this.actividad = actividad;
    }
    
    public Actividad[] getActividad() {
        return actividad;
    }
    
    public void entrar() {
        try {
            entrada.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actividadLlena() {
        cantActividadLlenas++;
        if (cantActividadLlenas == 3) {//Si con esta todas las actividades estan llenas el guardia las comenzara
            iniciarAct.release();
        }
    }
   
    public void abrirActividades(){
        try {
            abrirAct.acquire();
            for (int i = 0; i < 3; i++){
                actividad[i].abrir();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarActividades(){
        System.out.println("TERMINARON LAS ACTIVIDADES");
        for(int i = 0; i < 3; i++){
            actividad[i].terminarActividad();
        }
    }
    
    public void comenzarActividades(){
        try {
            iniciarAct.acquire();
            System.out.println("COMIENZAN LAS ACTIVIDADES");
            for (int i = 0; i < 3; i++){
                actividad[i].comenzarActividad();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Salon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Actividad hacerTurno(String n, Actividad realizada) {
        Actividad elegida = null;
        Random r = new Random();
        boolean entro = false;
        int i = r.nextInt(0, 3);//Iterador sobre el arreglo de actividades
        int f = 0;//Contador de las veces que intentamos entrar a actividad ya realizada
        while (!entro) {//Mientras no haya entrado a una actividad
            elegida = actividad[i];
            if (!elegida.equals(realizada)) {//Si la actividad elegida no es la que ya realizo intenta entrar
                entro = elegida.entrar(n);
            } else {//Si es la que ya realizo entonces solo intenta entrar si ya probo las otras 2
                if (f > 2) {
                    entro = elegida.entrar(n);
                }
            }
            if (i == 2) {
                i = 0;
            } else {
                i++;
            }
            f++;
        }
        //Espera que la actividad comienze
        elegida.realizarActividad(n);
        realizada = elegida;
        return realizada;
    }

    public void salir(){
        entrada.release();
    }
    
    public void actividadVacia() {
            cantActividadLlenas--;
            if (cantActividadLlenas == 0){//Si con esta todas las actividades estan vacias entonces indicamos al guardia que las abra
                abrirAct.release();
            }
    }
}
