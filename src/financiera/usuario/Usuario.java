/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.usuario;

/**
 *
 * @author Gabriel
 */
public class Usuario extends Empleado {
    String usuario;
    String password;

    public Usuario() {
        super();
    }

    public Usuario(String usuario, String password, int legajo, String nombreApellido) {
        super(legajo, nombreApellido);
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
