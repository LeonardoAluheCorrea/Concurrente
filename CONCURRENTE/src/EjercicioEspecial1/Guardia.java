/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Guardia implements Runnable{
    private Salon salon;

    public Guardia(Salon salon) {
        this.salon = salon;
    }

    @Override
    public void run() {
        while(true){
            salon.comenzarActividades();//Cuando todas las actividades esten llenas las comienza
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Guardia.class.getName()).log(Level.SEVERE, null, ex);
            }
            salon.terminarActividades();//Luego de 5 segundos las termina
            salon.abrirActividades();
        }
    }
    
}
