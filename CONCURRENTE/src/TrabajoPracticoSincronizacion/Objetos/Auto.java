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
public class Auto extends Vehiculo {
    private double capacidadCombustible;
    private double combustibleRestante;

    public Auto(String patente, String modelo, double kmFaltantesParaService, String marca) {
        super(patente, modelo, kmFaltantesParaService, marca);
    }

    public Auto(String modelo,double capacidadCombustible) {
        super(modelo);
        this.capacidadCombustible = capacidadCombustible;
        this.combustibleRestante = capacidadCombustible;
    }

    public Auto(double capacidadCombustible, double combustibleRestante, String patente, String modelo, double kmFaltantesParaService, String marca) {
        super(patente, modelo, kmFaltantesParaService, marca);
        this.capacidadCombustible = capacidadCombustible;
        this.combustibleRestante = combustibleRestante;
    }
    
    public void recorrerDistancia(double distancia){
        combustibleRestante = distancia/2;
    }

    public double getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(double capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCombustibleRestante() {
        return combustibleRestante;
    }

    public void setCombustibleRestante(double combustibleRestante) {
        this.combustibleRestante = combustibleRestante;
    }
    
    public void llenarTanque(){
        combustibleRestante = capacidadCombustible;
    }
    
}
