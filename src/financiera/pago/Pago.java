/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.pago;

import financiera.common.Model;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Pago implements Model {
    double importe;
    Date fecha;

    public Pago() {
    }

    public Pago(double importe, Date fecha) {
        this.importe = importe;
        this.fecha = fecha;
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
    
    
}
