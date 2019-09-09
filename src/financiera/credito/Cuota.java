/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import java.util.Date;


/**
 *
 * @author Gabriel
 */
public class Cuota {
    int numero;
    double importe;
    Date fechaVencimiento;
    Date fechaPago;
    double saldoPendiente;
    double interesCobrado;
    EstadoCuota estado;

    public Cuota() {
    }

    public Cuota(int numero, double importe, Date fechaVencimiento, EstadoCuota estado) {
        this.numero = numero;
        this.importe = importe;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public double getInteresCobrado() {
        return interesCobrado;
    }

    public void setInteresCobrado(double interesCobrado) {
        this.interesCobrado = interesCobrado;
    }

    public EstadoCuota getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuota estado) {
        this.estado = estado;
    }
    
}
