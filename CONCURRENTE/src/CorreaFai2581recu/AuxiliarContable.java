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
public class AuxiliarContable implements Runnable{
    private Farmacia f;

    public AuxiliarContable(Farmacia f) {
        this.f = f;
    }
    
    @Override
    public void run() {
        Random r = new Random();
        while(true){//Funciona mientras haya fichas en algun canasto
            switch(r.nextInt(2) + 1){ //Decide aleatoreamente de donde tomara la ficha
                case 1: //Toma una del canasto de fichas contables
                    f.tomarFichaContable();
                    break;
                case 2: //Toma una del canasto de fichas generales
                    f.tomarFichaGeneral();
                    break;
            }
        }
    }
    
}
