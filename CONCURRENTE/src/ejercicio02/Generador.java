/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02;

/**
 *
 * @author casa
 */
public class Generador extends Thread{
    private Thread[] atomosH;
    private Thread[] atomosO;
    private Recipiente r;
    
    public Generador(int cantAgua, Recipiente recip){
        atomosH = new Thread[cantAgua*2];
        atomosO = new Thread[cantAgua];
        r = recip;
    }
    
    public void iniciarAtomosH(){
        for (int i = 0; i < atomosH.length; i++) {
            atomosH[i] = new Thread(new Hidrogeno(r), "Hidrogeno "+ (i+1));
        }
    }
    
    public void iniciarAtomosO(){
        for (int i = 0; i < atomosO.length; i++) {
            atomosO[i] = new Thread (new Oxigeno (r), "Oxigeno "+ (i+1));
        }
    }
    
    public void ejecutarAtomosH(){
        for (int i = 0; i < atomosH.length; i++) {
            atomosH[i].start();
        }
    }
    
    public void ejecutarAtomosO(){
        for (int i = 0; i < atomosO.length; i++) {
            atomosO[i].start();
        }
    }
    
    public void run(){
        iniciarAtomosH();
        iniciarAtomosO();
        ejecutarAtomosH();
        ejecutarAtomosO();
    }
}
