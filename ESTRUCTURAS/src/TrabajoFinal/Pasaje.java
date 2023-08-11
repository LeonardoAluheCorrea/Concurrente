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
public class Pasaje {
    private int nroAsiento;
    private String vuelo;
    private String fecha;
    private String estado;

    public Pasaje(int nroAsiento, String vuelo, String fecha, String estado) {
        this.nroAsiento = nroAsiento;
        this.vuelo = vuelo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(int nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.nroAsiento;
        hash = 61 * hash + Objects.hashCode(this.vuelo);
        hash = 61 * hash + Objects.hashCode(this.fecha);
        return hash;
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
        final Pasaje other = (Pasaje) obj;
        if (this.nroAsiento != other.nroAsiento) {
            return false;
        }
        if (!Objects.equals(this.vuelo, other.vuelo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    @Override
    public Pasaje clone(){
        return new Pasaje(this.nroAsiento, this.vuelo, this.fecha, this.estado);
    }
    
    @Override
    public String toString() {
        return "Pasaje{" + "nroAsiento=" + nroAsiento + ", vuelo=" + vuelo + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
    
}
