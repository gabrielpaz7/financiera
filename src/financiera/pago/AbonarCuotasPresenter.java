/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pago;

import financiera.cliente.Cliente;
import financiera.common.Model;
import financiera.common.Presenter;
import financiera.common.View;
import financiera.credito.Credito;
import financiera.credito.EstadoCredito;
import financiera.pdf.DocumentoPDF;
import financiera.persistencia.Repositorio;
import financiera.persistencia.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.exceptions.COSVisitorException;
import servicioExterno.webservice.Webservice;

/**
 *
 * @author Gabriel
 */
public class AbonarCuotasPresenter implements Presenter {

    Pago model;
    AbonarCuotasView view;
    ArrayList<Credito> creditos;

    public AbonarCuotasPresenter(Pago model, AbonarCuotasView view) {
        this.model = model;
        this.view = view;

    }

    @Override
    public void setView(View view) {
        this.view = (AbonarCuotasView) view;
    }

    @Override
    public View getView() {
        return this.view;
    }

    @Override
    public void setModel(Model model) {
        this.model = (Pago) model;
    }

    @Override
    public Model getModel() {
        return (Model) model;
    }

    @Override
    public void updateView() {
        //
    }

    @Override
    public void updateModel() {
        //
    }

    public void buscarCreditosPorCliente(Cliente cliente) {
        ArrayList<Credito> creditos = new ArrayList<Credito>();

        for (Credito credito : Repositorio.getCreditos()) {
            System.out.println(credito.toString());
            if (credito.getCliente().getDni() == cliente.getDni()) {
                credito.verificarEstadoCredito();
                creditos.add(credito);
            }
        }

        double recargoDiarioPorVencimiento = Repositorio.getFinanciera().getRecargoDiarioPorVencimiento();
        view.mostarListaCuotas(creditos, recargoDiarioPorVencimiento);
        this.creditos = creditos;
    }

    public void buscarCliente(int dni) {
        boolean encontrado = false;
        Cliente cliente = null;
        for (Cliente c : Repositorio.getClientes()) {
            if (c.getDni() == dni) {
                cliente = c;
                model.setCliente(cliente);
                encontrado = true;
            }
        }
        
        if (encontrado) {
            view.mostrarDatosCliente(cliente);
            buscarCreditosPorCliente(cliente); 
        } else {
            view.mostrarMensajeError(
                    JOptionPane.WARNING_MESSAGE,
                    "Advertencia",
                    "Cliente no encontrado"
            );
        }
    }
    

    public void guardarPago(Double importe) {
        try {
            model.setImporte(importe);
            model.setFecha(Calendar.getInstance().getTime());
            
            Random random = new Random();
            model.setNumeroOperacion(random.nextInt(999));
            
            model.setUsuario(Session.getUsuario());
            
            model.pagarCuotas(this.creditos);           
            
            view.mostrarMensajeError(JOptionPane.INFORMATION_MESSAGE, "Confirmacion", "Pago aceptado.");
            
            DocumentoPDF.imprimirReciboPago(model);
        } catch (IOException ex) {
            Logger.getLogger(AbonarCuotasPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(AbonarCuotasPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
