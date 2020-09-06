/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoHilos;

/**
 *
 * @author Leo
 */
public class PingPong extends Thread{
    
    private String cadena; // Lo que va a escribir.
    private int delay; // Tiempo entre escritura
    
    public PingPong(String cartel,int cantMs){
        cadena = cartel;
        delay = cantMs;
    };
    
    public void run(){
    for (int i = 1; i < (delay * 10); i++){
        System.out.print(cadena + "");
        try { Thread.sleep(delay);}
        catch(InterruptedException e){
        }
    }
    } //fin método run()
    
    public static void main(String[] args){
        PingPong t1 = new PingPong("PING",33);
        PingPong t2= new PingPong("PONG",10);
        PingPong t3 = new PingPong("PANG",10);
        PingPong t4 = new PingPong("PUNG",10);
        // Activación
        t1.start();
        t2.start();
        // Espera unos segundos
        try{ Thread.sleep(5000);
        }catch (InterruptedException e){};
        // Finaliza la ejecución de los threads
        }
 } //fin clase PingPong