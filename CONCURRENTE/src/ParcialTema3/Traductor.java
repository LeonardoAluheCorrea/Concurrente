/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

/**
 *
 * @author Leo
 */
public class Traductor implements Runnable{
    private Television tele;

    public Traductor(Television tele) {
        this.tele = tele;
    }
    
    @Override
    public void run() {
        while(true){
            tele.traducir();
        }
    }
    
}
