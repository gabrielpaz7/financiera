/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.common.Model;
import financiera.common.Presenter;
import financiera.common.View;
import financiera.persistencia.Repositorio;
import financiera.webservice.Webservice;
import static financiera.webservice.Webservice.obtenerEstadoCliente;
import javax.swing.JOptionPane;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage;

/**
 *
 * @author Gabriel
 */
public class SolicitarCreditoPresenter implements Presenter {
    SolicitarCreditoView view;
    Credito model;

    public SolicitarCreditoPresenter(SolicitarCreditoView view, Credito model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void setView(View view) {
        this.view = (SolicitarCreditoView) view;
    }

    @Override
    public SolicitarCreditoView getView() {
        return view;
    }

    @Override
    public void setModel(Model model) {
        this.model = (Credito) model;
    }

    @Override
    public Credito getModel() {
        return this.model;
    }

    @Override
    public void updateView() {
        // todo
    }

    @Override
    public void updateModel() {
        // todo
    }
    
    public Cliente buscarCliente(int dni) throws IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage {
        for(Cliente c : Repositorio.getClientes()) {
            System.out.println(c);
            if(c.getDni() == dni) {
                ResultadoEstadoCliente estadoCliente =  Webservice.obtenerEstadoCliente(Repositorio.getFinanciera().getIdentificador(), dni);
            
                if(!estadoCliente.isConsultaValida()) {
                    view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "El servicio externo no pudo validar la situacion financiera del cliente.");
                }
            
                view.actualizarDatosCliente(c, estadoCliente.getCantidadCreditosActivos());
                return c;
            } 
        }
        
        view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "Cliente no encontrado");
        return null;
    }
    
    //private int 
    
    
}
