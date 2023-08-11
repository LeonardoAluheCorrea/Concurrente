/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Pasajero implements Runnable {
    private Vuelo vuelo;
    private int nombre;
    private Aeropuerto aeropuerto;
    private Reloj reloj;

    public Pasajero(int nombre, Aeropuerto aeropuerto, Reloj reloj) {
        this.nombre = nombre;
        this.aeropuerto = aeropuerto;
        this.reloj = reloj;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public void run() {
        //Primero el pasajero debe entrar al aeropuerto
        aeropuerto.entrar();
        System.out.println(nombre + " ha entrado al aeropuerto");
        //Luego el pasajero se dirije al puesto de informes donde pregunta por el vuelo que quiere tomar
        vuelo = aeropuerto.entrarPuestoInf();
        System.out.println(nombre + " paso por el puesto de informes y tomara el vuelo " + vuelo.getNro() + " de " + vuelo.getAerolinea() + " en la terminal " 
                + vuelo.getTerminalEmbarque().getNombre() + " a las " + vuelo.getHora());
        //Obtenemos el puesto de check-in correspondiente
        PuestoCheckIn p;
        p = aeropuerto.getPuestoCheckIn(vuelo.getAerolinea());
        //Realiza el check-in
        Hall hall = aeropuerto.getHallEspera();
        //Se dirije al hall de espera para luego realizar el check-in
        hall.esperarPuesto(p,nombre);
        System.out.println(nombre + " ha realizado el check-in y se dirije hacia el tren");
        //Se dirije al tren que lleva gente a las terminales e intenta subir, si no puede espera
        Tren t;
        Terminal t1;
        t1 = vuelo.getTerminalEmbarque();
        t = aeropuerto.getTren();
        //Espera que el tren llegue de su recorrido
        t.esperarTren();
        //Cuando el tren llegue, o si ya estaba ahi, intenta subir
        t.subirse();
        System.out.println(nombre + " ha abordado el tren camino a la terminal " + t1.getNombre());
        t.usar(t1);
        System.out.println(nombre + " se baja del tren en la terminal de embarque " + t1.getNombre());
        //Estando ahora en la terminal de embarque, si tiene tiempo, decidira al azar si va o no al free shop 
        boolean visita = visitaFreeShop();
        FreeShop f = t1.getShop();
        if (visita){//Si decidio visitar el free shop
            System.out.println(nombre + " decide visitar el free shop");
            boolean entro = f.puedeEntrar();
            if (!entro){ try {
                //Si no pudo entrar entonces espera y decide si intentar 1 vez mas
                System.out.println(nombre + " no ha podido entrar al free shop porque esta lleno");
                Thread.sleep(new Random().nextInt(500, 3000)); //Esperamos un tiempo elegido al azar
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
                }
                visita = visitaFreeShop();
                if (visita){//Si decidio nuevamente visitar
                    System.out.println(nombre + " intenta nuevamente entrar al free shop, si no puede se va a esperar");
                    entro = f.puedeEntrar();//Intenta entrar por 2 vez
                }
            }
            if (entro){//Si pudo entrar al free shop
                f.usar(nombre);
            }
            else{
                System.out.println(nombre + " no ha podido ingresar al free shop, se dirije a esperar su vuelo");
            }
            //Si no puedo entrar en su 2do intento no continuara intentando
        }
        System.out.println(nombre + " espera a la llamada para embarcar su vuelo");
        if (vuelo.yaDespego()){
            System.out.println("El vuelo " + vuelo.getNro() + " que debia tomar " + nombre + " ya ha despegado, lo perdio");
        }
        else{    
            vuelo.abordar();
            System.out.println(nombre + " abordó su vuelo, el vuelo " + vuelo.getNro());
        }
    }
    
    public boolean visitaFreeShop(){
        //Decidimos aleatoreamente si el pasajero visita el freeshop en su terminal
        boolean visita;
        visita = false;
        if ((vuelo.getHora() - reloj.getHora()) > 2){//Si faltan al menos 2 horas para que salga nuestro vuelo
            //Decidimos al azar si visitar o no el freeshop
            Random r;
            r = new Random();
            visita = r.nextBoolean();
        }
        //Si no, no visitamos
        return visita;
    }   
}
