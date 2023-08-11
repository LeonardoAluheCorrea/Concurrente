/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeEmpleados;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class TestSaludo {

    public static void main(String argv[]) {
        String[] nombresEmpleados = {"Pablo", "Luis", "Andrea",
            "Pedro", "Paula"};
        Saludo hola = new Saludo();
        Thread[] elPersonal = new Thread[6];
        elPersonal[0] = new Thread(new Personal(hola, "JEFE", 5));
        for (int i = 1; i < 6; i++) {
            elPersonal[i] = new Thread(new Personal(hola, nombresEmpleados[i - 1]));
        }
        for (int i = 0; i < 6; i++) {
            elPersonal[i].start();
        }
        for (int i = 0; i < 6; i++){
            try {
                elPersonal[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(TestSaludo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("LISTO, ahora que todos han saludado - a trabajar");
    }
}
