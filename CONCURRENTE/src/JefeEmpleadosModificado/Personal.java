/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeEmpleadosModificado;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Personal implements Runnable​{
    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    private static int llegaron = 0;
    private static int numEmp;
    
    Personal (Saludo s, String n){
        esJefe = false;
        nombre = n;
        saludo = s;
    }
    
    Personal (Saludo s, String n, int x){
        esJefe = true;
        nombre = n;
        saludo = s;
        numEmp = x;
    }
    
    public void run(){
        System.out.println("(" + nombre + " llega)");
        if(esJefe){
            while (llegaron < numEmp){ 
                saludo.esperarEmpleados();
            }
            saludo.saludoJefe();
        } 
        else{
            synchronized(this){
            //(*)
                llegaron++;
                if(llegaron == numEmp) saludo.esperarJefe(nombre, true);
                else saludo.esperarJefe(nombre, false);
            }
            //saludo.esperarJefe(nombre);
        }
    }
}