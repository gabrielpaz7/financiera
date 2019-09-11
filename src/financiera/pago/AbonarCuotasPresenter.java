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
import financiera.persistencia.Repositorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class AbonarCuotasPresenter implements Presenter {

    Pago model;
    AbonarCuotasView view;

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
                creditos.add(credito);
            }
        }

        double recargoDiarioPorVencimiento = Repositorio.getFinanciera().getRecargoDiarioPorVencimiento();
        view.mostarListaCuotas(creditos, recargoDiarioPorVencimiento);
    }

    public void buscarCliente(int dni) {
        boolean encontrado = false;
        Cliente cliente = null;
        for (Cliente c : Repositorio.getClientes()) {
            if (c.getDni() == dni) {
                cliente = c;
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
    
    /**
     * Verifica las cuotas vencidas y calcula el recargo correspondiente
     * @param credito 
     */
    public void verificarCuotasVencidas(Credito credito) {

        
    }

}
