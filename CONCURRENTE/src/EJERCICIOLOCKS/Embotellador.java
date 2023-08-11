/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Embotellador implements Runnable{
    private Fabrica fabrica;
    private int nro;

    public Embotellador(Fabrica fabrica, int nro) {
        this.fabrica = fabrica;
        this.nro = nro;
    }
    
    
    @Override
    public void run() {
        while (true){
            boolean i;
            Random r = new Random();
            i = r.nextBoolean(); //Generamos 0 o 1 al azar
            if (i){ //Generamos una botella de vino
                fabrica.guardarVino(nro);
            }
            else{ //Generamos una botella de agua
                fabrica.guardarAgua(nro);
            }
        }
    }
    
}
