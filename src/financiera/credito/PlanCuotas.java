/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

/**
 *
 * @author Gabriel
 */
public class PlanCuotas {
    String descripcion;
    String modalidad; // primera cuota vencida - primera cuota adelantada
    double porcentajeMensual;
    double procentajeGastos;

    public PlanCuotas() {
    }

    public PlanCuotas(String descripcion, String modalidad, double porcentajeMensual, double procentajeGastos) {
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.porcentajeMensual = porcentajeMensual;
        this.procentajeGastos = procentajeGastos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getPorcentajeMensual() {
        return porcentajeMensual;
    }

    public void setPorcentajeMensual(double porcentajeMensual) {
        this.porcentajeMensual = porcentajeMensual;
    }

    public double getProcentajeGastos() {
        return procentajeGastos;
    }

    public void setProcentajeGastos(double procentajeGastos) {
        this.procentajeGastos = procentajeGastos;
    }
    
    
}
