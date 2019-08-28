/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.webservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gabriel
 */
@XmlRootElement(name = "ResultadoOperacion")
public class ResultadoOperacion {
    boolean operacionValida;
    String error;

    public ResultadoOperacion(boolean operacionValida, String error) {
        this.operacionValida = operacionValida;
        this.error = error;
    }

    @XmlElement(name = "OperacionValida")
    public boolean isOperacionValida() {
        return operacionValida;
    }

    public void setOperacionValida(boolean operacionValida) {
        this.operacionValida = operacionValida;
    }

    @XmlElement(name = "Error")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
