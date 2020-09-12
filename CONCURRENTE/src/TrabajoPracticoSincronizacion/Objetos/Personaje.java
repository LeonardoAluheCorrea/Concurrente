/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion.Objetos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Personaje implements Runnable {
    private Vida barraVida;
    private String rol;
    
    public Personaje(Vida vida, String rol){
        this.rol = rol;
        barraVida = vida;
    }
    
    public void run() {
        if (rol.equalsIgnoreCase("Orco")){
            for (int i = 1; i <= 5; i++){
                System.out.println("Vida actual: " + barraVida.getVida());
                barraVida.recibirDanio(3);
                System.out.println("El orco nos ataca!! -3 VIDA, tenemos ahora: " + barraVida.getVida() + " de vida");
            }
        }
        else{
            if (rol.equalsIgnoreCase("Curandero")){
                for (int j = 1; j <= 2; j++){
                    System.out.println("Vida actual: " + barraVida.getVida());
                    barraVida.curarse(3);
                    System.out.println("El curandero restora nuestra vitalidad!! +3 VIDA, tenemos ahora: " + barraVida.getVida() + " de vida");
                }
            }
        }
    }
}
