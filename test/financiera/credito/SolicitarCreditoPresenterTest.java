/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financiera.credito;

import financiera.cliente.Cliente;
import financiera.common.Model;
import financiera.common.View;
import financiera.persistencia.Repositorio;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class SolicitarCreditoPresenterTest {
    
    public SolicitarCreditoPresenter instance;
    
    public SolicitarCreditoPresenterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Repositorio.iniciar();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        SolicitarCreditoView view = new SolicitarCreditoView();
        
        Credito credito = new Credito(123, 10000, 11500);
        credito.setUsuario(Repositorio.getUsuarios().get(0));
        credito.setPlan(Repositorio.getPlanes().get(1));
        credito.setCliente(Repositorio.getClientes().get(1));

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = "10/07/2019";
        Date fechaSolicitud = format.parse(strFecha);
        credito.setFecha(fechaSolicitud);

        credito.setNumeroCuotas(3);
        
        
        instance = new SolicitarCreditoPresenter();
        instance.setModel(credito);
        instance.setView(view);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarCliente method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        int dni = 33000000;
        instance.buscarCliente(dni);
        Cliente expCliente = Repositorio.getClientes().get(1);
        
        assertEquals(expCliente, instance.getModel().getCliente());
    }

    /**
     * Test of guardarCredito method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGuardarCredito() {
        System.out.println("guardarCredito");
        instance.guardarCredito();
    }

    /**
     * Test of generarCuotas method, of class SolicitarCreditoPresenter.
     */
    @Test
    public void testGenerarCuotas() throws ParseException {
        System.out.println("generarCuotas");
        
        
        instance.generarCuotas();
        ArrayList<Cuota> result = instance.getModel().getCuotas();
        
        ArrayList<Cuota> expResult = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = "10/07/2019";
        Date fechaSolicitud = format.parse(strFecha);
        
        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.setTime(fechaSolicitud);
        
        System.out.println("Result");
        for(Cuota cuota : result) {
            System.out.println(cuota.toString());
        }

        System.out.println("Expected");
        for(int i = 1; i <= instance.getModel().getNumeroCuotas(); i++) {
            fechaVencimiento.setTime(fechaSolicitud);
            fechaVencimiento.set(Calendar.DAY_OF_MONTH, 10);
            fechaVencimiento.add(Calendar.MONTH, i);
            
            Cuota cuota = new Cuota(i, instance.getModel().calcularImporteCuota(), fechaVencimiento.getTime(), EstadoCuota.PENDIENTE);
            expResult.add(cuota);
            
            System.out.println(cuota.toString());
        }

        assertArrayEquals(expResult.toArray(), result.toArray());
    }    
}
