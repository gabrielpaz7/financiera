/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.persistencia;

import financiera.Financiera;
import financiera.cliente.Cliente;
import financiera.usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Repositorio {
    private static Financiera financiera;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Cliente> clientes;
    
    public static void iniciar() {
        iniciarFinanciera();
        iniciarUsuarios();
        iniciarClientes();
    }
    
    public static void iniciarFinanciera() {
        financiera = new Financiera("a695dcdb-6bb0-4635-be85-39413c3ff6c1",
            "La Financiera", "Financiera S.A.", 999);
    }
    
    public static void iniciarUsuarios(){
        usuarios = new ArrayList<Usuario>();
        
        Usuario usuario = new Usuario("admin", "admin", 1, "Gabriel Paz");
        usuarios.add(usuario);
        
        usuario = new Usuario("user1", "user", 2, "User 1");
        usuarios.add(usuario);
        
        usuario = new Usuario("user2", "user", 3, "User 2");
        usuarios.add(usuario);
    }
    
    public static void iniciarClientes() {
        clientes = new ArrayList<Cliente>();
        
        Cliente cliente = new Cliente(33050255, "Cesar Gabriel Paz", "Rivadavia 1050", "3815982851", 50000);
        clientes.add(cliente);
        
        cliente = new Cliente(33000000, "Cliente Test", "Rivadavia 1050", "3815982851", 50000);
        clientes.add(cliente);
    }

    public static Financiera getFinanciera() {
        return financiera;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }    

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
}
