/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable {

    private boolean jubilado;
    private GestorSala gestor;
    private int id;

    public Persona(boolean jubilado, GestorSala gestor, int id) {
        this.jubilado = jubilado;
        this.gestor = gestor;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!jubilado) {
                    gestor.entrarSala();
                } else {
                    gestor.entrarSalaJubilado();
                }
                System.out.println(id + " entro a la sala. Jubilado --> " + jubilado);
                //La persona permanecera en la sala por 8 segundos antes de irse
                Thread.sleep(8000);
                //Luego el hilo se va de la sala
                gestor.salirSala();
                //Antes de intentar entrar otra vez la persona esperara 10 segundos
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
