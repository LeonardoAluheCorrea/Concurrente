/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema1;

/**
 *
 * @author Leo
 */
public class Auto implements Runnable{
    private Transbordador barco;

    public Auto(Transbordador barco) {
        this.barco = barco;
    }
    
    public void run(){
        barco.subir(); //1
        barco.bajar();//3
    }
}
