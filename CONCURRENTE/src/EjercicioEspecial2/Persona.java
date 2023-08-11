/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable {
    private String nombre;
    private Salon salon;
    private Almacen almacen;

    public Persona(String nombre, Salon salon, Almacen almacen) {
        this.nombre = nombre;
        this.salon = salon;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            if (almacen.entrarAlmacen(nombre)) {//Si pudo entrar al almacen
                almacen.tomarJarra(nombre);
                realizarAccion();
                almacen.tomarJugo(nombre);
                realizarAccion();
                almacen.tomarLevadura(nombre);
                realizarAccion();
                almacen.tomarEstacionMezcla(nombre);
                realizarAccion();
                almacen.fermentarVino(nombre);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                almacen.terminarVino(nombre);
                System.out.println(nombre + " termino su vino");
                int v = salon.guardarVino(nombre);
                salon.entrarSalon(nombre);
                salon.esperarFinalizacion(nombre, v);
                salon.salirSalon(nombre);
            } 
            else { //Si no pudo entrar al almacen se dirije al salon de degustacion
                salon.entrarSalon(nombre);
                salon.salirSalon(nombre);
            }
        }
    }
    
    private void realizarAccion(){
        //Cada accion que realiza el miembro en el proceso de fabricacion (salvo el fermentado) tomara entre 1 y 3 segundos
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(1,4)*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
