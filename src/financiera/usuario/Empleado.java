/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.usuario;

/**
 *
 * @author Gabriel
 */
public class Empleado {
    int legajo;
    String nombreApellido;

    public Empleado() {
    }

    public Empleado(int legajo, String nombreApellido) {
        this.legajo = legajo;
        this.nombreApellido = nombreApellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }  
}
