/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

/**
 *
 * @author Leo
 */
public class Filmador implements Runnable{
    private Television tele;
    private int cantEpisodios; //Cantidad de episodios que filmara

    public Filmador(Television tele, int cantEpisodios) {
        this.tele = tele;
        this.cantEpisodios = cantEpisodios;
    }

    @Override
    public void run() {
        int i = 1;
        while(i <= cantEpisodios){
            tele.filmar();
            i++;
        }
        System.out.println("La serie termino, no se filmaran mas episodios");
    }
}
