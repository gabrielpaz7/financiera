/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.usuario;

import financiera.usuario.*;
import javax.swing.JOptionPane;
import financiera.terminal.TerminalView;
import financiera.persistencia.Repositorio;
import financiera.persistencia.Session;

/**
 *
 * @author Gabriel
 */
public class LoginPresenter {
    private LoginView view;
    
    public LoginPresenter(LoginView view){
        this.view = view;
    }
    
    public void login(String usuario, String password){
        
        for(Usuario u : Repositorio.getUsuarios()){   
            if(u.getUsuario().equals(usuario) && u.getPassword().equals(password)){
                System.out.printf("%s ha iniciado sesion %n", u.getNombreApellido());
                Session.setUsuario(u);
                openPrincipal();
                view.dispose();
            }
        }
        
        if(!Session.isIsLogged()){
            JOptionPane.showMessageDialog(view, "Usuario/Contraseña incorrecta");
        }
    }
    
    public void openPrincipal(){
        TerminalView app = new TerminalView();
        app.setVisible(true);
    }
    
}
