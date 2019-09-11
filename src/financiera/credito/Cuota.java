/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


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
    
    public int calcularDiasDesdeVencimiento() {
        Calendar fechaActual = Calendar.getInstance();
        long dias = 0;
        if(fechaActual.getTime().getTime() > fechaVencimiento.getTime()) {
            long diffMillies = Math.abs(fechaActual.getTime().getTime() - fechaVencimiento.getTime());
            dias = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);
        } 
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha1: "  + dateFormat.format(fechaActual.getTime()));
        System.out.println("Fecha2: "  + dateFormat.format(fechaVencimiento));
        System.out.println("Cantidad de dias: "  + dias);
        
        if(dias > 0) {
            estado = EstadoCuota.VENCIDA;
        } else {
            estado = EstadoCuota.PENDIENTE;
        }
        
        return (int) dias;
    }
    
    public double calcularImporteRecargo(double recargoDiario) {
        int diasVencimiento = calcularDiasDesdeVencimiento();
        double importeRecargoDiario = importe * (recargoDiario / 100);
        double importeRecargoTotal = importeRecargoDiario * diasVencimiento;
        interesCobrado = importeRecargoTotal;
        return importeRecargoTotal;
    }
    
    public double calcularTotal(double recargoDiario) {
        return interesCobrado + importe;
    }
    
}
