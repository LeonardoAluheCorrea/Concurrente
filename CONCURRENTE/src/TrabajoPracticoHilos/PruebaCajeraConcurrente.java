/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoHilos;

import TrabajoPracticoHilos.Objetos.CajeraRunnable;
import TrabajoPracticoHilos.Objetos.CajeraThread;
import TrabajoPracticoHilos.Objetos.Cliente;
import Utiles.TecladoIn;

/**
 *
 * @author Leo
 */
public class PruebaCajeraConcurrente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        System.out.println("1. Ejecutar implementacion con herencia de Thread");
        System.out.println("2. Ejecutar implementacion con interfaz Runnable");
        int opcion = TecladoIn.readLineInt();
        if (opcion == 1){
            CajeraThread caja1 = new CajeraThread("Rocio", cliente1, System.currentTimeMillis());
            CajeraThread caja2 = new CajeraThread("Selma", cliente2, System.currentTimeMillis());
            caja1.start();
            caja2.start();
        }
        else{
            CajeraRunnable caja1 = new CajeraRunnable("Rocio",cliente1,System.currentTimeMillis());
            CajeraRunnable caja2 = new CajeraRunnable("Selma", cliente2, System.currentTimeMillis());
            Thread c1 = new Thread(caja1);
            Thread c2 = new Thread(caja2);
            c1.start();
            c2.start();
        }
    }
}
