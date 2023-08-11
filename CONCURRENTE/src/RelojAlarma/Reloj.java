/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RelojAlarma;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Reloj implements Runnable{
    private int hora;
    private Persona[] barrio;

    public Reloj() {
        this.hora = 0;
    }
        
    @Override
    public void run() {
        try {
            while (true) {
                int n = barrio.length;
                for(int i = 0; i < n; i++){
                    if (barrio[i].getHora() == hora)
                        barrio[i].despertar();
                }
                System.out.println("Son las " + hora);
                Thread.sleep(3000);
                hora++;
                if (hora == 24) {
                    hora = 0;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized int getHora(){
        return hora;
    }
    
}
