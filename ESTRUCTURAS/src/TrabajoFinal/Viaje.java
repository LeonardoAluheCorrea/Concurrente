/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinal;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Leo
 */
public class Viaje {
    private String fecha;
    private int asientosTotales;
    private int asientosVendidos;

    public Viaje(String fecha, int asientosTotales, int asientosVendidos) {
        this.fecha = fecha;
        this.asientosTotales = asientosTotales;
        this.asientosVendidos = asientosVendidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viaje other = (Viaje) obj;
        if (this.asientosTotales != other.asientosTotales) {
            return false;
        }
        if (this.asientosVendidos != other.asientosVendidos) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAsientosTotales() {
        return asientosTotales;
    }

    public void setAsientosTotales(int asientosTotales) {
        this.asientosTotales = asientosTotales;
    }

    public int getAsientosVendidos() {
        return asientosVendidos;
    }

    public void setAsientosVendidos(int asientosVendidos) {
        this.asientosVendidos = asientosVendidos;
    }

    @Override
    public String toString() {
        return "Viaje{" + "fecha=" + fecha + ", asientosTotales=" + asientosTotales + ", asientosVendidos=" + asientosVendidos + '}';
    }
    
}
