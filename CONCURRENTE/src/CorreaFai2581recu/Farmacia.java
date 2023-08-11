/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Farmacia {
    private Semaphore accesoFichasContables;
    private Semaphore accesoFichasGeneral;
    private Semaphore accesoFichasEncargado;
    private int pizarra; //La pizarra donde se van sumando los importes de las recetas
    private int totalGlobal; //El total que va sumando el encargado de los importes de las recetas
    private Cola fichasContables;
    private Cola fichasGeneral;
    private Cola fichasEncargado;

    public Farmacia(){
        this.accesoFichasGeneral = new Semaphore(1);
        this.accesoFichasContables = new Semaphore(1);
        this.accesoFichasEncargado = new Semaphore(1);
        this.pizarra = 0;
        this.totalGlobal = 0;
        this.fichasGeneral = new Cola();
        this.fichasContables = new Cola();
        this.fichasEncargado = new Cola();
    }
    
    public void hacerFichaGeneral(){
        try {
            //Un auxiliar genera una ficha general a partir de la receta de un cliente
            Random r = new Random();
            Ficha ficha = new Ficha(r.nextInt(10), r.nextInt(3000), r.nextInt(500)); //Generamos la ficha aleatoreamente
            System.out.println("Un auxiliar de farmacia genero una ficha general a partir de una receta y la coloco en el canasto de fichas generales");
            fichasGeneral.poner(ficha); //La deja en el canasto de fichas generales
            accesoFichasGeneral.release(); //Avisa que dejo una ficha en el canasto de fichas generales
        } catch (InterruptedException ex) {
            Logger.getLogger(Farmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tomarFichaGeneral(){
        try {
            //Un auxiliar contable toma una ficha del canasto de fichas generales
            accesoFichasGeneral.acquire();
            Ficha re;
            re = (Ficha) fichasGeneral.obtenerFrente(); //Sacamos la ficha del canasto
            fichasGeneral.sacar();
            if (re != null){
                int n;
                n = re.getImporte();
                pizarra = pizarra + n;
                System.out.println("Un auxiliar tomo una ficha general y sumo su importe (" + n + ") a la pizarra, luego dejo la ficha en el canasto del encargado");
                fichasEncargado.poner(re); //Deja la ficha en el canasto del encargado
                System.out.println("Pizarra: " + pizarra);
            }
            accesoFichasGeneral.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Farmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void tomarFichaContable(){
        try {
            //Un auxiliar contable toma una ficha del canasto de fichas contable
            accesoFichasContables.acquire();
            Ficha fi;
            fi = (Ficha)fichasContables.obtenerFrente(); //Obtenemos la ficha contable del canasto
            fichasContables.sacar();
            if (fi != null){
                int n;
                n = fi.getImporte();
                pizarra = pizarra + n;
                System.out.println("Un auxiliar tomo una ficha contable y sumo su importe (" + n + ") a la pizarra, luego tiro la ficha");
                System.out.println("Pizarra: " + pizarra);
            }
            accesoFichasContables.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Farmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void encargadoTomaFichaGeneral(){
        try {
            //El encargado toma una ficha del canasto de fichas generales
            accesoFichasGeneral.acquire();
            Ficha re;
            re = (Ficha) fichasGeneral.obtenerFrente(); //Sacamos la ficha del canasto
            fichasGeneral.sacar();
            if (re != null){
                int n;
                n = re.getImporte();
                pizarra = pizarra + n;
                System.out.println("El encargado tomo una ficha general y sumo su importe (" + n + ") al total global luego dejo la ficha en el canasto de fichas contables");
                fichasContables.poner(re); //Deja la ficha en el canasto del fichas contables    
                System.out.println("Global total: " + totalGlobal);
            }
            accesoFichasGeneral.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Farmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tomarFichaEncargado(){
        try {
            //El encargado toma una ficha del canasto de fichas encargado
            accesoFichasEncargado.acquire();
            Ficha fi;
            fi = (Ficha) fichasEncargado.obtenerFrente(); //Obtiene la ficha del canasto
            fichasEncargado.sacar();
            if (fi != null){
                int n;
                n = fi.getImporte();
                totalGlobal = totalGlobal + n;
                System.out.println("El encargado toma una ficha de encargado y suma su importe (" + n + ") al total global, luego tira la ficha");
                System.out.println("Global total: " + totalGlobal);
            }
            accesoFichasEncargado.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Farmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
    
