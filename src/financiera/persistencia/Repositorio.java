/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.persistencia;

import financiera.Financiera;
import financiera.cliente.Cliente;
import financiera.credito.Credito;
import financiera.credito.PlanCuota;
import financiera.credito.PlanCuotaModalidad;
import financiera.usuario.Usuario;
import financiera.credito.Cuota;
import financiera.credito.EstadoCuota;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Repositorio {
    private static Financiera financiera;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<PlanCuota> planes;
    private static ArrayList<Credito> creditos;
    
    public static void iniciar() {
        iniciarFinanciera();
        iniciarUsuarios();
        iniciarClientes();
        iniciarPlanes();
        iniciarCreditos();
    }
    
    public static void iniciarFinanciera() {
        financiera = new Financiera("a695dcdb-6bb0-4635-be85-39413c3ff6c1",
            "La Financiera", "Financiera S.A.", 999, 0.5);
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
        
        Cliente cliente = new Cliente(33050255, "Gabriel Paz", "Rivadavia 1050", "3815982851", 50000);
        clientes.add(cliente);
        
        cliente = new Cliente(33000000, "John Doe", "Rivadavia 1050", "3815982851", 50000);
        clientes.add(cliente);
        
        cliente = new Cliente(33000999, "Juan Perz", "Rivadavia 1050", "3815982851", 50000);
        clientes.add(cliente);
    }
    
    private static void iniciarPlanes() {
        planes = new ArrayList<PlanCuota>();
        
        PlanCuota plan = new PlanCuota("Plan CUOTA ADELANTADA", PlanCuotaModalidad.PRIMERA_CUOTA_ADELANTADA, 5, 0);
        planes.add(plan);
        
        plan = new PlanCuota("Plan CUOTA VENCIDA", PlanCuotaModalidad.PRIMERA_CUOTA_VENCIDA, 5, 2);
        planes.add(plan);
    }
    
    private static void iniciarCreditos() {
        try {
            creditos = new ArrayList<Credito>();
            
            Credito credito = new Credito(123, 10000, 11500);
            credito.setUsuario(usuarios.get(0));
            credito.setPlan(planes.get(1));
            credito.setCliente(clientes.get(1));
            
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String strFecha = "10/07/2019";
            Date fechaSolicitud = format.parse(strFecha);
            credito.setFecha(fechaSolicitud);
            
            credito.setNumeroCuotas(3);
            
            for(int i = 1; i <= 3; i++) {
                Calendar fechaVencimiento = Calendar.getInstance();
                fechaVencimiento.setTime(fechaSolicitud);
                fechaVencimiento.add(Calendar.MONTH, i);

                Cuota cuota = new Cuota(i, 3833.33, fechaVencimiento.getTime(), EstadoCuota.PENDIENTE);
                credito.getCuotas().add(cuota);
            }
            
            creditos.add(credito);
                        
            
        } catch (ParseException ex) {
            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public static ArrayList<PlanCuota> getPlanes() {
        return planes;
    }  

    public static ArrayList<Credito> getCreditos() {
        return creditos;
    }
}
