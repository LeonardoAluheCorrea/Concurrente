/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class MontaniaRusa {
    private int capacidad; //Cantidad de personas que pueden subir a la montaña rusa
    private int ocupacion; //Cantidad de personas actualmente en la montaña rusa
    private int cantRecorridos; //Cantidad de recorridos antes de cerrar
    private boolean permisoBajarse; //Indicara cuando es posible bajarse de la montaña rusa
    private boolean abierta; //Nos indicara si la montaña cerro o no
    private boolean permisoSubirse; //Indicara cuando es posible subir a la montaña rusa

    public MontaniaRusa(int capacidad, int cantRecorridos) {
        this.capacidad = capacidad;
        this.cantRecorridos = cantRecorridos;
        abierta = true;
        ocupacion = 0;
        permisoBajarse = false;
        permisoSubirse = true;
    }
    
    public synchronized boolean estaAbierta(){
        return abierta;
    }

    public synchronized int getCantRecorridos() {
        return cantRecorridos;
    }
    
    public synchronized void cerrar(){
        abierta = false;
        notifyAll(); //Notificamos que se cerro la montaña rusa
    }
    
    public synchronized void hacerRecorrido(){
        try {
            while(ocupacion < capacidad){ //Mientras quede espacio para personas en el carrito de la montaña
                wait(); //Esperamos
            }
            //Cuando se llena el carrito de la montaña salimos
            permisoSubirse = false; //Revocamos el permiso para subirse al carrito
            System.out.println("El carrito de la montaña esta lleno, empieza el recorrido");
            Thread.sleep(5000);
            System.out.println("El carrito de la montaña finalizo su recorrido");
            permisoBajarse = true; //Damos permiso a que la gente se baje del carrito
            notifyAll(); //Notificamos que se hizo un recorrido
        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void bajarse(){
        while(!permisoBajarse){ //Mientras no se haya dado el permiso para bajar
            try {
                wait(); //Esperamos
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Cuando termine el recorrido se da el permiso para bajar, por lo tanto, la persona baja
        System.out.println("Una persona se baja de la montaña rusa");
        ocupacion--;
        if (ocupacion == 0){ //Si esta persona fue la ultima en bajar del carrito
            permisoBajarse = false; //Revocamos el permiso de bajarse
            permisoSubirse = true; //Damos permiso a subirse 
        }
        notifyAll(); //Notificamos que se bajo una persona
    }
    
    public synchronized void subirse() {
        try {
            while (ocupacion == capacidad || !permisoSubirse) { //Mientras no alla espacio en el carrito o no tenga permiso para subirse
                    wait(); //Esperamos
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (abierta){ //Si la motanaña rusa esta abierta
            System.out.println("Una persona se sube a la montaña rusa");
            ocupacion++;
            notifyAll(); //Notificamos que se subio una persona
        }
    }
}
