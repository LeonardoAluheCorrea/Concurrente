/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial1;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Actividad {
    private String nombre;
    private int cantPersonas;
    private Salon salon;
    private boolean abierta;
    private boolean comenzo;
    private boolean termino;

    public Actividad(String nombre, Salon salon) {
        this.nombre = nombre;
        this.salon = salon;
        cantPersonas = 0;
        abierta = true;
        comenzo = false;
        termino = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
    
    public synchronized void comenzarActividad(){
        comenzo = true;
        abierta = false;
        notifyAll();
    } 
    
    public synchronized void terminarActividad(){
        comenzo = false;
        notifyAll();
    }
    
    
    public synchronized void realizarActividad(String n){
        while(!comenzo){//Mientras no haya comenzado
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando haya comenzado esperara a que termine
        while(comenzo){ //"comenzo" debe volverse a false asi que la aprovechamos como marcador para que la gente comienze a irse
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando termina se va
        cantPersonas--;
        System.out.println(n + " dejo " + nombre);
        if (cantPersonas == 0) {//Si no quedan mas personas avisa que esta vacia
            termino = true;//La actividad termina cuando la ultima persona se va
            System.out.println(nombre + " esta vacia");
            salon.actividadVacia();
        }
    }
    
    public synchronized boolean entrar(String n){
        boolean entro = false;
        while (!abierta && termino){//Mientras la actividad no este abierta espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (cantPersonas < 4){//Si queda espacio entra
            cantPersonas++;
            entro = true;
            System.out.println(n + " entro a " + nombre);
            if (cantPersonas == 4){//Si se lleno cierra la entrada a mas gente
                System.out.println(nombre + " esta llena");
                salon.actividadLlena();
            }
        }
        else{
            System.out.println(n + " no pudo entrar a " + nombre);
        }
        return entro;
    }
    
    
    public synchronized void abrir(){
        abierta = true;
        notifyAll();
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        return Objects.equals(this.nombre, other.nombre);
    }


}
