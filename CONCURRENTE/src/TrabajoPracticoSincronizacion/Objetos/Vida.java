/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion.Objetos;

/**
 *
 * @author Leo
 */
public class Vida {
    private int hpPoints = 100;
  
    
    public synchronized int getVida(){
        return hpPoints;
    }
    
    public synchronized void recibirDanio(int cantidad){
        hpPoints -= cantidad;
    }
    
    public synchronized void curarse(int cantidad){
        hpPoints += cantidad;
    }
}
