/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.Objetos;

import java.util.Objects;

/**
 *
 * @author Leo
 */
public class Aeropuerto {
    private String nombreAeronautico;
    private String ciudad;
    private String nroTelefono;

    @Override
    public String toString() {
        return "Aeropuerto{" + "nombreAeronautico=" + nombreAeronautico + ", ciudad=" + ciudad + ", nroTelefono=" + nroTelefono + '}';
    }


    public Aeropuerto(String nombreAeronautico) {
        this.nombreAeronautico = nombreAeronautico;
    }
    
    public Aeropuerto(String nombreAeronautico, String ciudad, String nroTelefono) {
        this.nombreAeronautico = nombreAeronautico;
        this.ciudad = ciudad;
        this.nroTelefono = nroTelefono;
    }

    public String getNombreAeronautico() {
        return nombreAeronautico;
    }

    public void setNombreAeronautico(String nombreAeronautico) {
        this.nombreAeronautico = nombreAeronautico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
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
        final Aeropuerto other = (Aeropuerto) obj;
        if (!Objects.equals(this.nombreAeronautico, other.nombreAeronautico)) {
            return false;
        }
        return true;
    }

}
