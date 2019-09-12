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
import financiera.credito.EstadoCredito;
import financiera.credito.EstadoCuota;
import financiera.usuario.Usuario;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Credito> creditosPagados = new ArrayList<Credito>();
        double importePagado = importe;
        
        //Collections.sort(creditos);
        
        for(Credito credito : creditos) {
            /*if(credito.getEstado().equals(EstadoCredito.MOROSO)) {
                
            } else {
               
            }*/
            Iterator iter = credito.getCuotas().iterator();
            while(importePagado > 0 && iter.hasNext()) {
                Cuota cuota = (Cuota) iter.next();

                if(importePagado > cuota.getTotal()) {
                   importePagado = importePagado - cuota.getTotal();
                   cuota.setFechaPago(fecha);
                   cuota.setSaldoPendiente(0);
                   cuota.setEstado(EstadoCuota.PAGADA);
                } else {
                    importePagado = importePagado - cuota.getTotal();
                    cuota.setSaldoPendiente(importePagado * (-1));
                    cuota.setFechaPago(fecha);
                    cuota.setEstado(EstadoCuota.PAGADA_PARCIALMENTE);
                } 

            }
            
            this.creditos.add(credito);
            
            if(importePagado <= 0){
                break;
            }
        }
    }

    
}
