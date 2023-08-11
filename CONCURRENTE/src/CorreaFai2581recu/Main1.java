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
public class Main1 {
    public static void main(String []args){
        Farmacia f = new Farmacia();
        Thread[] contable;
        Thread[] farmacia;
        Thread encargado = new Thread(new Encargado(f));
        contable = new Thread[2];
        farmacia = new Thread[2];
        for (int i = 0; i < 2; i++){
            farmacia[i] = new Thread(new AuxiliarContable(f));
            farmacia[i].start();
        }
        for (int i = 0; i < 2; i++){
            contable[i] = new Thread(new AuxiliarFarmacia(f));
            contable[i].start();
        }
        encargado.start();
    }
}
