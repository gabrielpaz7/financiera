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
import financiera.pdf.Populater;
import financiera.persistencia.Repositorio;
import financiera.persistencia.Session;
import financiera.webservice.Webservice;
import static financiera.webservice.Webservice.obtenerEstadoCliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;
import org.tempuri.IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage;
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
        cargarPlanesCuota();
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
    
    public void buscarCliente(int dni) {
        Cliente cliente = null;
        for(Cliente c : Repositorio.getClientes()) {
            if(c.getDni() == dni) {
                int creditosActivos = 0;
                
                try {
                    ResultadoEstadoCliente estadoCliente =  Webservice.obtenerEstadoCliente(Repositorio.getFinanciera().getIdentificador(), dni);

                    if(!estadoCliente.isConsultaValida()) {
                        view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "El servicio externo no pudo validar la situacion financiera del cliente.");
                    } else {
                        creditosActivos = estadoCliente.getCantidadCreditosActivos();
                        validarSituacionFinanciera(c, creditosActivos);
                    }
                } catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }

                view.actualizarDatosCliente(c, creditosActivos);
                cliente = c;
            } 
        }
        
        if(cliente == null) {
            view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "Cliente no encontrado");
            view.limpiarDatosCliente();
        }
        
        model.setCliente(cliente);
    }
    
    private void validarSituacionFinanciera(Cliente cliente, int creditosActivos) {
        if(creditosActivos > 2) {
            view.mostrarMensajeError(JOptionPane.INFORMATION_MESSAGE,
                "Advertencia", 
                "El cliente no puede realizar nuevos creditos.\n"
                        + "\n Cliente: " + cliente.getNombreApellido()
                        + "\n DNI: " + cliente.getDni()
                        + "\n\n Creditos activos: " + creditosActivos + "\n\n\n");
            
            view.limpiarDatosCliente();
            return;
        }
    }
    
    private void cargarPlanesCuota() {
        view.cargarPlanes(Repositorio.getPlanes());
        model.setPlan(Repositorio.getPlanes().get(0));
    }
    
    public void guardarCredito() {
        try {
            model.setFecha(Calendar.getInstance().getTime());
            model.setUsuario(Session.getUsuario());
            
            Random random = new Random();
            model.setNumero(random.nextInt(999));
            model.setCuotas(generarCuotas());
            
            ResultadoOperacion resultado = Webservice.informarCreditoOtorgado(
                Repositorio.getFinanciera().getIdentificador(),
                model.getCliente().getDni(),
                String.valueOf(model.getNumero()),
                model.getCapital());
            
            if(resultado.isOperacionValida()){
                model.setEstado(EstadoCredito.ACTIVO);
                view.mostrarMensajeError(JOptionPane.INFORMATION_MESSAGE, "Información", "Crédito registrado correctamente.");
            } else {
                model.setEstado(EstadoCredito.PENDIENTE_DE_INFORMAR);
                view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "Crédito se registró como \nPENDIENTE DE INFORMAR AL BCRA.");
            }
            
            Repositorio.getCreditos().add(model);
            
        } catch (IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage ex) {
            Logger.getLogger(SolicitarCreditoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<Cuota> generarCuotas() {
        ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
        
        Calendar fechaVencimiento = Calendar.getInstance();
        
        for(int i = 0; i <= model.getNumeroCuotas(); i++) {
            fechaVencimiento.add(Calendar.MONTH, i);
            fechaVencimiento.set(Calendar.DAY_OF_MONTH, 10);
            Cuota cuota = new Cuota(i, model.calcularImporteCuota(), fechaVencimiento.getTime(), EstadoCuota.PENDIENTE);
            model.getCuotas().add(cuota);
        }
        
        return cuotas;
    }
    
    
    public void imprimirComprobanteCredito() {
        try {
            Populater.imprimirComprobanteCredito(model);
        } catch (IOException ex) {
            Logger.getLogger(SolicitarCreditoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(SolicitarCreditoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
