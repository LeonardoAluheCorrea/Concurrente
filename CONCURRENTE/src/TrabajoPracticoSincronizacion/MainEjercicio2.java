/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion;
import TrabajoPracticoSincronizacion.Objetos.Personaje;
import TrabajoPracticoSincronizacion.Objetos.Vida;
/**
 *
 * @author Leo
 */
public class MainEjercicio2 {
    
    public static void main(String []args){
        Thread t1, t2;
        Personaje orco, curandero;
        Vida nuestraVida = new Vida(100);
        orco = new Personaje(nuestraVida, "Orco");
        curandero = new Personaje(nuestraVida, "Curandero");
        t1 = new Thread(orco);
        t2 = new Thread(curandero);
        t1.start();
        t2.start();  
    }
}
