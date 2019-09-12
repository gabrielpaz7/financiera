/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pago;

import financiera.cliente.Cliente;
import financiera.common.Model;
import financiera.credito.Credito;
import financiera.credito.Cuota;
import financiera.usuario.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Gabriel
 */
public class Pago implements Model {
    int numeroOperacion;
    double importe;
    Date fecha;
    Cliente cliente;
    ArrayList<Credito> creditos;
    Usuario usuario;

    public Pago() {
        creditos = new ArrayList<Credito>();
    }

    public Pago(double importe, Date fecha, Cliente cliente, ArrayList<Credito> creditos) {
        this.importe = importe;
        this.fecha = fecha;
        this.cliente = cliente;
        this.creditos = creditos;
    }

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }
    
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Credito> getCreditos() {
        return creditos;
    }

    public void setCreditos(ArrayList<Credito> creditos) {
        this.creditos = creditos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void pagarCuotas(ArrayList<Credito> creditos) {
        double importePagado = importe;
        for(Credito credito : creditos) {
            if(credito.getEstado().equals(EstadoCredito.MOROSO)) {
                Iterator iter = credito.getCuotas().iterator();
                while(importePagado > 0 && iter.hasNext()) {
                    Cuota cuota = (Cuota) iter.next();
                    importePagado = importePagado - cuota.calcularTotal(importePagado);
                    cuota.setFechaPago(fecha);
                    cuota.setInteresCobrado();
                }
            }
        }
    }
    
}
