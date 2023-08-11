/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema06 {
    public static void main(String[]args){
        int primCalif, segCalif, terCalif;
        boolean aprPrim,aprSeg,aprTer,aprMat;
        System.out.println("Ingrese la priemra calificacion");
        primCalif=TecladoIn.readLineInt();
        System.out.println("Ingrese la segunda calificacion");
        segCalif=TecladoIn.readLineInt();
        System.out.println("Ingrese la tercera calificacion");
        terCalif=TecladoIn.readLineInt();
        aprPrim=primCalif>=60;
        aprSeg=segCalif>=60;
        aprTer=terCalif>=60;
        aprMat=aprPrim&&aprSeg&&aprTer;
        System.out.println("El estudiante esta aprobado:"+aprMat);
     
        
    }
    
}
