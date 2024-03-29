/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.common.Model;
import financiera.usuario.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Credito implements Model {
    int numero;
    double capital;
    double montoTotal;
    double gastos;
    int numeroCuotas;
    Cliente cliente;
    PlanCuota plan;
    EstadoCredito estado;
    Usuario usuario;
    Date fecha;
    ArrayList<Cuota> cuotas;

    public Credito() {
        cuotas = new ArrayList<Cuota>();
    }

    public Credito(int numero, double capital, double montoTotal) {
        this.numero = numero;
        this.capital = capital;
        this.montoTotal = montoTotal;
        this.cuotas = new ArrayList<Cuota>();
    }
    
    public double calcularMontoTotal() {
        double porcentaje = plan.getPorcentajeMensual() * numeroCuotas;
        return (capital * porcentaje/100) + capital;
    }
    
    public double calcularImporteCuota() {
        return calcularMontoTotal() / numeroCuotas;
    }
    
    public double calcularGastos() {
        return (capital * plan.getProcentajeGastos() / 100);
    }
    
    public double calcularTotalEntregado() {
        double totalEntregado = 0;
        
        if(plan.modalidad == PlanCuotaModalidad.PRIMERA_CUOTA_ADELANTADA) {
            totalEntregado = capital - calcularImporteCuota();
        } else {
            totalEntregado = capital - calcularGastos();
        }
        return totalEntregado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PlanCuota getPlan() {
        return plan;
    }

    public void setPlan(PlanCuota plan) {
        this.plan = plan;
    }

    public EstadoCredito getEstado() {
        return estado;
    }

    public void setEstado(EstadoCredito estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public String getStringFecha() {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String strDate = dateFormat.format(fecha);
        return strDate;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public ArrayList<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(ArrayList<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public String toString() {
        return "Credito Nro: " + numero + " - cliente: " + cliente.toString();
    }
    
    
    public EstadoCredito verificarEstadoCredito() {
        int contador = 0;
        for(Cuota cuota : cuotas) {
            if(cuota.getEstado().equals(EstadoCuota.VENCIDA) ||
                cuota.calcularDiasDesdeVencimiento() > 0) {
                contador++;
            }
        }
        
        if(contador >= 2) {
            estado = EstadoCredito.MOROSO;
        }
        
        return estado;
    }
    
    
    
}
