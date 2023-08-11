/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ControladorVino implements Runnable{
    private Almacen almacenReparto;
    private Almacen almacenMaduracion;
    private Caja vino;
    private int tiempo;
    private int nro;
    
    public ControladorVino(Almacen almacenReparto, Almacen almacenMaduracion, Caja vino, int tiempo, int nro) {
        this.almacenReparto = almacenReparto;
        this.almacenMaduracion = almacenMaduracion;
        this.vino = vino;
        this.tiempo = tiempo*1000;
        this.nro = nro;
    }

    @Override
    public void run() {
        try {
            System.out.println("La caja de vino " + nro + " esta madurando...");
            Thread.sleep(tiempo);//Espera a que el vino madure
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorVino.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se movera la caja de vino " + nro + " al almacen de reparto");
        almacenMaduracion.quitarVino(nro); //Quita el vino del almacen de maduracion
        almacenReparto.aniadirCaja(vino);//Mueve el vino al almacen de reparto
        System.out.println("El vino " + nro + " termino de madurar y fue movido al almacen de reparto");
    }
    
}
