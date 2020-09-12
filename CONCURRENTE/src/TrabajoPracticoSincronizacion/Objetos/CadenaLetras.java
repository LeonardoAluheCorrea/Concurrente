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
    char letra;

    public CadenaLetras(Turno indicador, char letra) {
        this.indicador = indicador;
        this.letra = letra;
    }
    
    public void run() {
        int ronda = 1;
        try{
            while (ronda > 0){
                switch(letra){
                    case'A':
                        if (indicador.getTurno() == 0){
                            System.out.println(letra);
                            indicador.pasarTurno(1);
                        }
                        else{
                            Thread.sleep(3000);
                        }
                        break;
                    case'B':
                        if (indicador.getTurno() == 1){
                            System.out.println(letra + letra);
                            indicador.pasarTurno(2);
                        }
                        else{
                            Thread.sleep(3000);
                        }
                        break;
                    case'C':
                        if (indicador.getTurno() == 3){
                            System.out.println(letra + letra + letra);
                            indicador.pasarTurno(3);
                        }
                        else{
                            Thread.sleep(3000);
                        }
                        break;
                }
                ronda = indicador.getRepeticiones();
            }
        }catch(InterruptedException e){}
    }
}
