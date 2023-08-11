/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Rio {
    private int lobosBebiendo;
    private int corderosBebiendo;
    private int esperaEntrar;
    private int esperaSalir;

    public Rio() {
        this.lobosBebiendo = 0;
        this.corderosBebiendo = 0;
        this.esperaSalir = 0;
        this.esperaEntrar = 0;
    }
    
    public synchronized void llegaLobo(){
        System.out.println("Llega un lobo para beber del rio, hay " + lobosBebiendo);
        lobosBebiendo++;
    }
    
    public synchronized void saleLobo(){
        lobosBebiendo--;
        System.out.println("Un lobo termino de beber, asi que se va, quedan " + lobosBebiendo);   
    }
    
    public synchronized void llegaCordero(){
        //El cordero se acerca al rio;
        if (corderosBebiendo == 0){ ///Si no hay corderos bebiendo del rio
            if(esperaEntrar <= 0) //Ponemos esto afuera del while para que no se repita cuando se despierte el hilo
                System.out.println("Un cordero espera a que llegue otro para ir a beber juntos");
            while(esperaEntrar <= 0){ //Espera hasta que llegue otro cordero
                try {
                    esperaEntrar++;
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Si hay otro cordero esperando entonces van a beber juntos
            esperaEntrar--;
            corderosBebiendo+=2;
            System.out.println("2 corderos entraron a beber, hay " + corderosBebiendo);
            notifyAll(); //Avisan que fueron a beber
        }
        else{ //Si hay corderos bebiendo en el rio entonces se acerca tambien
            corderosBebiendo++;
            System.out.println("Un cordero entra a beber, hay " + corderosBebiendo);
            notifyAll(); //Avisa que entro a beber
        }
    }
    
    public synchronized void saleCordero(){
        //El cordero termino de beber y quiere irse
        if((corderosBebiendo == 2)){ //Si solo hay 2 corderos bebiendo
            if(esperaSalir <= 0) //Ponemos esto afuera del while para que no se repita cuando se despierte el hilo
               System.out.println("Un cordero termino de beber, pero debe esperar a su compañero para irse");
            while(esperaSalir <= 0){ //Si nadie mas esta esperando para salir, espera
                esperaSalir++;
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Un cordero termino de beber y acompaña a su compañero que lo estaba esperando para irse");
            //Si hay otro esperando para salir, salen juntos
            corderosBebiendo-=2;
            esperaSalir--;
            notifyAll(); //Avisan que se fueron
        }
        else{//Si hay mas de 2 corderos bebiendo se va tranquilo
            corderosBebiendo--;
            System.out.println("Un cordero termina de beber y se va, quedan " + corderosBebiendo);
            notifyAll(); //Avisa que se fue
        }
    }
}
