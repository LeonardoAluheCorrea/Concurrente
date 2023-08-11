/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class FreeShop {
    private int maxPersonas;
    private Semaphore entrada;
    private Semaphore caja1;
    private Semaphore caja2;

    public FreeShop(int maxPersonas) {
        this.maxPersonas = maxPersonas;
        entrada = new Semaphore(maxPersonas);
        caja1 = new Semaphore(1);
        caja2 = new Semaphore(1);
    }
    
    public boolean puedeEntrar(){
        //Intentamos entrar al free shop
        boolean entro;
        entro = entrada.tryAcquire();
        return entro;
    }

    public void usar(int n){
        //n: es el nombre del pasajero y se usa unicamente para transmitir con precision por pantalla los hechos
        //El pasajero ha entrado al free shop y pasea buscando algo que comprar
        Random r = new Random();
        try {
            System.out.println(n + " entro el free shop y busca algo que comprar");
            Thread.sleep(r.nextInt(200, 1000));//Decidimos al azar el tiempo que el pasajero pasa mirando el free shop
            boolean comprar = r.nextBoolean();//Decidimos al azar si comprar algo o no
            if (comprar){//Si decidio comprar algo se dirije a una de las 2 cajas
                boolean caja = r.nextBoolean();//Decidimos al azar que caja usar
                if (caja){
                    System.out.println(n + " se dirije a la caja 1, si no esta disponible espera");
                    caja1.acquire();//Accedemos a la caja1
                    Thread.sleep(1000);
                    caja1.release();//Liberamos la caja1
                }
                else{
                    System.out.println(n + " se dirije a la caja 2, si no esta disponible espera");
                    caja2.acquire();//Accedemos a la caja2
                    Thread.sleep(1000);
                    caja2.release();//Liberamos la caja2
                }
                System.out.println(n + " ha realizado sus compras y abandona el free shop");
                entrada.release();//Libera un espacio en el freeShop
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FreeShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
