/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio03;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Empleado extends Thread {

    private String nombre;
    private Reloj reloj;

    public Empleado(Reloj reloj, String nombre) {
        this.reloj = reloj;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            reloj.despertar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
