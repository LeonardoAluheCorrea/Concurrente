/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2Tema4;

/**
 *
 * @author Leo
 */
public class Cuidador implements Runnable{
    private Comedor com;

    public Cuidador(Comedor com) {
        this.com = com;
    }

    @Override
    public void run() {
        while(true){
            com.llenarPlatos();
        }
    }
    
}
