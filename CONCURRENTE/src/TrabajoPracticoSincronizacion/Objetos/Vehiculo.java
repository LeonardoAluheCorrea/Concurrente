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
public class Vehiculo{
    private String patente;
    private String modelo;
    private String marca;

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }
    
    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
        
}
