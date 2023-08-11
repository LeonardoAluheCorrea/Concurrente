/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTP5;

/**
 *
 * @author Leo
 */
public class Especie {
    private String nombre;
    private int poblacion;
    private double tasaDeCrecimiento;
    
    public void especie(String nombre){       
    }
    public void especie(String nombre, int poblacion, double tasaDeCrecimiento){        
    }
    
    public String getNombre (){
        return nombre;
    }
    public int getPoblacion (){
        return poblacion;
    }
    public double getTasaDeCrecimiento(){
        return poblacion;
    }
    public String toString(){
        return "Nombre = "+getNombre()+
                "Poblacion = "+getPoblacion()+
                "Tasa De Crecimiento = "+getTasaDeCrecimiento();
    }
    public boolean equals(Especie otroObjeto){
        return nombre.equalsIgnoreCase(otroObjeto.getNombre()) && poblacion == otroObjeto.getPoblacion() &&
                tasaDeCrecimiento == otroObjeto.getTasaDeCrecimiento();
    }
    public int poblacionProyectada (int años){
        int poblacionProyectada;
        poblacionProyectada = (int)((getTasaDeCrecimiento()/100)*getPoblacion())*años;
        return poblacionProyectada;
        
    }
    

    public void setPoblacion(int nuevaPoblacion){
        poblacion = nuevaPoblacion;     
    }
    public void setTasaDeCrecimiento(double nuevoCrecimiento){
        tasaDeCrecimiento = nuevoCrecimiento;
    }
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    
       
    
}
