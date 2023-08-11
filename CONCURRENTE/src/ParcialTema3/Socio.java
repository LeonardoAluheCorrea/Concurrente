/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

import java.util.Random;

/**
 *
 * @author Leo
 */
public class Socio implements Runnable{
    private Television tele;
    private int id;
    private int lenguajePreferido; //0: ingles, 1: español

    public Socio(Television tele, int id, int lenguajePreferido) {
        this.tele = tele;
        this.id = id;
        this.lenguajePreferido = lenguajePreferido;
    }
    
    @Override
    public void run() {
        int i = 1;
        Random r = new Random();
        try{
            while (true){
                switch(lenguajePreferido){
                    case 0:
                        if (tele.verTraducido(i)){ //Si pudo ver el episodio 
                            System.out.println(id + " vio el episodio " + i + " traducido");
                            i++; //Actualiza su contador de episodios
                        }
                        else{ //Si no estaba disponible todavia
                            System.out.println(id + " sigue con su vida mientras espera el episodio " + i + " traducido");
                            Thread.sleep(r.nextInt(11) * 1000); //Deja pasar un tiempo al azar antes de preguntar de vuelta si esta el episodio
                        }
                        break;
                    case 1:
                        if (tele.verOriginal(i)){ //Si pudo ver el episodio
                            System.out.println(id + " vio el episodio " + i + " en idioma original");
                            i++; //Actualiza su contador de episodios
                        }
                        else{ //Si no estaba disponible todavia
                            System.out.println(id + " sigue con su vida mientras espera el episodio " + i + " en idioma original");
                            Thread.sleep(r.nextInt(11) * 1000); //Deja pasar un tiempo al azar antes de preguntar de vuelta si esta el episodio                            
                        }
                }
            }
        }
        catch(Exception e){          
        }
    }
    
}
