/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.terminal;

import financiera.persistencia.Repositorio;
import financiera.persistencia.Session;
import financiera.webservice.Webservice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Gabriel
 */
public class Terminal {
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread (new SplashView()).start();
        Repositorio.iniciar();
        Session.iniciar();
        
        Webservice.obtenerEstadoCliente(Repositorio.getFinanciera().getIdentificador(), 33000000);
        //Webservice.informarCreditoOtorgado(Repositorio.getFinanciera().getIdentificador(), 33000999, "123456", 25000);
        //Webservice.informarCreditoFinalizado(Repositorio.getFinanciera().getIdentificador(), 33000999, "123456");
    }
}
