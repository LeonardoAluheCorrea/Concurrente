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
public class Empleado implements Runnable{
    private Costurera taller;
    private int id;

    public Empleado(Costurera taller, int id) {
        this.taller = taller;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            switch(id){
                case 1:
                    taller.cuerpo();
                    break;
                case 2:
                    taller.mangas();
                    break;
                case 3:
                    taller.sueter();
                    break;
            }
        }
    }
    
}
