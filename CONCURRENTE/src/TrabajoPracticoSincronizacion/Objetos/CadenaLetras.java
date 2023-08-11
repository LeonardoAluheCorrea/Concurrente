/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion.Objetos;

/**
 *
 * @author Leo
 */
public class CadenaLetras implements Runnable{
    private Turno indicador;
    private int turno;
    private char letra;

    public CadenaLetras(Turno indicador, char letra, int turno) {
        this.indicador = indicador;
        this.letra = letra;
        this.turno = turno;
    }
    
    public void run() {
        int ronda = indicador.getTurno();
        while (ronda > 0){
            if (indicador.getTurno() == turno && ronda > 0){
                for(int j = 1; j <= turno; j++){
                    System.out.println(letra);
                }
                indicador.pasarTurno();
                ronda--;
            }
        }
    }
}
