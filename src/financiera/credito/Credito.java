/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.common.Model;
import financiera.usuario.Usuario;

/**
 *
 * @author Gabriel
 */
public class Credito implements Model {
    int numero;
    
    double capital;
    double importeTotal;
    EstadoCredito estado;
    Usuario usuario;

    public Credito() {
    }

    public Credito(int numero, double capital, double importeTotal) {
        this.numero = numero;
        this.capital = capital;
        this.importeTotal = importeTotal;
    }    
}
