/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pago;

import financiera.common.Model;
import financiera.common.Presenter;
import financiera.common.View;
import financiera.persistencia.Repositorio;

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
        
        view.mostarListaCuotas(Repositorio.getCreditos());
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
    
    
    
}
