/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

/**
 *
 * @author Leo
 */
public class CadenaLetras implements Runnable {

    private Turno indicador;
    private char letra;
    private int cant;

    public CadenaLetras(Turno indicador, char letra, int cant) {
        this.indicador = indicador;
        this.letra = letra;
        this.cant = cant;
    }

    public void run() {
        if (letra == 'A'){
            indicador.primerTurno();
            for(int i = 0; i < cant; i++){
                System.out.println(letra);
            }
            indicador.finalizarPrimerTurno();
        }
        if (letra == 'B'){
            indicador.segundoTurno();
            for(int i = 0; i < cant; i++){
                System.out.println(letra);
            }
            indicador.finalizarSegundoTurno();
        }
        if(letra == 'C'){
            indicador.tercerTurno();
            for(int i = 0; i < cant; i++){
                System.out.println(letra);
            }
        }
    }
}
