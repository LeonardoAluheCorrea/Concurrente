/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

import java.util.Objects;

/**
 *
 * @author Leo
 */
public class Terminal {
    private FreeShop shop;
    private String nombre;
    private int primPuestoEmbarque;
    private int ultPuestoEmbarque;

    public Terminal(FreeShop shop, int primPuestoEmbarque, int ultPuestoEmbarque, String nombre) {
        this.shop = shop;
        this.primPuestoEmbarque = primPuestoEmbarque;
        this.ultPuestoEmbarque = ultPuestoEmbarque;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FreeShop getShop() {
        return shop;
    }

    public void setShop(FreeShop shop) {
        this.shop = shop;
    }

    public int getPrimPuestoEmbarque() {
        return primPuestoEmbarque;
    }

    public void setPrimPuestoEmbarque(int primPuestoEmbarque) {
        this.primPuestoEmbarque = primPuestoEmbarque;
    }

    public int getUltPuestoEmbarque() {
        return ultPuestoEmbarque;
    }

    public void setUltPuestoEmbarque(int ultPuestoEmbarque) {
        this.ultPuestoEmbarque = ultPuestoEmbarque;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public boolean equals(Terminal obj) {
        return  (obj.getNombre() == null ? this.nombre == null : obj.getNombre().equals(this.nombre));
    }
    
}
