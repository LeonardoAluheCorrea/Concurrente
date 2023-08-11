/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

import java.util.Random;

/**
 *
 * @author Leo
 */
public class Encargado implements Runnable {

    private Farmacia f;

    public Encargado(Farmacia f) {
        this.f = f;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) { 
            switch (r.nextInt(2) + 1) { //Decide aleatoreamente de donde tomara la ficha
                case 1: //Toma una del canasto de fichas del encargado
                    f.tomarFichaEncargado();
                    break;
                case 2: //Toma una del canasto de fichas generales
                    f.encargadoTomaFichaGeneral();
                    break;
            }
        }
    }
}
