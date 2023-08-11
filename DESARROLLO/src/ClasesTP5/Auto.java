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
public class Auto {
    private String patente;
    private int cuentaKm;
    private String modelo;
    private boolean disponible;
    
    
    public Auto (String pat){
        patente = pat;
    }
    public Auto(String pat, int km, String mod, boolean dispo){
        patente = pat;
        cuentaKm = km;
        modelo = mod;
        disponible = dispo;
    }
    
    
    public void setCuentaKm(int km){
        cuentaKm = km;
    }
    public void setModelo(String mod){
        modelo = mod;
    }
    public void setDisponible(boolean disp){
        disponible = disp;
    }
    
    
    public String getPatente(){
        return patente;
    }
    public int getCuentaKm(){
        return cuentaKm;
    }
    public String getModelo(){
        return modelo;
    }
    public boolean getDisponible(){
        return disponible;
    }
    
    public String toString(){
        return "Patente= "+patente+
                " Cuenta de Km= "+cuentaKm+
                " Modelo= "+modelo+
                " Disponibilidad= "+disponible;
    }
    public boolean equals (Auto a){
        return a.getPatente().equalsIgnoreCase(patente);
    }
}
