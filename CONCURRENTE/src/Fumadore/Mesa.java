/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fumadore;

import java.util.concurrent.LinkedTransferQueue;

/**
 *
 * @author Leo
 */
public class Mesa {
    private LinkedTransferQueue tabaco;
    private LinkedTransferQueue papel;
    private LinkedTransferQueue fosforos;

    public Mesa() {
        this.tabaco = new LinkedTransferQueue();
        this.papel = new LinkedTransferQueue();
        this.fosforos = new LinkedTransferQueue();
    }
    
    public void dejarIngrediente(int i){
        //El agente coloca 2 ingredientes sobre la mesa
        switch(i){
            case 1: //Colocara papel y fosforos sobre la mesa
                papel.add((Integer)1);
                fosforos.add((Integer)1);
                break;
            case 2: //Colocara tabaco y fosforos sobre la mesa
                tabaco.add((Integer)1);
                fosforos.add((Integer)1);
                break;
            case 3: //Colocara tabaco y papel sobre la mesa
                tabaco.add((Integer)1);
                papel.add((Integer)1);
                break;
        }
    }
    
    public void tomarIngredientes(int i){
        //i: representa el ingrediente que ya tiene el fumador
        try{
        switch(i){
            case 1: //Tiene tabaco
                papel.take();
                fosforos.take();
                break;
            case 2: //Tiene papel
                tabaco.take();
                fosforos.take();
                break;
            case 3: //Tiene fosforo
                tabaco.take();
                papel.take();
        }
        }
        catch(Exception e){}
    }
    
}
