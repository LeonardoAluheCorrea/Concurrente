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
public class Almacen {
    private int levadura;
    private int jugo;
    private int jarra;
    private int unidadF;
    private int estacionMezcla;
    private boolean reponerJugo;
    private boolean reponerLevadura;

    public Almacen() {
        jugo = 15;
        levadura = 20;
        jarra = 6;
        unidadF = 7; 
        estacionMezcla = 2;
        reponerJugo = false;
        reponerLevadura = false;
    }
    
    public synchronized boolean entrarAlmacen(String n) {
        boolean entro = false;
        if (unidadF > 0) {//Si quedan unidades de fermentacion entonces entrara a hacer mas vino, si no, no entrara
            System.out.println(n + " entro al almacen para hacer su vino");
            entro = true;
            unidadF--;
        }
        else{
            System.out.println(n + " no entra al almacen porque no quedan unidades de fermentacion");
        }
        return entro;
    }
    
    public synchronized void tomarJarra(String n){
        System.out.println( n + " busca una jarra, si no hay ninguna disponible espera");
        while(jarra == 0){//mientras no haya jarras disponibles espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jarra--;
    }
    
    public synchronized void tomarEstacionMezcla(String n){
        System.out.println(n + " se dirije a una estacion de mezcla, si no hay ninguna disponible espera");
        while(estacionMezcla == 0){ //Mientras no haya estaciones de mezcla libres
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        estacionMezcla--;
    }
    
    public synchronized void terminarVino(String n){
        System.out.println(n + " termino de fermentar su vino ahora lo decanta con una jarra");
        unidadF++;
        tomarJarra(n);
        jarra++; //Luego de decantar su vino devuelve la jarra
    }
    
    public synchronized void fermentarVino(String n){
        System.out.println(n + " termino de trabajar su mezcla y la pone a fermentar, libera una jarra y estacion de mezcla");
        estacionMezcla++;
        jarra++;
        notifyAll();
    }
    
    public synchronized void tomarLevadura(String n){
        System.out.println(n + " busca un paquete de levadura");
        if (levadura == 0){//Si no hay paquetes de levadura
            System.out.println(n + " le avisa al administrador que reponga paquetes de levadura y espera");
            reponerLevadura = true;
            notifyAll();
        }
        while (levadura == 0) {//Mientras no haya levadura espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        levadura--;
        System.out.println("Quedan " + levadura + " paquetes de levadura");
    }
    
    public synchronized void tomarJugo(String n){
        System.out.println(n + " busca 2 envases de jugo");
        if (jugo < 2){//Si no hay jugo suficiente
            System.out.println(n + " le avisa al administrador que reponga envases de jugo y espera");
            reponerJugo = true;
            notifyAll();
        }
        while (jugo < 2){//Mientras no hay a jugo espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jugo = jugo - 2;
        System.out.println("Quedan " + jugo + " envases de jugo");
    }
    
    public synchronized void reponerIngredientes(){
        while (reponerJugo && reponerLevadura){ //Mientras no haya nada que reponer espera
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (reponerJugo){//Reponer el jugo si es necesario
            System.out.println("El administrador repuso el jugo");
            jugo = 15;
            reponerJugo = false;
        }
        if (reponerLevadura){
            System.out.println("El administrador repuso la levadura");
            levadura = 20;
            reponerLevadura = false;
        }
        notifyAll();
    }
    
}
