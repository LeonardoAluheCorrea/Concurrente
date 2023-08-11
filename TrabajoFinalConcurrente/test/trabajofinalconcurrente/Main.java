/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String[]args){
        Aeropuerto a = new Aeropuerto();
        Vuelo[] vuelo = new Vuelo[4];
        String[] aerolinea = new String[2];
        Terminal[] ter = new Terminal[2];
        PuestoCheckIn[] puesto = new PuestoCheckIn[2];
        //Creamos el hall de espera
        Hall hall = new Hall();
        //Creamos las aerolineas y puestos de Check-In
        for (int i = 0; i < 2; i++){
            char f = (char) (97 + i) ; 
            aerolinea[i] =  String.valueOf(f) + String.valueOf(f);
            //Creamos un puesto por aerolinea con capacidad para 5 personas
            puesto[i] = new PuestoCheckIn(hall,aerolinea[i], 5);
        }
        //Añadimos el hall al aeropuerto
        a.setHallEspera(hall);
        //Creamos el guardia
        Thread guardia = new Thread(new GuardiaHall(hall));
        //Creamos las terminales de embarque
        int acu = 0;
        for (int i = 0; i < 2; i++){
            FreeShop f = new FreeShop(5); //Creamos free shop para 5 personas
            ter[i] = new Terminal(f,acu + 1,acu + 4, Character.toString(97+i)); //Creamos terminal con 4 puestos de embarque, nombradas por letras del abecedario
            acu = acu + 4;
        }
        //Creamos el tren
        Tren tren;
        tren = new Tren(5); //Tren con espacio para 5 personas
        //Creamos el chofer
        Thread chofer;
        chofer = new Thread(new Chofer(tren,ter));
        //Añadimos tren, vuelos, terminalas y puestos de check-in al aeropuerto
        a.setTren(tren);
        a.setVuelo(vuelo);
        a.setTerminal(ter);
        a.setPuestoCheckIn(puesto);
        //Generamos una lista con numeros del 1 al 100 que usaremos para los numeros de los vuelos
        LinkedList l = new LinkedList();
        for (int j = 0; j <= 100; j++){
            l.add(j);
        }
        //Creamos los vuelos
        for (int i = 0; i < 4; i++){ //Crearemos 4 vuelos
            vuelo[i] = generarVuelo(a, aerolinea, l);
        }
        //Creamos el reloj
        Reloj reloj = new Reloj(a,vuelo);
        Thread rel = new Thread(reloj);
        Thread[] pasajero = new Thread[10];
        //Creamos los pasajeros
        for (int i = 0; i < 10; i++){
            pasajero[i] = new Thread(new Pasajero(i,a,reloj));
        }
        //Iniciamos los pasajeros
        for (int i = 0; i < 10; i++){
            pasajero[i].start();
        }
        //Iniciamos el chofer
        chofer.start();
        //Iniciamos el reloj
        rel.start();
        //iniciamos el guardia
        guardia.start();
    }
        
     public static Vuelo generarVuelo(Aeropuerto aeropuerto, String[] aerolinea, LinkedList l){
        Random r = new Random();
        //Generamos la hora de salida entre las 10 y las 21
        int horaSalida = r.nextInt(10,24);
        //Le asignamos una aerolinea al azar
        String empresa = "";
        int n = aerolinea.length;
        //Elegimos una aerolinea al azar de nuestro arreglo de aerolineas
        empresa = aerolinea[r.nextInt(n)];
        //Le asignamos una terminal de salida al azar
        Terminal terEmbarque;
        Terminal[] t = aeropuerto.getTerminal();
        int i = t.length;
        //Elegimos una terminal al azar de nuestro arreglo de terminales
        terEmbarque = t[r.nextInt(0,i)];
        //Elegimos un puesto de embarque al azar
        int p = terEmbarque.getPrimPuestoEmbarque();
        int u = terEmbarque.getUltPuestoEmbarque();
        //Elegimos un puesto de embarque al azar de los que estan en el arreglo de puestos de la terminal
        int puestoEmbarque = r.nextInt(p,u+1);
        //Tomamos un numero de la lista y lo eliminamos para asegurar que no se repita
        int nroVuelo = (int) l.getFirst();
        l.remove();
        Vuelo v = new Vuelo(terEmbarque, empresa, puestoEmbarque, nroVuelo, horaSalida);
        return v;
     }
}
