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
import javax.swing.JOptionPane;

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
    
    public Cliente buscarCliente(int dni) {
        for(Cliente c : Repositorio.getClientes()) {
            System.out.println(c);
            if(c.getDni() == dni) {
                return c;
            }
        }
        
        view.mostrarMensajeError(JOptionPane.WARNING_MESSAGE, "Advertencia", "Usuario no encontrado");
        return null;
    }
    
    //private int 
    
    
}
