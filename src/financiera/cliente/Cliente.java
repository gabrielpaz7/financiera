/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.cliente;

/**
 *
 * @author Gabriel
 */
public class Cliente {
    int dni;
    String nombreApellido;
    String domicilio;
    String telefono;
    double Sueldo;

    public Cliente() {
    }
    
    public Cliente(int dni, String nombreApellido, String domicilio, String telefono, double Sueldo) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.Sueldo = Sueldo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    @Override
    public String toString() {
        return "dni: " + dni + " - nombre: " + nombreApellido;
    }
    
    
    
}
