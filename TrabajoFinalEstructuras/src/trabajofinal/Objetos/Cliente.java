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
public class Cliente {
    private ClavePersona clave;
    private String nroTelefono;
    private String domicilio;
    private String nombreApellido;
    private String fechaNacimiento;

    public Cliente(ClavePersona clave, String nroTelefono, String domicilio, String nombreApellido, String fechaNacimiento) {
        this.clave = clave;
        this.nroTelefono = nroTelefono;
        this.domicilio = domicilio;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public ClavePersona getClave() {
        return clave;
    }

    public void setClave(ClavePersona clave) {
        this.clave = clave;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente clone(){
        return new Cliente(this.clave, this.nroTelefono, this.domicilio, this.nombreApellido, this.fechaNacimiento);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.clave);
        hash = 23 * hash + Objects.hashCode(this.nroTelefono);
        hash = 23 * hash + Objects.hashCode(this.domicilio);
        hash = 23 * hash + Objects.hashCode(this.nombreApellido);
        hash = 23 * hash + Objects.hashCode(this.fechaNacimiento);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clave=" + clave.toString() + ", nroTelefono=" + nroTelefono + ", domicilio=" + domicilio + ", nombreApellido=" + nombreApellido + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

   

}


