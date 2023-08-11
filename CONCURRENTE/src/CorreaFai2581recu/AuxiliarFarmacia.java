/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

/**
 *
 * @author Leo
 */
public class AuxiliarFarmacia implements Runnable{
    private Farmacia f;

    public AuxiliarFarmacia(Farmacia f) {
        this.f = f;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){ //Haremos que cada auxiliar genere 5 recetas, ya que el ejercicio no dice nada sobre esto
            f.hacerFichaGeneral();
        }
    }
    
}
