/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class PuestoCheckIn {
    private Hall hall;
    private String aerolinea;
    private Semaphore cola;
    private Semaphore encargado;

    public PuestoCheckIn(Hall hall, String aerolinea, int maxPersonas) {
        this.hall = hall;
        this.aerolinea = aerolinea;
        cola = new Semaphore(maxPersonas);
        encargado = new Semaphore(1);
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public boolean accederPuesto(int nombre) {
        //Devuelve true si pudo acceder al puesto y false si no
        boolean entro = false;
        if (cola.tryAcquire()) {//Si hay espacio en la cola del puesto entra
            entro = true;
            System.out.println(nombre + " accedio al puesto de check in de " + aerolinea);
        }
        return entro;
    }

    public void comenzarCheckIn(int nombre){
        try {
            encargado.acquire();
            atender();
        } catch (InterruptedException ex) {
            Logger.getLogger(PuestoCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void terminarCheckIn(int nombre){
        encargado.release(); //Deja pasar al proximo pasajero y se va
        System.out.println(nombre + " realizo el check-in y se va");
        //Ahora el puesto notifica que tiene mas espacio
        hall.notificarPuestoLibre(this);
    }
    
        
    public void abrirPuesto() {
        cola.release(1);
    }

    private void atender() throws InterruptedException {
       Thread.sleep(2000);
    }
}
