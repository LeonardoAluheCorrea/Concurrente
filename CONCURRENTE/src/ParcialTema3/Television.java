/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Television {
    private Semaphore traducir; //Necesario para traducir un capitulo
    private int cantEspaniol; //Cantidad de episodios en español
    private int cantTraducidos; //Cantidad de episodio traducidos a ingles

    public Television() {
        traducir = new Semaphore(0);
        cantTraducidos = 0;
        cantEspaniol = 0;
    }
    
    public void filmar(){
        try {
            Thread.sleep(5000); //Se filma un episodio de la serie
            cantEspaniol++;
            System.out.println("Se filmo un episodio de la serie. Hay " + cantEspaniol + " en total");
            traducir.release(); //Indicamos que hay un episodio para traducir
        } catch (InterruptedException ex) {
            Logger.getLogger(Television.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verOriginal(int episodio){
        //episodio: es el numero de episodio que el socio quiere ver
        boolean res;
        res = cantEspaniol >= episodio; //Si el episodio ya salio, lo mira
        //Retornamos true si pudo ver el episodio, false si no pudo
        return res; 
    }
    
    public boolean verTraducido(int episodio){
        //episodio: es el numero de episodio que el socio quiere ver
        boolean res;
        res = cantTraducidos >= episodio; //Si el episodio ya fue traducido, lo mira
        //Retornamos true si puedo ver el episodio, false si no pudo
        return res;
    }
    
    public void traducir(){
        try {
            traducir.acquire();
            Thread.sleep(9000); //Se traduce un capitulo de la serie
            cantTraducidos++;
            System.out.println("Se tradujo un episodio de la serie. En total hay " + cantTraducidos + " episodios traducidos");
        } catch (InterruptedException ex) {
            Logger.getLogger(Television.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
