/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.webservice0;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Gabriel
 */
@XmlRootElement(name = "ObtenerEstadoClienteResult")
public class ResultadoEstadoCliente0 {
    boolean tieneDeudas;
    int cantidadCreditosActivos;
    boolean consultaVacia;
    String error;

    public ResultadoEstadoCliente0(boolean tieneDeudas, int cantidadCreditosActivos, boolean consultaVacia, String error) {
        this.tieneDeudas = tieneDeudas;
        this.cantidadCreditosActivos = cantidadCreditosActivos;
        this.consultaVacia = consultaVacia;
        this.error = error;
    }

    @XmlElement(name = "TieneDeudas")
    public boolean isTieneDeudas() {
        return tieneDeudas;
    }

    public void setTieneDeudas(boolean tieneDeudas) {
        this.tieneDeudas = tieneDeudas;
    }

    @XmlElement(name = "CantidadCreditosActivos")
    public int getCantidadCreditosActivos() {
        return cantidadCreditosActivos;
    }

    public void setCantidadCreditosActivos(int cantidadCreditosActivos) {
        this.cantidadCreditosActivos = cantidadCreditosActivos;
    }

    @XmlElement(name = "ConsultaVacia")
    public boolean isConsultaVacia() {
        return consultaVacia;
    }

    public void setConsultaVacia(boolean consultaVacia) {
        this.consultaVacia = consultaVacia;
    }

    @XmlElement(name = "Error")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
     
}
